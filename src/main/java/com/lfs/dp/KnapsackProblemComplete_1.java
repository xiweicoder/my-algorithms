package com.lfs.dp;

/*
    完全背包问题
    每件物品都有无限多
 */
public class KnapsackProblemComplete_1 {
    public static void main(String[] args) {
        int[] weight = {2, 3, 4};
        int[] value = {3, 4, 7};
        int bagSize = 6;
        int i = testWeightBagProblem(weight, value, bagSize);
        System.out.println(i);
    }


    private static int testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        /*
        编号    重量   价值      简称
         0      2       3       c   青铜
         1      3       4       s   白银
         2      4       7       a   黄金
     */
      /*

                  物品编号
            0   1   2   3   4   5   6
        0   0   0   c   c   cc  cc  ccc 容量为4时4-2=2剩余容量为2,再去找容量为2时的策略
        1   0   0   c   s   cc  sc  ccc 当容量为4时,可以也放白银,但发现不如上次放两个青铜值大,所以还是放两个青铜
        2   0   0   c   s   a   a   ac

         if(装不下){ 延用上一次的策略
                dp[i][j] = dp[i-1][j]
         }else{ 装得下
             dp[i][j] = max(dp[i-1][j],value[i] + dp[i][j-weight[i]])
         }
         因为每件物品有无限多,所以可以多次取同一件物品 这就是关键点
         所以完全背包问题可以在同一行去找
         01背包问题,如果在同一行去找,可能会重复,也就破坏了题目要求,
         完全背包问题: 同一行去找
         01背包问题: 上一行去找(左上...)


         */
        // 创建dp数组
        int goods = weight.length;  // 重量数组的长度 就是获取物品的数量
        //行: 物品的数量 列: 要多一列0的情况,背包容量为0什么都装不下
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化dp数组 第一行数据需要特殊处理,因为其他行数据需要上一行的数据
        // 创建数组后，其中默认的值就是0
        for (int j = 0; j < bagSize + 1; j++) {//从背包容量为0开始,假设背包容量为10,那就要j < 11 或j <= 10 才能有容量为10的一种情况
            if (j >= weight[0]) {// 装得下 背包容量如果大于第一个物品重量,则放入第一个物品,注意只能放入第一个物品
                dp[0][j] = dp[0][j - weight[0]] + value[0];
            }
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (j < weight[i]) {// 放不下
                    /**
                     * 当前背包的容量都没有当前物品i大的时候，是不放物品i的
                     * 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                     */
                    dp[i][j] = dp[i - 1][j];
                } else {// 放得下
                    /**
                     * 当前背包的容量可以放下物品i
                     * 那么此时分两种情况：
                     *    1、不放物品i (上一行同列的最大价值)
                     *    2、放物品i (还能放入)
                     * 比较这两种情况下，哪种背包中物品的最大价值最大
                     */
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i][j - weight[i]]);
                }
            }
        }
        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
        return dp[weight.length - 1][bagSize];
    }
}
