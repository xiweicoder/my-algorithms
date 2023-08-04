package com.lfs.hashtable;

import java.util.Arrays;

/*
    有效的字母异位词 此题更详细详细可见黑马
    char 类型的数 + - 一个数(零也行)=数值类型
    可以用char类型的数方便我们快速找到相对的数组位置
 */
public class IsAnagram242 {

    public boolean isAnagram(String s, String t) {
        int[] ints = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // -97 还是 -'a' 减去什么都一样-1也行 不动也行 只是一个相对位置,只是会浪费空间
            // 这里减去'a'是因为 题目要求都是小写字母，小写字母从97开始,我们定义了数组大小为26,我们就只能减去'a',因为小写字母最小就是a
            // 假如 c=a 那他在数组索引位置就是0 ，这样就正好填满26个位置(0-25)
            // 将a-z映射到 0-25上
            ints[c - 'a']++;
        }
        System.out.println(Arrays.toString(ints));
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            ints[c - 'a']--;
        }
//        System.out.println(Arrays.toString(ints));
        for (int i : ints) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean anagram = new IsAnagram242().isAnagram("rat", "car");
        System.out.println(anagram);
    }
}
