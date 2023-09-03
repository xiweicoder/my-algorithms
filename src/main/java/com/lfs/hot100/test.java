package com.lfs.hot100;

import java.util.HashSet;
import java.util.Set;

public class test {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        int len;

        Set<Integer> set = new HashSet();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer s : set) {
            if (!set.contains(s - 1)) {
                len = 1;
                while (set.contains(++s)) len++;
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
