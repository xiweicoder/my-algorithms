package com.lfs.greedy;

/*
    最大子数组和
 */
public class MaxSubArray53 {
    /*
        思路:
            如果[连续之和]为负数,那不如重新开始
                -2,1,-3,4,-1,2,1,-5,4  -2,从新开始 1: 1-3=-2 抛弃这个-2 4: 4-1=3但我们需要保留这个3,因为3是 >0 的...最后为6
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (sum <= 0) {//连续之和为负数 则重新开始
                sum = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return result;
    }
}
