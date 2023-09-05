package com.lfs.dp;

import java.util.Arrays;

/*
    674. 最长连续递增序列
 */
public class FindLengthOfLCIS674 {
    /*
       本题是连续的,我们就保证i 大于 i-1 即可 不用管前面如何
       还要注意 初始化 res = 1 因为本题是 i 与 i-1 的 操作,因为我们i是从1开始,如果传过来的nums数组长度只有1,就不走循环了,所以答案初始化为1即可
       1.状态定义:
           dp[i]: 以nums[i]为结尾的最长递增子序列的长度
       2.递推公式:
           dp[i] = dp[i - 1] + 1;

       3.初始化:
           初始值都为1
           最小为1,dp[0] = 1 不连续的话也是1,不可能长度再小

       4.遍历顺序
           从小到大
    */
    public int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
