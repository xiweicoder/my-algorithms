package com.lfs.dp;

/*
    打家劫舍2
    环
 */
public class Rob213 {
    /*
        [1,6,1,9,1]
        情况⼀：考虑不包含⾸尾元素
        情况⼆：考虑包含⾸元素，不包含尾元素
        情况三：考虑包含尾元素，不包含⾸元素
        注意我这⾥⽤的是"考虑"，例如情况三，虽然是考虑包含尾元素，但不⼀定要选尾部元素！
        对于情况三，取nums[1] 和 nums[3]就是最⼤的。
        ⽽情况⼆ 和 情况三 都包含了情况⼀了，所以只考虑情况⼆和情况三就可以了
     */

    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int result1 = robRange(nums, 0, nums.length - 2);//情况二
        int result2 = robRange(nums, 1, nums.length - 1);// 情况三
        return Math.max(result1, result2);
    }

    public int robRange(int[] nums, int start, int end) {//打家劫舍198
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (start == end) {
            return nums[start];
        }
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[end];
    }
}
