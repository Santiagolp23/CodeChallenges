package com.leetcode.pivotindex;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int pivotIndex(int[] nums) {
        Integer result = null;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> right = new ArrayList<>();
            List<Integer> left = new ArrayList<>();
            int leftSum = 0, rightSum = 0;

            for (int j = 0; j < i; j++) {
                left.add(nums[j]);
            }

            for (int num : left) {
                leftSum += num;
            }

            for (int j = i + 1; j < nums.length; j++) {
                if (j > nums.length) {
                    right.add(0);
                } else {
                    right.add(nums[j]);
                }
            }

            for (int num : right) {
                rightSum += num;
            }

            if (leftSum == rightSum) {
                result = i;
                return result;
            } else {
                result = -1;
            }
        }
        return result;
    }
}
