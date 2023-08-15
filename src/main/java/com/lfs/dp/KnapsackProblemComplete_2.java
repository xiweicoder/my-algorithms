package com.lfs.dp;

import java.util.Arrays;

/*
    完全背包问题降维处理
 */
public class KnapsackProblemComplete_2 {
    public static void main(String[] args) {
        int[] weight = {2, 3, 4};
        int[] value = {3, 4, 7};
        int bagSize = 6;
        int i = testWeightBagProblem(weight, value, bagSize);
        System.out.println(i);
    }

    private static int testWeightBagProblem(int[] weight, int[] value, int bagSize) {

        int[] dp = new int[bagSize + 1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagSize; j++) { // 遍历背包容量 当此时的背包容量能够装入物品时执行
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        // 打印dp数组
        System.out.println(Arrays.toString(dp));
        return dp[bagSize];
    }
}
