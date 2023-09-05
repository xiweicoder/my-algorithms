package com.lfs.dp;


import java.util.Arrays;

public class test {
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }

            res = Math.max(dp[i], res);
        }
        return res;
    }
}
