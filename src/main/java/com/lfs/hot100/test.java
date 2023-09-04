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
                先让begin索引+1位
                然后更新map表(更新操作与添加操作一样)
                a b b a
                [(a,1)(b,2)]
                i = 2   j = 3

                begin

         */
        HashMap<Character, Integer> map = new HashMap<>();

        int begin = 0, res = 0;
        for (int end = 0; end < s.length(); end++) {
            char cur = s.charAt(end);
            if (map.containsKey(cur)) {
                begin = Math.max(begin, map.get(cur) + 1);
                map.put(cur, end);
            } else {
                map.put(cur, end);
            }
            res = Math.max(res, end - begin + 1);
        }
        return res;
    }
}
