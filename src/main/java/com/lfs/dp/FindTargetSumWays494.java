package com.lfs.dp;

/*
    目标和
 */
public class FindTargetSumWays494 {
    /*
        目标数组元素的前面可以放'+'或'-' 将所有元素串起来，得到target
        [1,1,1,1,  1]
        left +   right = sum    left取+的数字和，right取-的数字和,注意不是给它加上正负号，我们是先区分开
         4   +     1   =  5

        left - right = target   题目要求，我们给区分好的加上+- 得到target
          4  -   1   =   3

          right = sum - left;

          left - sum + left = target

          left = (sum + target)/2  sum和target是我们知道的

                (5+3)/2 = 4     正数的集合要等于4->求正数集合等于4有多少种方式

          当 left = (sum + target)/2 不能被整除时 说明凑不成target直接return 0
                例如: 4 -1; 3 -2; 2 -3; 1 -4 都能使target = 2

          进而该问题抽象为:用价值与体积均为nums[i]的物品,恰好凑满容量为left的背包方案数(求right也可以)

           1.状态定义:dp[j]为恰好能凑满容量为j的背包方案数
           2.递推公式:
                dp[5] = dp[4]+dp[3]+dp[2]+dp[1]+dp[0]
                dp[j]+= dp[j-nums[i]] (注意是累加)
           3.初始化: dp[0] = 1
                例如: [0] target = 0  left = 0 只有一种方法




     */
    public int findTargetSumWays(int[] nums, int target) {
        /*
        类01背包问题:


        2.状态转移:背包容量能或者不能装下nums[i]
            2.1 当不能装下nums[i]时,方案数直接继承之前的dp[j]
            2.2 当能装下nums[i]时,总的方案数为不考虑nums[i]的方案数+有nums[i]参与新增的方案数
                dp[j] += dp[j - nums[i]],dp[j - nums[i]]种方案与nums[i]共同凑成pos,即1*dp[j - nums[i]]
        3.状态初始化:dp[0]=1,因为后面总会一直查找至j=0,如dp[3] += dp[3-3],空集是任意一条有效路径的起点,当属一条
        4.遍历顺序:i正序,j倒序
        5.返回形式:dp[pos]就是凑成pos总的方案数
         */
        int sum = 0;
        for (int num : nums) sum += num;
        // pos为小数||target绝对值比sum还大
        if ((sum + target) % 2 == 1 || Math.abs(target) > sum) return 0;

        int left = (sum + target) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = left; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[left];
    }
}
