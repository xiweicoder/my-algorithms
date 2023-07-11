package com.lfs.array;

/*
    在排序数组中查找元素的第一个和最后一个位置
    最左最右元素 二分查找的案例，详看704
    注意: 使用改良版left right 返回值不同-> 向左找返回i    向右找返回i-1(j)
 */
public class SearchRange34 {
    public int[] searchRange(int[] nums, int target) {
        int x = leftSearch(nums, target);
        if (x == -1) {
            return new int[]{-1, -1};
        } else {
            return new int[]{x, rightSearch(nums, target)};
        }
    }

    private int rightSearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int c = -1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                c = mid;
                i = mid + 1;
            }
        }
        return c;
    }

    private int leftSearch(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int c = -1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                c = mid;
                j = mid - 1;
            }
        }
        return c;
    }
}
