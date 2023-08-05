package com.lfs.greedy;


import java.util.LinkedList;
import java.util.List;

/*
    划分字母区间
 */
public class partitionLabels763 {
    /*
        "ababcbacadefegdehijhklij"
        划分区间,一个区间包含了a别的区间就不能包含a,我们为了一个包含所有的a,不得不包含了b c,那么b c的处理方式与a一样
        ababcbaca defegde hijhklij 返回长度列表 [9,7,8]

        思路:
        0 1 2 3 4 5 6 7 8 |  9 10  11 12 13 14 15     索引
        a b a b c b a c a |  d  e  f  e  g  d  e      元素
        8 5 8 5 7 5 8 7 8 |  14 15 11 15 13 14 15     最远出现位置

        遍历元素时找到最远出现位置,一旦我们找到最远出现位置就可以划分区间了
     */
    public List<Integer> partitionLabels(String s) {
        /*
            我们通过映射让 索引0对应a 1对应b ...
         */
        int[] map = new int[26];//map数组里面装的是 最远出现位置
        char[] chars = s.toCharArray();// 推荐先转换成char数组 charAt(i)效率太低

        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            right = Math.max(right, map[chars[i] - 'a']);
            if (i == right) {// 找到最远出现位置
                result.add(right - left + 1);
                left = i + 1;//重新划分区间
            }
        }
        return result;
    }
}
