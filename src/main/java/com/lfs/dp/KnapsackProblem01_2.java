package com.lfs.dp;

import java.util.Arrays;

/*
    01背包问题-一维数组
 */
/*
    一维数组就不用刻意初始化
 */
public class KnapsackProblem01_2 {


    /**
     * 动态规划获得结果
     *
     * @param weight  物品的重量组 里面放着各个物品的重量
     * @param value   物品的价值组里面放着各个物品的价值
     * @param bagSize 背包的容量
     */
    public static int testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        /*
            每次覆盖
         */
        /*
            注意 要使用 重量 和 价值 一定要标注是第几个物品的
         */

        //里面的元素个数也就是原来的列数
        int[] dp = new int[bagSize + 1];

        /*
            物品的数量为小于,背包的容量要 + 1 ?
                物品的数量与length正好相符合 物品数量为4 weight数组[1,2,3,4],对应索引0 1 2 3,0的情况特殊处理了,<数组长度,正好处理索引1 2 3的情况
                假设背包容量为10,那就要j < 11 或j <= 10 才能有容量为10的一种情况
         */
        for (int i = 0; i < weight.length; i++) {// 0-i个物品
            for (int j = bagSize; j >= weight[i]; j--) {//背包容量大于等于物品重量时放入物品 倒序背包容量--
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
                System.out.println(Arrays.toString(dp));
            }
            System.out.println("---------");
        }
        /*
            本题的遍历顺序:
            索引为0的物品 for
                背包容量 4 3 2 1...求最大价值
            索引为1的物品 for
                背包容量 4 3 2 1...求最大价值
            索引为2的物品 for
                背包容量 4 3 2 1...求最大价值
            结束循环
         */
        // 打印dp数组
//        System.out.println(Arrays.toString(dp));
        // 价值最大时 就是背包容量最大时 因为dp数组初始化时就是 int[][] dp = new int[goods][bagSize + 1]; 因此返回值为:
        return dp[bagSize];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        int i = testWeightBagProblem(weight, value, bagSize);
        System.out.println(i);
    }
}
