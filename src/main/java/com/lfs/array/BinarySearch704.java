package com.lfs.array;

/*
    二分查找
    三种方法都可以
        要注意 mid的计算要放到循环中去写，是不断计算的
 */
public class BinarySearch704 {
    /*
        左闭右闭 [1,1]
        因为left 与 right 是左闭右闭的，所以他们是有可能相等的，所以在进入循环时的条件，就要考虑相等的情况
        当中间值大于target时，我们要移动right，怎么移动?
            因为我们是左闭右闭 [1,1] 我们已经判断过 nums[mid] > target ，
            所以我们要找的值一定不包括mid索引处的值，因为他已经大于了target了，所以我们取 mid + 1 让这个边界成为下一次循环一种结果
     */
    public int search(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }

    /*
        左闭右开[left, right) [1,1)
        首先，对于[1,1)这就不是一个合法的区间，是没有意义的
        在进入while循环时，因为左闭右开区间，left不可能等于right
        当nums[mid] > target 意味着mid索引处的值不等于target，又因为左闭右开区间，
        上一次不相等，的值，就是下一次循环的右边界值，因为left不可能等于right
            所以right = mid
        当nums[mid] < target时，因为mid处的索引不等于target,但left左边界的值是可能会取到的 所以有left = mid + 1;而不是让left = mid;这种取不到的情况出现
     */
    public int search2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid;
        }
        return -1;
    }

    /*
     二分查找平衡版
     左闭右开区间 i是能够取到的；j不能取到只是一个边界条件
     思路:    在while中条件只要大于1就进入循环，进入循环不断地缩小边界，直到区间中只有一个元素时，跳出循环
        缩小边界时，j = m不必多说，范围取不到
        当else时，即target >= a[m] 缩小左边界，但因为有可能相等，所以i = m,而不是i = m+1
 * 原先的代码  待查结果  元素在最左边 L 次，  元素在最右边 2*L 次，原先的代码并不平衡
 */
    public int binarySearchBalance(int[] a, int target) {
        int i = 0, j = a.length;       //[) 左闭右开
        while (1 < j - i) {         // 范围内待查找的元素个数 > 1 时
            int m = (i + j) >>> 1;  //不断地缩小范围
            if (target < a[m]) {    // 目标在左边
                j = m;
            } else {                // 目标在 m 或右边
                i = m;
            }
        }
//        表示范围内的元素只有1了，那么i就是我们想要的
        return (target == a[i]) ? i : -1;

    }

    /*
      二分查找，有重复元素最左边的元素索引
      通过引入一个候选值candidate来记录重复的元素
      与一般的二分查找不同处在于数组中有重复的元素，而我们要做的就是不断地向左找，即使找到了target，
        记录一下继续向左找，直到找到最左边的target
   */
    public int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1; //候选
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                // 记录候选位置
                candidate = m;
                j = m - 1;   //缩小j的范围
            }
        }
        return candidate;
    }

    /*
        与binarySearchLeftmost1同理
     */
    public int binarySearchRightmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1; //候选
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                // 记录候选位置
                candidate = m;
                i = m + 1;   //扩大i的范围
            }
        }
        return candidate;
    }

    /*
       改良版，最左元素二分查找
       之前我们通过记录target，然后继续向左找的办法，现在我们当target小于等于mid时还向左找，重点在于等于时依然还要找
       这样可以简化我们的代码
     */
    public int binarySearchLeftmost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target <= a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }// 1 2 2
        return i;
    }

    /*
        二分查找，有重复元素最右边的元素索引
     */
    public int binarySearchRightmost2(int[] a, int target) {
        int i = 0, j = a.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i - 1;
    }
}
