package com.lfs.hashtable;

/*
    字符串中第一个唯一字符
 */
public class FirstUniqChar387 {
    /*
        遍历两次,第一次遍历在数组中+1,,第二次遍历判断字符相对应的数组大小是否等于1
     */
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            array[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);// 重点
            if (1 == array[c - 'a']) {
                return i;
            }
        }
        return -1;

    }
}
