package com.lfs.greedy;

/*
    单调递增的数字
 */
public class IncreasingDigits738 {
    /*
        输入n
        result要求:
            1、小于等于n
            2、数字的各个位上单增
            3、满足1、2的最大数值
        例如:
        n=10    result = 9  因为 1 0 1>0 各个位上并不是单增的
        n=1234  result = 1234 1234满足任何条件 单增
        n=332   result = 299

        思路:
        从后向前遍历,两两判断: 332
        32 -> 29 = 3 29 32-> 29 = 299

        如果从前向后遍历的话: 332(错误演示)
            33 满足条件; 32 变成 29 最终答案: 329 错误
     */
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        int start = s.length();//哪一位往后全都赋成999...

        /*
            i是可以等于0的,我们用的就是i 和 i+1 当i=0时没有负数影响;
            但要是使用 i 和 i-1,那么i不能等于0,i=0时i-1 = -1,索引出现负数
         */
        for (int i = s.length() - 2; i >= 0; i--) {
            /*
              ...  3 3 2
                     i i+1
              解释: 因为3>2 3--; start = i+1
             */

            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i + 1;//从哪一位往后全都赋成999...
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}
