package com.lfs.dp;

/*
    不同路径2-有障碍物
 */
public class UniquePathsWithObstacles63 {
    /*
        本题与62题就多了一个判断 只有没有障碍的情况才进行操作
        障碍物在棋盘中是1
        obstacleGrid[i][j] = 1 : 表示此处有障碍物
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;// 行
        int n = obstacleGrid[0].length;// 列
        int[][] dp = new int[m][n];

        //如果在起点或终点出现了障碍，直接返回0
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {//同方向没有障碍时 初始化列,有障碍时,结束本次循环
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
