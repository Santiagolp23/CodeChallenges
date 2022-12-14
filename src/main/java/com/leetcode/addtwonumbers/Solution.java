package com.leetcode.addtwonumbers;

import java.math.BigInteger;

// Problem taken from https://leetcode.com/problems/add-two-numbers/description/

public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder l1Builder = new StringBuilder();
        StringBuilder l2Builder = new StringBuilder();
        ListNode currentNode = l1;
        l1Builder.append(currentNode.val);


        while (currentNode.next != null) {
            currentNode = currentNode.next;
            l1Builder.append(currentNode.val);
        }

        currentNode = l2;
        l2Builder.append(currentNode.val);

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            l2Builder.append(currentNode.val);
        }

        BigInteger l1Number = new BigInteger(l1Builder.reverse().toString());
        BigInteger l2Number = new BigInteger(l2Builder.reverse().toString());


        String sum = String.valueOf(l1Number.add(l2Number));

        ListNode result = new ListNode();
        result.val = Character.getNumericValue(sum.charAt(sum.length() - 1));
        ListNode lastNode = result;


        for (int i = sum.length() - 2; i >= 0; i--) {

            if (i == sum.length() - 1) {
                result.val = Character.getNumericValue(sum.charAt(i));
            }
            lastNode.next = new ListNode(Character.getNumericValue(sum.charAt(i)));
            lastNode = lastNode.next;
        }

        return result;
    }
}