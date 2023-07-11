package com.lfs.array;

import java.util.Arrays;

/*
    删除数组中的一个元素
 */
public class RemoveElement27 {
    /*
        双指针
        快指针：寻找新数组的元素,新数组就是不含有目标元素的数组
        慢指针：指向更新 新数组下标的位置
     */
    public int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return slowIndex;
    }

    /*
        不推荐
        暴力双层for
        [1 2 3 4 5]
         0 1 2 3 4
         删除3，就是把索引2 = 索引3的元素4 索引3 = 索引4的元素5 索引4的元素不用管
         我们要删除3,当i=2时:
            nums[2] == val(3) 发现要删除的元素
            创造比i(2)大的索引j   重点是 让前一位索引 = 后一位索引 完成赋值的操作
            j = i+1 =3  3<size  3++
     */
    public int removeElement2(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) { // 发现需要移除的元素，就将数组集体向前移动一位
                for (int j = i + 1; j < size; j++) { // j = 3
                    nums[j - 1] = nums[j]; // 索引2 = 索引3  之后 再 索引3 = 索引4 ...
                }
                i--; // 因为下标i以后的数值都向前移动了一位，所以i也向前移动一位
                size--; // 此时数组的大小-1
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int length = new RemoveElement27().removeElement(nums, 3);
        System.out.println(length);

    }
}
