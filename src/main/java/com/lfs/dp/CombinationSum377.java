package com.lfs.dp;

/*
    组合总和4
 */
public class CombinationSum377 {
    /*
        本题与518正好相反，本题是先遍历背包再物品
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;
        for (int j = 0; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }
}
