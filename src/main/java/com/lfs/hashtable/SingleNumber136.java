package com.lfs.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/*
    只出现一次的数字
    1、异或
    2、set
 */
public class SingleNumber136 {

        /*
        输入：nums = [2,2,1]
        输出：1        1

        输入：nums = [4,1,2,1,2]
        输出：4        4

        异或有两个特点:
        1. 任何相同的数字异或，结果都是 0
        2. 任何数字与 0 异或，结果是数字本身

        [4,1,2,1,2] 4
        拿到数组中第一个数,用这个数和后面的每一个数都进行异或运算,最后剩下的就是只出现一次的数字
     */
    public int singleNumber(int[] nums) {
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num = num ^ nums[i];
//            System.out.println(num);
        }
        return num;
    }

    // 遍历遇到重复的就删除,剩下的最后一个就是我们要的
    public int singleNumber2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);
            }

        }
        return set.toArray(new Integer[0])[0];// 想要取出set中的值要先转成数组,new Integer[0]啥都不是
    }

    public static void main(String[] args) {
        SingleNumber136 e06 = new SingleNumber136();
//        System.out.println(e06.singleNumber(new int[]{2, 2, 1}));
        System.out.println(e06.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }
}
