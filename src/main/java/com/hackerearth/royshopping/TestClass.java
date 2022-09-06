package com.hackerearth.royshopping;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

class TestClass {
    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfProducts = Integer.parseInt(br.readLine());

        class Product {
            public int priceOfProduct;

            public Product(int priceOfProduct) {
                this.priceOfProduct = priceOfProduct;
            }

            public ArrayList<Integer> getPrimeFactorsOfPrice() {
                ArrayList<Integer> primeNumbers = new ArrayList<>();
                while (priceOfProduct % 2 == 0) {
                    primeNumbers.add(priceOfProduct);
                    priceOfProduct /= 2;
                }
                for (int i = 3; i <= Math.sqrt(priceOfProduct); i += 2) {
                    while (priceOfProduct % i == 0) {
                        primeNumbers.add(priceOfProduct);
                        priceOfProduct /= i;
                    }
                }
                if (priceOfProduct > 2) {
                    primeNumbers.add(priceOfProduct);
                }
                return primeNumbers;
            }
        }

        Product[] products = new Product[2];

        for (int i = 0; i < numOfProducts; i++) {
            products[i] = new Product(Integer.parseInt(br.readLine()));

            ArrayList<Integer> primeFactorsOfCurrentObject = products[i].getPrimeFactorsOfPrice();
            int minPrimeFactor = products[i].priceOfProduct;

            for (int currentPrimeFactor : primeFactorsOfCurrentObject) {
                if (currentPrimeFactor < minPrimeFactor) {
                    minPrimeFactor = currentPrimeFactor;
                }

            }

            System.out.println(minPrimeFactor);

        }
    }

}

