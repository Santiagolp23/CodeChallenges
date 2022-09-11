package com.hackerearth.zoos;
/*
Problem
You are required to enter a word that consists of  and  that denote the number of Zs and Os respectively. The input word is considered similar to word zoo if .

Determine if the entered word is similar to word zoo.

For example, words such as zzoooo and zzzoooooo are similar to word zoo but not the words such as zzooo and zzzooooo.

Input format

First line: A word that starts with several Zs and continues by several Os.
Note: The maximum length of this word must be .
Output format

Print Yes if the input word can be considered as the string zoo otherwise, print No.
*/

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Zoos {


    public static void main(String[] args) throws Exception {
        String word;
        boolean isZoo = false;
        int numberOfZs = 0, numberOfOs = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream bos = new BufferedOutputStream(System.out);
        word = br.readLine();
        if (word.length() <= 20) {
            StringBuilder stringBuilder = new StringBuilder(word);

            for (int i = 0; i < stringBuilder.length(); i++) {
                Character currentChar = stringBuilder.charAt(i);
                if (currentChar == 'z') numberOfZs += 1;
                else if (currentChar == 'o') numberOfOs += 1;
            }

            if (numberOfZs > 0 && numberOfOs > 0 && numberOfZs * 2 == numberOfOs) isZoo = true;

            if (isZoo) bos.write("Yes".getBytes());
            else bos.write("No".getBytes());
            bos.flush();
        }
    }
}
