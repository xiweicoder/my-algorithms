package com.lfs.greedy;

import java.util.Arrays;

/*
    K次取反后最大化的数组和
 */
public class LargestSum1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        /*
            本题解法思路:
            1、排序
            2、在k的次数内,将最小负数取反,如果没有负数不做任何操作
            累加求和,k为偶数时没有任何影响
            k为奇数时,多加了两次最小值,要减去这两次最小值:
                哪两次?
                举例: [4,2,3], k = 1
                我们的sum = 9 但最终结果为 6
                我们做的: 7 + 2
                本来应该做的: 7 - 2
                一来一回 多了两个2
         */
        /*
            本题解法精妙之处在于 我们先求最大和 然后通过判断k的奇偶来进行后续操作
         */
        Arrays.sort(nums);
        int sum = 0;
        int minValue = 101;//题目最小值为 -100<= x <= 100 写 Integer.min也行

        /*

         */
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0) {//在k的次数内,将最小负数取反
                nums[i] = -nums[i];
                k--;
            }
            minValue = Math.min(minValue, nums[i]);
            sum += nums[i];
        }
        if (k % 2 != 0) {//奇数时减去两倍的最小值;偶数时,没有任何变化
            sum -= 2 * minValue;
        }
        return sum;
    }
}
