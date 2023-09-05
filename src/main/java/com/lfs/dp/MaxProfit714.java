package com.lfs.dp;

/*
    买卖股票的最佳时机
    无限次买卖含手续费
 */
public class MaxProfit714 {
    /*
        输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
        输出：8
        1买入 8卖出 7-2 = 5;    4买入 9卖出 9-4-2 = 3   最终利益: 5+3=8

        卖出股票时减去手续费,与买卖股票2基本一样就多了减去fee
     */
    public int maxProfit(int[] prices, int fee) {
        int len = prices.length;
        // 0 : 持股（买入）
        // 1 : 不持股（售出）
        // dp 定义第i天持股/不持股 所得最多现金
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i] - fee, dp[i - 1][1]);
        }
        return Math.max(dp[len - 1][0], dp[len - 1][1]);
    }
}
