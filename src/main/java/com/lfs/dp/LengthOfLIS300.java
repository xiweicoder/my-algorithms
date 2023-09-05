package com.lfs.dp;

import java.util.Arrays;

/*
    最长递增子序列
 */
public class LengthOfLIS300 {
    /*
        输入：nums = [10,9,2,5,3,7,101,18]
        输出：4
        解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
     */
     /*
        1.状态定义:
            dp[i]: 以nums[i]为结尾的最长递增子序列的长度
        2.递推公式:
            dp[i] = Math.max(dp[i], dp[j] + 1);

        3.初始化:
            初始值都为1
            最小为1,dp[0] = 1 不连续的话也是1,不可能长度再小

        4.遍历顺序
            从小到大
     */
    /*
        j i
        i在前,j在后面
        dp[i] > dp[j] 前面大于后面长度就+1 保存一次长度序列到res(求最大值)
        因为他不是连续的他会有间隔所以我们要判断 每个数与i的大小 i大就+1,不大就不动
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
