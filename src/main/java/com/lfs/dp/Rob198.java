package com.lfs.dp;

/*
    打家劫舍
 */
public class Rob198 {
    /*
        1.状态定义: dp[i]：考虑下标i（包括i）以内的房屋，最多可以偷窃的⾦额为dp[i] 结果为dp[size-1]
        2.递推公式:
            决定dp[i]的因素就是第i房间偷还是不偷
            如果偷第i房间，那么dp[i] = dp[i - 2] + nums[i] ，即：第i-1房⼀定是不考虑的，找出 下标i-2（包括i-2）以内的房屋，最多可以偷窃的⾦额为dp[i-2] 加上第i房间偷到的钱。
            如果不偷第i房间，那么dp[i] = dp[i - 1]，即考虑i-1房，（注意这⾥是考虑，并不是⼀定要
            偷i-1房，这是很多同学容易混淆的点）
            然后dp[i]取最⼤值，即dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);

        3.初始化:
            从递推公式dp[i] = max(dp[i - 2] + nums[i], dp[i - 1]);可以看出，递推公式的基础就是dp[0]
            和 dp[1]
            从dp[i]的定义上来讲，dp[0] ⼀定是 nums[0]，dp[1]就是nums[0]和nums[1]的最⼤值即：
            dp[1] = max(nums[0], nums[1]);


        4.遍历顺序
            dp[i] 是根据dp[i - 2] 和 dp[i - 1] 推导出来的，那么⼀定是从前到后遍历
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        /*
            [1,3,2,4] 长度: 4  索引: 0 1 2 3
         */
        int[] dp = new int[nums.length];//这里的长度是给定的，背包是要考虑容量为0的情况,但这里不用
        dp[0] = nums[0];
        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }
}
