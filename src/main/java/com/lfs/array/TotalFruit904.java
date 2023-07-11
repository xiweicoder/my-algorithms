package com.lfs.array;

import java.util.HashMap;
import java.util.Map;

/*
    水果成篮-求只包含两种元素的最长连续子序列
    滑动窗口
    题意:
        给定一个数组，要求我们从中选取一个最长子数组长度，要求子数组中的元素种类不能超过2,
        若下一个元素超过了元素的种类，则停下

    最大滑窗是在迭代右移右边界的过程中更新结果，而最小滑窗是在迭代右移左边界的过程中更新结果
 */
public class TotalFruit904 {

    /*
            1、进入循环
            2、执行操作: 放入水果
            3、水果种类溢出: >2
       4.1 >2的数量只有1: 删除    4.2 数量>1: 不断-1直到删除操作     重点: 滑块 i开始

       重点: i的移动情况，何时求最大值: 在while循环外求 因为条件是 <2，而进入while的条件是 >2
     */
    public int totalFruit(int[] fruits) {
        /*
            此题重点在于map的使用
            map是键值对，键是自定义的，要使用键或值就要 map.
         */
        if (fruits.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < fruits.length; right++) {
            // 在key为fruits[right] 的map中放入key为fruits[right](若原本不存在此key，值为0，存在则 +1)，来模拟多个重复元素
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // 左指针移动的情况，注意是while循环 111123  要把所有的1都删掉才满足 <=2 的情况
            while (map.size() > 2) {
                //  1 2 3 直接删除1
                if (map.get(fruits[left]) == 1) {
                    map.remove(fruits[left]);
                } else {
                    // 11123  -> 1123
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                }
                // 删除或-1 左指针就移动一次
                left++;
            }
            // 注意这里和209的区别，209是sum>时，在循环内求最小值，这题是 <2的时候求最大值，在循环外求
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}

