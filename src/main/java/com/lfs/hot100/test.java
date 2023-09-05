package com.lfs.hot100;

import java.util.HashMap;

public class test {
    public int lengthOfLongestSubstring(String s) {
        /*
            begin: 开始索引位置
            end: 结束索引位置

            map无重复
                放入当前元素 索引作为值
            map重复
                更新begin
                    拿到当前重复元素的上一个索引,然后+1,与之前的索引进行对比找最大值
                然后更新map表(更新操作与添加操作一样)

            流程:
                a b b a
                [(a,0)(b,1)]    此时 i=0 j=1
                [(a,0)(b,2)]    此时 i=2 j=2
                [(a,3)(b,2)]    此时 i=2 j=3  注意 这里本来map拿到原来a的索引为0然后+1，但我们要取最大值,所以保持原来的2不变

         */
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
            if (map.containsKey(cur)) {
                i = Math.max(i, map.get(cur) + 1);
                map.put(cur, j);
            } else {
                map.put(cur, j);
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

}
