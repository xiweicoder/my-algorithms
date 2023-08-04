package com.lfs.sort;

/*
    计数排序
    最大值不要太大,可以处理负数
    因为原始值映射到索引上,最大值太大,数组长度过大浪费空间
 */
public class CountingSort912 {
    /*
        count数组的索引 是原数值 - min
        count数组的值 是出现次数(原数值的出现次数)
     */
    public int[] sortArray(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {

            if (nums[i] > max) {// 求最大值
                max = nums[i];
            }
            if (nums[i] < min) {// 求最小值
                min = nums[i];
            }
        }
        int[] count = new int[max - min + 1];// [0,0,0,0...]

        // 最小值(负数)放在索引0处
        for (int n : nums) {
            count[n - min]++;  // -1 - (-1) = 0 以此类推...
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            // i + min代表原始数组元素  count[i]代表元素出现的次数
            while (count[i] > 0) {
                nums[k++] = i + min;//在原数组中重新覆盖,因为我们根据索引存入出现次数时,索引-min,所以拿索引(原数值)时要加上min才是原来的数值
                count[i]--; // 出现次数-1
            }
        }
        return nums;
    }
}
