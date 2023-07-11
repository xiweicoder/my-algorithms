package com.lfs.array;

/*
    搜索插入位置
 */
public class SearchInsert35 {

    /*
        返回插入点位置，其实就是二分left 的索引位置
        但其实当没有查到时，返回的就是
        二分查找到最后时:   i = j + 1   所以返回这两种结果哪一种都对
     */
    // 左闭右闭
    public int searchInsert1(int[] nums, int target) {
        int n = nums.length;

        // 定义target在左闭右闭的区间，[low, high]
        int low = 0;
        int high = n - 1;

        while (low <= high) { // 当low==high，区间[low, high]依然有效
            int mid = low + (high - low) / 2; // 防止溢出
            if (nums[mid] > target) {
                high = mid - 1; // target 在左区间，所以[low, mid - 1]
            } else if (nums[mid] < target) {
                low = mid + 1; // target 在右区间，所以[mid + 1, high]
            } else {
                // 1. 目标值等于数组中某一个元素  return mid;
                return mid;
            }
        }
        // 2.目标值在数组所有元素之前 3.目标值插入数组中 4.目标值在数组所有元素之后 return right + 1;
//        return low; 返回low也可以，此时的low就是我们要的值
        return high + 1;
    }

    //第二种二分法：左闭右开
    public int searchInsert2(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) { //左闭右开 [left, right)
            int middle = left + ((right - left) >> 1);
            if (nums[middle] > target) {
                right = middle; // target 在左区间，在[left, middle)中
            } else if (nums[middle] < target) {
                left = middle + 1; // target 在右区间，在 [middle+1, right)中
            } else { // nums[middle] == target
                return middle; // 数组中找到目标值的情况，直接返回下标
            }
        }
        // 目标值在数组所有元素之前 [0,0)
        // 目标值插入数组中的位置 [left, right) ，return right 即可
        // 目标值在数组所有元素之后的情况 [left, right)，因为是右开区间，所以 return right
        return right;
    }

    // leftmost 版
    public int searchInsert3(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

}
