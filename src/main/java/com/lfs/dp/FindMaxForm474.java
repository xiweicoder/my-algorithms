package com.lfs.dp;

/*
    一和零
    01背包
 */
public class FindMaxForm474 {
    /*
        m个0 n个1 其实是两个维度的容器

          1.状态定义:dp[i][j]装满i j 最多装了多少物品dp[i][j]
          2.递推公式:
            dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
            这里我们求的最多能装的物品个数,在减去 0 1 的重量后加上 个数(01背包的价值)

          3.初始化: dp[0] = 0 非零dp = 0

     */
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {//一个字符串一个字符串的 进行操作(这个for循环是最大的) 物品个数
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {//统计这个字符串中的0 1(重量)
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            /*
                倒序遍历
                两个for循环都是背包容量,两个维度
             */
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    /*
                        dp[i][j] 是上一轮的结果,求整体结果最大
                     */
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
