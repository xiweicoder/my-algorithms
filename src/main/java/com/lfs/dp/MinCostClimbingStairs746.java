package com.lfs.dp;

/*
    使用最小花费爬楼梯
 */
public class MinCostClimbingStairs746 {
    /*
        题目解析:
            你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯
            只有跳的时候花费体力
            cost = [10,15,20] 顶楼位置 3 ,目的是爬到索引为3的位置才算成功

        1、确定dp数组含义: 到达第i个台阶的最小花费为dp[i]

        2、求递推数组:
            dp[i] 到达dp[i]的花费:
                dp[i-1] + cost[i-1] : 到达i-1个台阶最小花费 + 从i-1的位置向上跳的花费 跳一个台阶到达i
                dp[i-2] + cost[i-2] : 到达i-2个台阶最小花费 + 从i-2的位置向上跳的花费 跳两个台阶到达i
            我们有两种办法可以到达dp[i](顶楼),那该如何选择?
                我们应该选择花费最小的方式到达:
                    dp[i] = Math.min((dp[i-1] + cost[i-1]),(dp[i-2] + cost[i-2]))
            这样就得到了递推公式: dp[i] = Math.min((dp[i-1] + cost[i-1]),(dp[i-2] + cost[i-2]))

        3、如何初始化:
            因为dp[i]根据dp[i-1] dp[i-2] ...等一系列操作得到,那最基础最根本在 dp[0] dp[1]
            题目所说,我们可以站在0 或 1 位置上向上跳,只有向上跳时才花费体力
                (我们要时刻记得dp[i]的意思,到达第i个台阶的最小花费为dp[i])
            我们到达台阶0花费: 0    dp[0] = 0;
            我们到达台阶1花费: 0    dp[1] = 0;

         4、遍历顺序 从前向后

         5、打印数组是否符合要求
            这一步更多的是debug，不展开讲了

     */
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];//[10,15,20]x x位置才是我们要到达的位置,所以dp数组长度+1,
        dp[0] = 0;
        dp[1] = 0;

        /*
            cost.length = 3 dp数组长度则为4 索引为 0 1 2 3
            i <= cost.length 当i=cost.length时,其实已经到达了dp数组索引最后一位,也就是顶(是cost没有值的地方)
            cost: [10,15,20]
            dp:   [10,15,20,x]   求dp[x] x=dp.length-1 = cost.length
         */
        for (int i = 2; i <= len; i++) {//i<=cost的长度, 其实也是到达了dp数组最后一位索引位置
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[len];//长度是len+1,索引最大为len
    }

    //更改了for循环和最后结果的索引 改成了采用dp数组的索引  感觉更容易理解
    public int minCostClimbingStairs2(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len + 1];//[10,15,20]x x位置才是我们要到达的位置,所以dp数组长度要+1,
        dp[0] = 0;
        dp[1] = 0;

        /*
            cost.length = 3 dp数组长度则为4 索引为 0 1 2 3
            i <= cost.length 当i=cost.length时,其实已经到达了dp数组索引最后一位,也就是顶(是cost没有值的地方)
            cost: [10,15,20]
            dp:   [10,15,20,x]   求dp[x] x=dp.length-1 = cost.length
         */
        for (int i = 2; i < dp.length; i++) {//遍历dp数组
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];// dp数组索引最后一位
    }
}
