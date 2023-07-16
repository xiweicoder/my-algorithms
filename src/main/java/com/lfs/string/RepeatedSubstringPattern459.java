package com.lfs.string;

/*
    重复子字符串
 */
public class RepeatedSubstringPattern459 {
    /*
        使用kmp实现
        详细内容见代码随想录
        思路:
        正常求next数组, 用字符串的长度 % (用字符串的长度 - 最长相等前后缀的长度) == 0 则重复
        a b a b a b a b
        0 0 1 2 3 4 5 6     :next

                    8 % (8 - 6) = 0
        为什么可以这么求?
         索引:   0 1 2 3 4 5 6 7
         原字符串:a b a b a b a b     最长相等前后缀: a b a b a b
         前缀:   a b a b a b
         后缀:       a b a b a b

         具体推导过程不写,详细可见代码随想录,结论: (01) = (23) = (45) = (67)
            如果一个字符串是由重复的子串组成的,那么 重复子串的最小单位就是最长相等前后缀不包括的那一部分
            [字符串的长度 - 最长相等前后缀的长度 = 字符串中不包含最长相等前后缀的长度 (a b)  ]

         既然整个字符串是由重复的子串构成,那么用  字符串的长度 取余(%) 重复子串的最小单位  一定等于 0


     */
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) return false;

        int len = s.length();
        int[] next = new int[s.length()];
        getNext(next, s);

        // 最后判断是否是重复的子字符串，这里 next[len] 即代表next数组末尾的值
        if (next[len - 1] > 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;
    }

    private void getNext(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}
