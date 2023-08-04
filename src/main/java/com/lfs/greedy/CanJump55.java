package com.lfs.greedy;

/*
    跳跃游戏
 */
public class CanJump55 {
    /*
        [2,3,1,1,4]
        最初位于2,最多跳两步,可以跳一步,判断能否到达终点
        [3,2,1,0,4]: 怎么跳都不能到达中终点

        思路:
        看覆盖范围,只要在覆盖范围内就可以到达,只看最大,看能否将终点覆盖
        注意求最大值求的是谁与谁的最大值
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        //覆盖范围, 初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        //在覆盖范围内更新最大的覆盖范围
        for (int i = 0; i <= coverRange; i++) {//覆盖范围其实就是遍历次数

            /*
                覆盖范围如何增加:  一开始i(数组索引)是0的时候, max(0,0+2) 取最大覆盖范围 2
                i=1也就是到3的位置上时, max(2,1+3) 最大为4 ... 向后看 最大为4
                    i=1 coverRange=4 也就是再遍历3次到达最后,能否成功是不知道的,
                    也就是从起始位置2,走一步到3,从3走3步 一共从起始位置走4步 找最大覆盖范围
             */
            coverRange = Math.max(coverRange, i + nums[i]);//上一次的覆盖范围 与 步数加本次覆盖范围 找最大遍历次数(覆盖范围)
            if (coverRange >= nums.length - 1) {//覆盖了终点返回true
                return true;
            }
        }
        return false;
    }
}
