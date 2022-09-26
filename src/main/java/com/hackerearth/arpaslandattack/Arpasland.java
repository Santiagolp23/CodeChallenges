package com.hackerearth.arpaslandattack;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Arpasland {
    /*
    Taken from: https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/cartag-948c2b02/

    Arpasland has surrounded by attackers. A truck enters the city. The driver claims the load is food and medicine from Iranians.
    Ali is one of the soldiers in Arpasland. He doubts about the truck, maybe it's from the siege.
    He knows that a tag is valid if the sum of every two consecutive digits of it is even and its letter is not a vowel. Determine if the tag of the truck is valid or not.
    We consider the letters "A","E","I","O","U","Y" to be vowels for this problem.
    Input Format

    The first line contains a string of length 9. The format is "DDXDDD-DD", where D stands for a digit (non zero) and X is an uppercase english letter.
    Output Format

    Print "valid" (without quotes) if the tag is valid, print "invalid" otherwise (without quotes)
    */

    private static boolean allTrue(ArrayList<Boolean> values) {
        for (boolean value : values) {
            if (!value) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        String code = br.readLine();
        StringBuilder codeStringBuilder = new StringBuilder(code);
        ArrayList<Boolean> isCodeValid = new ArrayList<>(codeStringBuilder.length());
        boolean repeatDo = true;
        boolean wasPreviousCharANumberAndNOTADash = false;

        Predicate<Character> isVowel = x -> x.equals('A') || x.equals('E') || x.equals('I') || x.equals('O') || x.equals('U') || x.equals('Y');
        Predicate<Character> isNumber = x -> x.equals('0') || x.equals('1') || x.equals('2') || x.equals('3') || x.equals('4') || x.equals('5') || x.equals('6') || x.equals('7') || x.equals('8') || x.equals('9');
        BiFunction<Integer, Integer, Boolean> isSumEven = (Integer T, Integer U) -> (T + U) % 2 == 0;

        for (int i = 0; i < codeStringBuilder.length(); i++) {
            Character currentChar = codeStringBuilder.charAt(i);
            isCodeValid.add(true);
            //You need to check if every all the return values are true every time the loop runs

            if (currentChar != '-') {
                if (wasPreviousCharANumberAndNOTADash == false) {
                    if (isNumber.test(currentChar)) {
                        wasPreviousCharANumberAndNOTADash = true;
                    } else isCodeValid.set(i, !isVowel.test(currentChar));
                } else if (isNumber.test(currentChar)) {
                    isCodeValid.set(i, isSumEven.apply((int) currentChar, (int) codeStringBuilder.charAt(i - 1)));
                } else {
                    wasPreviousCharANumberAndNOTADash = false;
                    isCodeValid.set(i, !isVowel.test(currentChar));
                }
            } else wasPreviousCharANumberAndNOTADash = false;
        }

        if (allTrue(isCodeValid)) {
            bos.write("valid".getBytes());
        } else {
            bos.write("invalid".getBytes());
        }
        bos.flush();
    }
}