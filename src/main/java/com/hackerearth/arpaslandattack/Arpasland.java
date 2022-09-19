package com.hackerearth.arpaslandattack;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Arpasland {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);

        String code = br.readLine();
        StringBuilder codeStringBuilder = new StringBuilder(code);
        boolean isCodeValid = false;
        boolean wasPreviousCharaNumber = false;

        Predicate<Character> isVowel = x -> x.equals("A") || x.equals("E") || x.equals("I") || x.equals("O") || x.equals("U") || x.equals("Y");
        Predicate<Character> isNumber = x -> x.equals("0") || x.equals("1") || x.equals("2") || x.equals("3") || x.equals("4") || x.equals("5") || x.equals("6") || x.equals("7") || x.equals("8") || x.equals("9");
        BiFunction<Integer, Integer, Boolean> isSumEven = (Integer T, Integer U) -> (T + U) % 2 == 0;

        for (int i = 0; i < codeStringBuilder.length(); i++) {
            Character currentChar = codeStringBuilder.charAt(i);
            if (isCodeValid) {
                if (currentChar != '-') {
                    if (wasPreviousCharaNumber == false) {
                        if (isNumber.test(currentChar)) {
                            wasPreviousCharaNumber = true;
                        } else {
                            isCodeValid = isVowel.test(currentChar);
                        }
                    } else if (isNumber.test(currentChar)) {
                        isCodeValid = isSumEven.apply((int) currentChar, (int) codeStringBuilder.charAt(i - 1));
                    } else {
                        isCodeValid = isVowel.test(currentChar);
                    }
                }
            } else {
                isCodeValid = false;
            }
        }

        if (isCodeValid) {
            bos.write("valid".getBytes());
        } else {
            bos.write("invalid".getBytes());
        }
        bos.flush();
    }
}