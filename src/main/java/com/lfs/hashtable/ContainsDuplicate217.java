package com.lfs.hashtable;

import java.util.HashMap;
import java.util.HashSet;

/*
    存在重复元素
    本题着重Set集合
    HashSet是一个很有用的容器，最大的特点是集合中的元素都是不重复的，
    底层实现是基于HashMap，所以关键是要了解HashMap的实现机制。
    和两数之和一样的题
 */
public class ContainsDuplicate217 {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int cur : nums) {
            //有重复元素返回true  (set.add有重复元素返回false)
            if (!set.add(cur)) {// set添加成功说明没有重复元素返回值为true, 但我们想要的是反过来
                return true;
            }
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {// 可以换成增强for循环
            int cur = nums[i];
            if (map.containsKey(cur)) {
                return true;
            } else {
                map.put(cur, -1);// 值不重要
            }
        }
        return false;
    }
}
