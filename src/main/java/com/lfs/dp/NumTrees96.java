package com.lfs.dp;

/*
    不同的二叉搜索树
 */
public class NumTrees96 {
    /*
         1、dp数组的含义:
            dp[i]: 对i进行拆分,得到的最大数乘积为dp[i]

         2、递推公式


         3、初始化
     */
    public int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        //初始化0个节点和1个节点的情况
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
