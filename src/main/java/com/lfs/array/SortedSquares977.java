package com.lfs.array;


/*
    有序数组的平方   O(n)
        nums = [-4,-1,0,3,10]
        输出：[0,1,9,16,100]
    思路:
        数组其实是有序的， 只不过负数平方之后可能成为最大数了。
        那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
        此时可以考虑双指针法了，l指向起始位置，r指向终止位置。

        平方后: 由大到小的规律
        大 -> 小 <- 大
        判断两端的大小将大的一方放入新的数组的最后，依次判断放入新数组，新数组即有序数组
 */
public class SortedSquares977 {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] result = new int[nums.length];
        int index = nums.length - 1; // 新数组的 索引 必须为给定数组的大小
        while (l <= r) { // l != r -> 最后一次可能会相等，所以不能使用   所以 <= 最合理
            if (nums[l] * nums[l] > nums[r] * nums[r]) {

                result[index--] = nums[l] * nums[l]; // 将大的一方放入新数组，新数组--
                l++; // 向右走
            } else {
                result[index--] = nums[r] * nums[r];
                r--;// 向左走
            }
        }
        return result;
    }
}
