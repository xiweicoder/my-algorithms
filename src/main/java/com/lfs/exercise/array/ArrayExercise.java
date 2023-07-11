package com.lfs.exercise.array;

/*
    数组练习
 */


import java.util.HashMap;

@SuppressWarnings("all")
public class ArrayExercise {
    // 704 注意 nums[mid] 比较的是数值，不是索引
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        if (i > j || i < 0) {
            return -1;
        }
        while (i <= j) {
            int mid = i + j >> 1;

            if (nums[mid] > target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 59 方法1 注意 mat[t][i] = num++; 占用了哪行，行就是哪个方向的; 注意循环条件是i
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1, num = 1;
        int[][] mat = new int[n][n];
        while (num <= n * n) {
            for (int i = l; i <= r; i++) {
                mat[t][i] = num++; // 从左向右，占用了top方向的，top方向一直没变，行也没变因此 行为top
            }
            t++;

            for (int i = t; i <= b; i++) {
                mat[i][r] = num++;
            }
            r--;

            for (int i = r; i >= l; i--) {
                mat[b][i] = num++;
            }
            b--;

            for (int i = b; i >= t; i--) {
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }

    // 367 就是69基础上加判断条件

    // 209 注意判断sum >= target时，应该是while而不是if，因为你要判断很多很多次滑块是否移动
    // result = Math.min(result, j - i + 1); 统计长度的语句应该放在最前面，不然i值可能会变化
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                result = Math.min(result, j - i + 1);
                sum = sum - nums[i];
                i++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    // 69 注意 (long) mid * mid > x 大于的是x，一直要和x比较大小, 最后的结果是i-1或j
    public int mySqrt(int x) {
        int i = 0;
        int j = x;
        while (i <= j) {
            int mid = i + j >> 1;
            if ((long) mid * mid > x) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return i - 1;
//        return j;
    }

    // 27** 双指针 快慢指针    有相等的值 快指针走，慢指针不动;   没有相等的值 快指针的值赋给满指针，两个指针都走
    // 返回值是新数组下标位置，删除数组元素本质上就是数组的移动，元素并没有删除，只是覆盖 所以返回慢指针的索引即答案，而nums.length 反而是原数组的长度
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

    // 35 其实就是向左查找索引位置
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        int c = 0;
        while (i <= j) {
            int mid = i + j >> 1;
            if (nums[mid] >= target) {
                j = mid - 1;
            } else if (nums[mid] < target) {
                i = mid + 1;
            }
        }
        return i;
    }

    // 34 就是 35上位替代

    // 977 注意 循环条件 i <= j
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int[] n1 = new int[nums.length];
        int index = nums.length - 1;

        while (i <= j) {
            if (nums[i] * nums[i] > nums[j] * nums[j]) {
                n1[index] = nums[i] * nums[i];
                i++;
            } else {
                n1[index] = nums[j] * nums[j];
                j--;
            }
            index--;
        }
        return n1;
    }

    // 904 注意 后面是i
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int result = Integer.MIN_VALUE;


        for (int j = 0; j < fruits.length; j++) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

            while (map.size() > 2) {
                if (map.get(fruits[i]) == 1) {
                    map.remove(fruits[i]);
                } else {
                    map.put(fruits[i], map.get(fruits[i]) - 1);
                }
                i++;
            }
            result = Math.max(result, j - i + 1);
        }
        return result == Integer.MIN_VALUE ? 0 : result;
    }
}
