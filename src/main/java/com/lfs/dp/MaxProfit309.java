package com.lfs.dp;

/*
    股票买卖含冷冻期
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天) 进行多笔交易
    [1, 2, 3, 0,2]
     买 卖 冷 买 卖 输出: 3
 */
public class MaxProfit309 {
    /*
        1.状态定义:
            dp[i][0]: 持有股票的状态
            dp[i][1]: 保持卖出股票的状态
            dp[i][2]: 卖出股票的状态
            dp[i][3]: 冷冻期
            2 3 1  冷冻期前: 卖出股票的状态; 冷冻期后: 保持卖出股票的状态
        2.递推公式:
       //todo

        3.初始化:


        4.遍历顺序

     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], -prices[1]);

        for (int i = 2; i < prices.length; i++) {
            // dp公式
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
