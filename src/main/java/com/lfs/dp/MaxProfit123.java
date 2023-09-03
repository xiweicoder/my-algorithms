package com.lfs.dp;

/*
    123. 买卖股票的最佳时机 III
    至多两次交易
 */
public class MaxProfit123 {
    /*
        输入：prices = [3,3,5,0,0,3,1,4]
        输出：6
        解释: 0买入 3卖出 +3; 1买入 4卖出 +3 = +6   这里的0买入等买入卖出操作不是天数只是股票数
     */
    /*
        1.状态定义:dp[i][j] 第i天持有的现金
        2.递推公式:
        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
        dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
        dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);


        3.初始化:
            dp[0][0] = 0; 没操作就是0
            dp[0][1] = -prices[0];   上来就买入 手上现金就是负的
            dp[0][2] = 0; 当天买了又卖出
            dp[0][3] = -prices[0];  当天买卖了 第二次买入就是负的
            dp[0][4] = 0; 当天买了又卖出

        4.遍历顺序
            从1开始，0我们已经初始化了
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        // 边界判断, 题目中 length >= 1, 所以可省去
        if (prices.length == 0) return 0;

        /*
          定义 5 种状态:
          0: 没有操作, 1: 第一次买入, 2: 第一次卖出, 3: 第二次买入, 4: 第二次卖出
          i表示第i天，后面的数字表示进行的操作
             dp[i][0]
             dp[i][1]   (其实是第一次持有,可能不是当天买入的)
             dp[i][2]
             dp[i][3]   ...
             dp[i][4]
         */
        int[][] dp = new int[len][5];
        dp[0][1] = -prices[0];
        // 初始化第二次买入的状态是确保 最后结果是最多两次买卖的最大利润
        dp[0][3] = -prices[0];

        for (int i = 1; i < len; i++) {
            /*
                买入(持有)就 减去; 卖出(不持有)就 加钱
                第i天买入，前一天一定是卖出的状态; 同理第i天卖出，前一天一定是买入的状态
                第一次持有时: 延续前一天的状态(前一天就是持有的); 当天买入(第i天买入),同时前一天没有操作才能保证第i天进行买入的操作
                我们需要用前一天减去第i天的价格，但因为我们是第一次持有，本身没有持有钱，所以直接 -prices[i]
             */
//            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

            /*
                同理,不持有 :1、延续前一天的不持有操作 2、第i天卖出 获得钱,对应就是前一天 + 第i天卖出获得的钱
             */
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[len - 1][4];//第二次卖出的一定就是最大值了
    }

/*    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 第 2 维的 0 没有意义，1 表示交易进行了 1 次，2 表示交易进行了 2 次
        // 为了使得第 2 维的数值 1 和 2 有意义，这里将第 2 维的长度设置为 3
        int[][][] dp = new int[len][3][2];

        // 理解如下初始化
        // 第 3 维规定了必须持股，因此是 -prices[0]
        dp[0][1][1] = -prices[0];
        // 还没发生的交易，持股的时候应该初始化为负无穷
        dp[0][2][1] = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            // 转移顺序先持股，再卖出
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
        }
        return Math.max(dp[len - 1][1][0], dp[len - 1][2][0]);
    }*/
}
