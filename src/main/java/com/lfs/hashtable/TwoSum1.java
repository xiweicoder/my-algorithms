package com.lfs.hashtable;

import java.util.HashMap;

/*
    两数之和
    我们知道当前值，去map中找另一半
 */
public class TwoSum1 {
    /*
        判断当前map中有没有 (target - 当前值)的key,有 直接返回,没有,存入当前值(key为当前值,value为当前索引)
        [2,7,11,15]  target = 9
        进入循环， 判断Map中有没有 (target - 当前值) = 7,没有 存入 map: [(2,0)]
        第二次循环 判断Map中有没有 (target - 当前值) = 2, 有 直接返回  索引数组: [当前的索引,map.get(2)]
            既然map中有(target - 当前值) = 2 那我们直接拿着(target - 当前值)作为key去map中找value(索引)即可
     */
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i]; // 当前值
            int key = target - cur; // 另一半的值
            if (map.containsKey(key)) {// map中是否存在我们要的另一半
                return new int[]{map.get(key), i};
            } else {
                map.put(cur, i);// 当前值为Key, 索引为value存入Map
            }
        }

        return null;
    }
}
