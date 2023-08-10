package com.lfs.dp;

/*
    最后一块石头的重量2
 */
public class LastStoneWeight1049 {
    /*
        转化到01背包的思路:
        将这些石头堆尽可能的分成两堆，这两堆的重量尽可能的相似，这样相撞之后，剩下的值就是最小值
        我们就将问题转为 如何求分成一半石头堆的最大重量(target) 也与416相似了
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum >> 1;
        //初始化dp数组
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            //采用倒序
            for (int j = target; j >= stones[i]; j--) {
                //两种情况，要么放，要么不放
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        /*
            我们求出一堆石头的最大重量为dp[target]，则另一堆的最大重量为sum -  dp[target]
            那么碰撞后剩下最小为 (sum -  dp[target]) - dp[target]
            因为我们求的target是向下取整所以sum -  dp[target] 一定大于 dp[target] 所以不会出现负数的情况
         */
        return sum - 2 * dp[target];//偶数肯定是0, 奇数:23  23/2 =11  23-2*11 = 1
    }
}
