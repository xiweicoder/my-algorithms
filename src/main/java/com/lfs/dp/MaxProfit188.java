package com.lfs.dp;

/*
    188. 买卖股票的最佳时机 IV
    进行K次交易(也就是有2K次买卖)
    本题是123的上位替代
 */
public class MaxProfit188 {
    /*
        1.状态定义:dp[prices.length][2k+1] 完成k次交易就要有2k的买入卖出,从0开始定义大小为2k+1
        2.递推公式:
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
        dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
        dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);

        3.初始化:
            参考123题,123题我们直接将所有状态都列出来了,但这题不行,所以我们通过for循环将第0天的状态初始化
            初始化过程与123题一样(相当于在同一天买入卖出)

        4.遍历顺序
            从1开始，0我们已经初始化了
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) return 0;

        // [天数][股票状态]
        // 股票状态: 奇数表示第 k 次交易持有/买入, 偶数表示第 k 次交易不持有/卖出, 0 表示没有操作
        int len = prices.length;
        int[][] dp = new int[len][k * 2 + 1];

        // dp数组的初始化, 与版本一同理 从1开始 1是买入
        for (int i = 1; i < k * 2; i += 2) {
            dp[0][i] = -prices[0];
        }

        /*
            i控制天数
            j控制股票状态 都应该从1开始,从1开始才有意义,0的情况我们初始化了
         */
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < k * 2; j += 2) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] + prices[i]);
            }
        }
        return dp[len - 1][k * 2];
    }
}
