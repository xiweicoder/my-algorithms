package com.lfs.hot100;

import java.util.HashMap;

/*
    两数之和
    map
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int other = target - cur;
            if (map.containsKey(other)) {
                return new int[]{i, map.get(other)};//本次的索引 以及 上次的索引
            } else {
                map.put(cur, i);// 没有 则将本次的记录放入
            }
        }
        return null;
    }
}
