package com.lfs.hashtable;

import java.util.HashMap;
import java.util.Map;

/*
    四数相加
 */
public class FourSumCount454 {
    /*
        遍历前两个数组,将相加的和作为key,出现次数作为value放入map,
        然后遍历后两个数组,将相加之和取反去map查找有没有,有相加value(次数),没有+0
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        //统计两个数组中的元素之和，同时统计出现的次数，放入map
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0) + 1);// 这个采用getOrDefault有sum拿到sum value(次数)+1,没有sum,放入(sum,1)
            }
        }
        //统计剩余的两个元素的和，在map中找是否存在相加为0的情况，同时记录次数
        for (int i : nums3) {
            for (int j : nums4) {
                /*
                    这里采用getOrDefault是因为,如果没有对应的key,map返回为null,而我们要统计次数,他结果不能为Null,所以采用getOrDefault
                 */
                res += map.getOrDefault(0 - i - j, 0);
            }
        }
        return res;
    }


}

