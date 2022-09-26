package com.hackerearth.royshopping;

/*
Taken from: https://www.hackerearth.com/practice/math/number-theory/primality-tests/practice-problems/algorithm/roy-and-shopping-20/

Alfi asked Roy to go for shopping with her. Witty Roy came up with a condition. He said, for each product of MRP (Maximum Retail Price) R, she'll have to pay minimum of all the prime factors of R and he himself will pay rest of the amount. Without giving it a second thought Alfi agreed.

Now they bought N number of products. You're to find how much money did Roy had to pay for each product.

Input:

First line will contain integer N, number of products they bought.

Next N lines each will contain R, MRP of each product.

Output:

Print single integer in a new line, the amount of money Roy had to pay for each product.

Constraints:

2<=N,R<=1000000

*/


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class RoyShopping {
    public static void main(String[] args) throws Exception {

        class Product {
            private int priceOfProduct;

            public int getPriceOfProduct() {
                return priceOfProduct;
            }

            public Product(int priceOfProduct) {
                this.priceOfProduct = priceOfProduct;
            }

            public ArrayList<Integer> getPrimeFactorsOfPrice() {
                int n = getPriceOfProduct(); // Have to use primitive type and not directly manipulate the object's values
                ArrayList<Integer> primeNumbersFromPrice = new ArrayList<>();
                if (n > 0) {
                    while (n % 2 == 0) {
                        primeNumbersFromPrice.add(2);
                        n /= 2;
                    }

                    for (int i = 3; i <= Math.sqrt(n); i += 2) {
                        while (n % i == 0) {
                            primeNumbersFromPrice.add(i);
                            n /= i;
                        }
                    }
                    if (n > 2) primeNumbersFromPrice.add(n);
                }

                return primeNumbersFromPrice;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        int numOfProducts = Integer.parseInt(br.readLine());

        if (numOfProducts >= 2) {
            Product[] products = new Product[numOfProducts];


            for (int i = 0; i < numOfProducts; i++) {
                products[i] = new Product(Integer.parseInt(br.readLine()));

                if (products[i].getPriceOfProduct() <= 1000000) {

                    ArrayList<Integer> primeFactorsOfCurrentObject = products[i].getPrimeFactorsOfPrice();

                    int minPrimeFactor = products[i].getPriceOfProduct();

                    for (int currentPrimeFactor : primeFactorsOfCurrentObject) {
                        if (minPrimeFactor > currentPrimeFactor) {
                            minPrimeFactor = currentPrimeFactor;
                        }
                    }
                    bos.write(Integer.toString(products[i].getPriceOfProduct() - minPrimeFactor).getBytes());
                    bos.write(("\n").getBytes());
                }

            }
            bos.flush();
        }
    }
}