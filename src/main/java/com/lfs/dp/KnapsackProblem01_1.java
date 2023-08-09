package com.lfs.dp;

/*
    背包问题在leetcode上没有真正的题目
    01背包问题
    每件物品只有一件
 */
public class KnapsackProblem01_1 {
    /*
         1、dp数组的含义:
            dp[i][j]: 在[0,i]范围内的物品,任取放入容量为j的背包中

         2、递推公式
            dp[i][j]可以由哪几个方向推出来,dp[i][j]物品状态取决于放不放物品i
            不放物品i: dp[i-1][j] 不放物品i,容量为j
            放物品i的最大价值:  背包容量 - 物品i的容量所能放的最大价值 + 物品i的价值
                背包容量 - 物品i的容量所能放的最大价值:   dp[i-1][j-weight[i]]
                物品i的最大价值: value[i]
                dp[i-1][j-weight[i]] + value[i]

            因为我们是求最大价值,所以我们在放物品i与不放物品i中求最大:
            dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]] + value[i])

            解释公式:
            j: 背包的容量,背包的容量是不会变的
            我们前面说了,dp[i-1][j]是不放入物品i的最大价值,那么为什么求物品i的最大价值公式为dp[i-1][j-weight[i]] + value[i]呢?
                我们只放入i-1个物品时为了求最大价值肯定会放的满满当当,背包容量一定接近最大容量j即: dp[i-1][j]
                但我们想在i-1个物品的基础上再加上第i个物品 求放入物品i的最大价值,这时背包的情况是:装入任意0到i-1范围的物品,容量满了(根据i-1个物品有自己的装入策略)
                这时我们不得不把装的满满的背包空出weight[i]的容量给物品i,也就是说i-1个物品只能在j-weight[i]的容量内装满(这时因为i-1范围内的物品因为容量减少,要改变装入策略)
                这时我们再装入物品i,求得放入物品i的最大价值

                      物品范围         背包容量(容量不会改变)
               第一个物品 1                j    (为了求最大价值容量j满了)
                        2                j     (j满满的)
                       ...               j     (j满满的)
                       i-1               j     (j满满的)
                        i                i-1的背包容量 - 第i个物品的重量 + 第i的物品的重量(这个重量其实在第i的物品价值里面包含了,在这写出来更容易理解)
               一句话说明白:放入本阶段能够装入的,若发现还能装,就去尝试装别的东西
         3、初始化

     */

    /*
        编号    重量   价值      简称
         0      4   1600        A   黄金
         1      8   2400        R   红宝石
         2      5   30          S   白银
         3      1   10000       D   钻石
     */
    /*
      物品编号
            0   1   2   3   4   5   6   7   8   9   10  背包容量
        0   0   0   0   0   A   A   A   A   A   A   A
        1   0   0   0   0   A   A   A   A   R   R   R
        2   0   0   0   0   A   A   A   A   R   R   R   我们可以装入白银,但发现明显不如装入红宝石的情况,所以求最大值则装入红宝石
        3   0   D   D   D   D   DA  DA  DA  DR  DR  DR

        1、第一行特殊处理, 因为后面的数据需要第一行的数据,而第一行数据无法依靠前面的数据
        2、装不下 则装入上一行的情况   (装不下本行新的物品)
        3、装得下
            1、在本次装入情况与上次装入情况求最大值
            2、装入本次的物品还能装入,找一找,剩余容量还能不能装入其他东西
                例如: 背包容量为5,装入本行物品钻石,背包容量为4,那就去背包容量为4时,找最大价值情况

        我们可以得到:
            if(装不下){
                dp[i][j] = dp[i-1][j]
            }else{ 装得下
                dp[i][j] = max(dp[i-1][j],value[i] + dp[i-1][j-weight[i]])
            }
     */


    /**
     * 动态规划获得结果
     *
     * @param weight  物品的重量组 里面放着各个物品的重量
     * @param value   物品的价值组里面放着各个物品的价值
     * @param bagSize 背包的容量
     */
    public static int testWeightBagProblem(int[] weight, int[] value, int bagSize) {
        /*
            注意 要使用 重量 和 价值 一定要标注是第几个物品的
         */

        // 创建dp数组
        int goods = weight.length;  // 重量数组的长度 就是获取物品的数量
        //行: 物品的数量 列: 要多一列0的情况,背包容量为0什么都装不下
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化dp数组 第一行数据需要特殊处理,因为其他行数据需要上一行的数据
        // 创建数组后，其中默认的值就是0
        for (int j = 0; j < bagSize + 1; j++) {//从背包容量为0开始,假设背包容量为10,那就要j < 11 或j <= 10 才能有容量为10的一种情况
            if (j >= weight[0]) {// 装得下 背包容量如果大于第一个物品重量,则放入第一个物品,注意只能放入第一个物品
                dp[0][j] = value[0];
            } else {// 装不下 (写不写都行,数组默认为0)
                dp[0][j] = 0;
            }
        }

        // 填充dp数组
        /*
            物品的数量为小于,背包的容量要 + 1 ?
                物品的数量与length正好相符合 物品数量为4 weight数组[1,2,3,4],对应索引0 1 2 3,0的情况特殊处理了,<数组长度,正好处理索引1 2 3的情况
                假设背包容量为10,那就要j < 11 或j <= 10 才能有容量为10的一种情况
         */
        for (int i = 1; i < weight.length; i++) {
            for (int j = bagSize; j > 0; j--) {
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
                    dp[i][j] = Math.max(dp[i - 1][j], value[i] + dp[i - 1][j - weight[i]]);
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
        // 价值最大时 就是背包容量最大时 因为dp数组初始化时就是 int[][] dp = new int[goods][bagSize + 1]; 因此返回值为:
        return dp[weight.length - 1][bagSize];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        int i = testWeightBagProblem(weight, value, bagSize);
        System.out.println(i);
    }
}
