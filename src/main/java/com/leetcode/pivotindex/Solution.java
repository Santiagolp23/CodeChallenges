package com.leetcode.pivotindex;

import java.util.Arrays;

public class Solution {
    public int pivotIndex(int[] nums) {
        int leftSum = 0, sum = Arrays.stream(nums).sum();

        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                leftSum += nums[i - 1];
            }
            if (leftSum == sum - leftSum - nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
