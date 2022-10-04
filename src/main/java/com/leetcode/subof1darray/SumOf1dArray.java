package com.leetcode.subof1darray;
/*
Taken from: https://leetcode.com/problems/running-sum-of-1d-array/

Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
Return the running sum of nums.


 */
public class SumOf1dArray {
    public static int[] runningSum(int[] nums) {
        int[] values = new int[nums.length];
        int[] local = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                local[i] = nums[j];
            }
            for (int num : local) {
                values[i] += num;
            }
        }
        return values;
    }
}
