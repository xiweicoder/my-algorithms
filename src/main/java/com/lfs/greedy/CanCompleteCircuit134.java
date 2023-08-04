package com.lfs.greedy;

/*
    加油站
 */
public class CanCompleteCircuit134 {
    /*
        gas = [1,2,3,4,5], cost = [3,4,5,1,2]
        1 2 3 4 5 得到补充
        3 4 5 1 2 开向下一个加油站需要消耗油
        从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
        开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
        开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
        开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
        开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
        开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
        因此，3 可为起始索引。
        思路:
        1  2  3  4  5 得到补充
        3  4  5  1  2 开向下一个加油站需要消耗油
       -2 -2 -2  3  3 最终剩下的
       curSum 累加每个站点剩余油量,curSum变成负数,选择下一个站点作为起点
       疑惑:
       反证法
       [区间1][区间2]i+1
       我们本来要选择i+1的位置作为新的站点,因为 区间1+区间2 < 0,假设区间2是>0的,假设我们
       可以选择区间2中某一点作为新的站点,但此时区间1<0才能满足 区间1+区间2 < 0,那我们一开始的起始位置就在区间2了


     */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int curSum = 0;
        int totalSum = 0;
        int index = 0;//用来记录新的站点
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {// 选择新的站点作为起始位置
                index = i + 1;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;// 结束遍历 总和<0 则不可能跑完一圈
        return index;
    }
}
