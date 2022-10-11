package com.leetcode.validparentheses;

import java.util.ArrayList;
import java.util.Stack;

/*
Taken from: https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
*/

public class Solution {

    public boolean isValid(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        Stack<Character> stack = new Stack<>();
        ArrayList<Boolean> isValid = new ArrayList<>();

        for (int i = 0; i < stringBuilder.length(); i++) {
            char x = stringBuilder.charAt(i);
            if (x == '{' || x == '[' || x == '(') {
                stack.push(x);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (x) {
                    case '}':
                        if (stack.peek() == '{') {
                            stack.pop();
                            break;
                        }
                        return false;
                    case ']':
                        if (stack.peek() == '[') {
                            stack.pop();
                            break;
                        }
                        return false;
                    case ')':
                        if (stack.peek() == '(') {
                            stack.pop();
                            break;
                        }
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}