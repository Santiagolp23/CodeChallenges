package com.leetcode.lengthoflastword;

public class Solution {

    public StringBuilder stringBuilderOfLastWord(String s) {
        StringBuilder lastWord = new StringBuilder();
        char sChar;

        for (int i = s.length() - 1; i >= 0; i--) {
            sChar = s.charAt(i);
            if (sChar == ' ' && lastWord.length() == 0) {
                return stringBuilderOfLastWord(s.substring(0, i));
            } else if (sChar != ' ') {
                lastWord.append(sChar);
            } else break;
        }
        return lastWord;
    }


    public int lengthOfLastWord(String s) {
        return stringBuilderOfLastWord(s).length();
    }
}