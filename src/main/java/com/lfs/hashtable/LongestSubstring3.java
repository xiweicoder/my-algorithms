package com.lfs.hashtable;

import java.util.HashMap;

/*
    无重复字符的最长子串
 */
public class LongestSubstring3 {

    public int lengthOfLongestSubstring(String s) {
         /*
       [(a,3) (b,1) (c,2)]

        b
          e
       abcabcbb
       要点：
           1.用 i 和 j 表示子串开始和结束位置
           2.用 hash 表检查重复字符
           3.从左向右查看每个字符, 如果:
            - 没遇到重复字符，调整 end:
                将j索引处元素存入map
            - 遇到重复的字符，调整 begin:
                (1)更新之前重复元素map的value: 但是你用map的put放入j索引的元素会直接覆盖之前的,所以操作与没重复的操作一样
                (2)让i指针向后移动一位,此处也有坑
                    当字符串是:  a b b a
                                    i   j       [(a,0),(b,2)()]
                            a   b   b   a       在判断最后一个a是否重复时,重复了,原来的索引要+1,但是原来的索引是0,这就变成了0+1=1, i返回向左走了，走到第一个b上了

                            要避免这种情况只需要比较最大值即可

            - 将当前字符放入 hash 表
           4.end - begin + 1 是当前子串长度
        */
        HashMap<Character, Integer> map = new HashMap<>();

        int i = 0;
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j); // 当前元素
            if (map.containsKey(s.charAt(j))) {// 重复
                // 1.让map中的i向前后一步
                /*
                    拿到上次字符的索引，然后向后移动一位，
                    求最大不然重复时更新可能会出错
                 */
                i = Math.max((map.get(cur) + 1), i);//(map.get(c) + 1:  获取之前的索引 + 1; c:重复元素(之前放入的元素)
                //2.更新i value(索引的值)
                map.put(cur, j);
            } else {// 不重复
                map.put(cur, j);
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
