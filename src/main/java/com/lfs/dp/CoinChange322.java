package com.lfs.dp;

import java.util.Arrays;

/*
    零钱兑换
 */
public class CoinChange322 {
    /*
        1.状态定义:dp[j] 装满容量为j的背包，最少硬币为dp[j]
        2.递推公式:
            dp[j] = min(dp[j - coins[i]] + 1, dp[j])
            本质上从不包含coins[i] 推导 包含coins[i] 即 dp[j]

            得到dp[j]（考虑coins[i]），只有⼀个来源，dp[j - coins[i]]（没有考虑coins[i]）。
            凑⾜总额为j - coins[i]的最少个数为dp[j - coins[i]]，那么只需要加上⼀个钱币coins[i]
            即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）
            所以dp[j] 要取所有 dp[j - coins[i]] + 1 中最⼩的

        3.初始化: dp[0] = 0 非零dp = max(防止影响其他值最小操作)
            ⾸先凑⾜总⾦额为0所需钱币的个数⼀定是0，那么dp[0] = 0;
            其他下标对应的数值呢？
            考虑到递推公式的特性，dp[j]必须初始化为⼀个最⼤的数，否则就会在min(dp[j - coins[i]]+ 1, dp[j])⽐较的过程中被初始值覆盖。
            所以下标⾮0的元素都是应该是最⼤值。

        4.遍历顺序都行
     */
    public int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        Arrays.fill(dp, max);
        //当金额为0时需要的硬币数目为0
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            //正序遍历：完全背包每个硬币可以选择多次
            for (int j = coins[i]; j <= amount; j++) {
                /*
                    以例子：输入：coins = 【2】，amount = 3；输出：-1为例。
                    dp【0】 = 0, dp【j】中非零下标的值最开始都初始为了INT_MAX。
                    j = 2，dp【2】 = min(dp【0】 + 1, dp【2】) = 1
                    j = 3，dp【3】 = min(dp【1】 + 1, dp【3】)，这里的dp【1】（dp[j-coins【i】]）仍然为初始值INT_MAX，dp【1】 + 1相当于溢出了，
                    所以如果dp[j-coins【i】]是初始值则跳过。
                    本示例中，最终判断dp【3】是否仍为初始值，若为则“没有任何一种硬币组合能组成总金额”，返回-1。
                    也就是说，如果max初始值不是int的最大值，随便给个大的数(99999)，也就不用加这个判断条件
                 */
                if (dp[j - coins[i]] != max) {//防止dp[j - coins[i]] + 1数据溢出
                    //选择硬币数目最小的情况
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == max ? -1 : dp[amount];
    }
}
