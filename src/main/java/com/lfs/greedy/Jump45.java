package com.lfs.greedy;

/*
    跳跃游戏2
    求最小跳跃次数
 */
public class Jump45 {
    /*
        每一步尽可能取增加覆盖范围,用最少的步数去增加覆盖范围
        当前覆盖范围 = 0
        下一步的覆盖范围 当前覆盖范围不够用 就启用下一步的覆盖范围
     */
    public int jump(int[] nums) {
        if (nums.length == 0) return 0;
        int maxRange = 0; // 最大覆盖范围(下一步的覆盖范围)
        int curRange = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            maxRange = Math.max(maxRange, i + nums[i]);
            if (i == curRange) {
                if (curRange != nums.length - 1) {//当前范围没有到达终点 或 超过终点
                    result++;//只有在没有达到终点时增加步数
                    curRange = maxRange;

                    if (curRange > nums.length - 1) {//超过终点直接break;因为我们的结果已经拿到了,步数增加了(当前覆盖范围变大了)我们才能超过终点
                        break;
                    }
                } else {//到达终点直接break;  隐藏条件: (curRange = nums.length - 1) 时 break;
                    break;
                }
            }

        }
        return result;
    }
}
