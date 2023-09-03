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
                return new int[]{i, map.get(other)};
            } else {
                map.put(cur, i);
            }
        }
        return null;
    }
}
