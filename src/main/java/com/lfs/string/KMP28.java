package com.lfs.string;

/*
    找出字符串中第一个匹配项的下标
 */
public class KMP28 {
    /*
        求next数组自匹配,j作为最大相等前后缀填充next数组;j作为前缀末尾来遍历判断
        判断两个串,不同于求next,求next是ij一前一后,进行判断,目的是求最大前后缀,
        而判断串,j i 在同一起点,目的是判断每个值是否相等,
     */

    //前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {// 一定要先走while逻辑,先判断不相等的情况,顺序不能颠倒
                j = next[j - 1];// 不相等回退到next数组上一个数 ,以这个数作为索引处
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            /*
                求匹配成功一开始的索引位置, 注意:结束循环的条件是j == 模式串长度,不用管i后面了
                判断j == needle.length() 上一步一定是 needle.charAt(j) == haystack.charAt(i)
                此时i不一定就在末尾的位置:

                  1 2 3 4 5 6 7 8
                      3 4 5
                  匹配成功:     i - needle.length() + 1 = 4 - 3 +1 = 2  开始匹配索引为2

                  若难以理解,将模式串拿到开始位置,假设此时也匹配成功,因为我们只求索引:
                  1 2 3 4 5
                  3 4 5    -(减)
                  4 5   相减就剩下4,5,则说明匹配位置就在下一个索引处 即 2

             */
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
            while (j > 0 && s.charAt(j) != s.charAt(i)) {// 一定要先走while逻辑,先判断不相等的情况,顺序不能颠倒
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {//匹配成功 i,j都向前移动一步 相等向前走不用j>0
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
