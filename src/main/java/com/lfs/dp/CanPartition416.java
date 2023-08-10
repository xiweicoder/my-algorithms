package com.lfs.dp;

import java.util.Arrays;

/*
    分割等和子集
 */
public class CanPartition416 {
    /*
        转化到01背包的思路:
        从输入数组中挑选出一些正整数，使得这些数的和 等于 整个数组元素的和的一半
        (挑选一些物品使物品的价值最大) 等于 整个数组元素的和的一半就是求最大价值，对于本题来说，数字 是重量也是价值

        本解答没有初始化,因为初始化全都是0,创建数组也全是0,也就没写初始化的过程
     */
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //总和为奇数，不能平分
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= nums[i]; j--) {// 注意这里只能这样写 我们创建的是 target + 1长度的数组
                //物品 i 的重量是 nums[i]，其价值也是 nums[i]
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }

            //剪枝一下，每一次完成內層的for-loop，立即檢查是否dp[target] == target，優化時間複雜度（26ms -> 20ms）
            if (dp[target] == target)
                return true;
        }
        System.out.println(Arrays.toString(dp));
        return dp[target] == target;
    }

    public static void main(String[] args) {
        int num[] = {1, 5, 11, 5};
        boolean b = new CanPartition416().canPartition(num);
        System.out.println(b);

    }
}
