package com.lfs.string;

/*
    找出字符串中第一个匹配项的下标
 */
public class KMP28 {
    //前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == needle.length()) {// 模式串与主串匹配成功返回长度
                return i - needle.length() + 1;// 2 -3 + 1 i是0 1 2,等j==needle.length(),i这时是2
            }
        }
        return -1;

    }

    // 求next数组
    private void getNext(int[] next, String s) {
        /*
            j: 前缀末尾  i:后缀末尾
            后缀为主串,前缀为模式串 进行自匹配
            j:还代表着i之前包括i子串的最长相等前后缀的长度
            s.length(): 模式串长度

         */
        int j = 0;
        next[0] = 0;// 第一位只会是0
        for (int i = 1; i < s.length(); i++) {
            /*
                不相等,持续回退,回退位置:前一个元素的next数组大小 作为索引位置 且索引不能为负数
             */
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];

            }
            if (s.charAt(j) == s.charAt(i)) {//匹配成功 i,j都向前移动一步
                j++;
            }
            next[i] = j;//填充next数组
        }
    }

    public static void main(String[] args) {
        int i = new KMP28().strStr("sadbutsad", "sad");
        System.out.println(i);
    }
}
