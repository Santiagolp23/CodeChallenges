package com.hackerearth.arpaslandattack;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Arpasland {

    private static boolean allTrue (ArrayList<Boolean> values) {
        for (boolean value : values) {
            if (!value)
                return false;
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
                    isCodeValid.set(i,isSumEven.apply((int) currentChar, (int) codeStringBuilder.charAt(i - 1)));
                } else {
                    wasPreviousCharANumberAndNOTADash = false;
                    isCodeValid.set(i,!isVowel.test(currentChar));
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