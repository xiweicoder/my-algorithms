package com.lfs.dp;

import java.util.Arrays;

/*
    完全平方数
 */
public class NumSquares279 {
    /*
        本题与322相似
        i*i 就是一个物品的重量
        n 是物品的数量 也是重量
     */
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        //初始化
        //如果不想要寫for-loop填充數組的話，也可以用JAVA內建的Arrays.fill()函數。
        Arrays.fill(dp, Integer.MAX_VALUE);

        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        /*
            必须从1开始遍历,从0开始 dp[j - i * i] + 1 就越界int了
            要么从0开始 加上个判断(dp[j - coins[i]] != max) 和322一样
         */
        for (int i = 1; i * i <= n; i++) {//完全平方数从1开始 1 4 9 16
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[n];
    }
}
