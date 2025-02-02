package com.lfs.dp;

/*
    买卖股票的最佳时机
    一次交易
 */
public class MaxProfit121 {
    /*
        输入：[7,1,5,3,6,4] 某天的股票价格
        输出：5
        只能买卖一次

        dp[i][0]：规定了今天不持股，有以下两种情况：
        昨天不持股，今天什么都不做；
        昨天持股，今天卖出股票（现金数增加），

        dp[i][1]：规定了今天持股，有以下两种情况：
        昨天持股，今天什么都不做（现金数与昨天一样）；
        昨天不持股，今天买入股票（注意：只允许交易一次，因此手上的现金数就是当天的股价的相反数）。

        下标为 i 的这一天的计算结果包含了区间 [0, i] 所有的信息，因此最后输出 dp[len - 1][0]
     */

    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 特殊判断
        if (len < 2) {//只有一天不买就是最赚
            return 0;
        }
        int[][] dp = new int[len][2];// [天数][状态]

        // dp[i][0] 下标为 i 这天结束的时候，不持股，手上拥有的现金数
        // dp[i][1] 下标为 i 这天结束的时候，持股，手上拥有的现金数

        // 初始化：不持股显然为 0，持股就需要减去第 1 天（下标为 0）的股价
        dp[0][0] = 0;//第0天不持股
        dp[0][1] = -prices[0];//第0天持股

        // 从第 2 天开始遍历
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);

            /*
                应该是因为只允许交易一次，而初始现金是0，所以一直没交易过，昨天不持股今天持股之后手上的现金只剩-prices[i]了。
                实际上 dp[i-1][0]表示的是前面 i-1天交易一次，能获得的最大利润，放这里你就交易不止一次了
                只要是dp[i-1][0]不是0，就说明已经进行过一次买进一次卖出了，由于只允许交易一次，所以要是还想买进的话必须保证dp[i-1][0]为0，因此直接写为-prices[i]
             */
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);//这里不能写dp[i-1][0] - price[i]
        }
        return dp[len - 1][0];
    }
}
