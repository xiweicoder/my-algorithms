package com.lfs.array;


/*
    长度最小的子数组
    滑动窗口
        滑动窗口指的是这样一类问题的求解方法，在数组上通过双指针同向移动而解决的一类问题。
        其实这样的问题我们可以不必为它们专门命名一个名字，它们的解法其实是很自然的。
        使用滑动窗口解决的问题通常是暴力解法的优化，掌握这一类问题最好的办法就是练习，然后思考清楚为什么可以使用滑动窗口。
        用一个for循环去做两个for循环能做的事
 */
public class MinSubArrayLen209 {

    /*

        让滑动窗口终止位置不断向后移动
        过程：
        j终止位置向后移动，当满足条件(sum>s)时，记录长度，保存数值到result以便比较之后的最小值,然后缩小范围:
        sum减去起始位置i，然后i再向后一位  形成一个滑动的块的效果
     */

    // 滑动窗口
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];
            while (sum >= s) { // 题目要求 大于等于s
                result = Math.min(result, right - left + 1);

                //重点的两行代码 缩小范围
                sum = sum - nums[left];
                left++;
//                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /*
        不推荐
        暴力双for
        result: 先比较串的长度 再记录每一次 满足条件(>s) 的最小值
    */
    public int minSubArrayLen2(int s, int[] nums) {
        int result = Integer.MAX_VALUE; // 最终的结果
        int sum = 0; // 子序列的数值之和
        int subLength = 0; // 子序列的长度
        for (int i = 0; i < nums.length; i++) { // 设置子序列起点为i
            sum = 0;
            for (int j = i; j < nums.length; j++) { // 设置子序列终止位置为j
                sum += nums[j];
                if (sum >= s) { // 一旦发现子序列和超过了s，更新result
                    subLength = j - i + 1; // 取子序列的长度
                    result = Math.min(result, subLength);
//                    result = result < subLength ? result : subLength;
                    break; // 因为我们是找符合条件最短的子序列，所以一旦符合条件就break
                }
            }
        }
        // 如果result没有被赋值的话，就返回0，说明没有符合条件的子序列
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}