package com.lfs.hashtable;

import java.util.*;

/*
    求两个数组的交集
 */
public class Intersection349 {
    /*
        将数组1中的元素直接放到set1中,在 遍历 数组2元素时判断如果set1中的元素含有数组2中的元素时将元素放入resSet中
        然后将resSet转为数组返回
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {// set1包含了数组2当前的元素,将当前元素(重复元素)放入reSet中
                resSet.add(i);
            }
        }

        //方法1：将结果集合转为数组

//        return resSet.stream().mapToInt(x -> x).toArray();

        //方法2：另外申请一个数组存放setRes中的元素,最后返回数组
        /*
            此处对我是个重点, 定义一个长度为2的数组 然后遍历resSet, 将resSet中的值赋给数组
         */
        int[] arr = new int[resSet.size()];
        int j = 0;
        for (int i : resSet) {
            arr[j++] = i; //循环两次复制给数组不同索引[4,9] arr[0] = 4; arr[1] = 9
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] ints = {4, 9, 5};
        int[] int2 = {9, 4, 9, 8, 4};
        int[] ints1 = new Intersection349().intersection(ints, int2);
        System.out.println(Arrays.toString(ints1));
    }
}
