package com.leetcode.isomorphicstrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder(s.length());

        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                Character sChar = s.charAt(i), tChar = t.charAt(i);

                if (!(map.containsKey(sChar)) && !(map.containsValue(tChar))) {
                    map.put(sChar, tChar);
                    stringBuilder.append(tChar);

                } else {
                    stringBuilder.append(map.get(sChar));
                }

            }
            return stringBuilder.toString().equals(t);
        }
        return false;
    }
}
