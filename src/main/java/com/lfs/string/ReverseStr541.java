package com.lfs.string;

/*
    反转字符串2
    每2*k循环,反转前k个,最后不满k个,都反转
 */
public class ReverseStr541 {

    /*
        for循环每2*k变动幅度
        边界条件的处理,反转代码reverse,左闭右闭 [i, i + k - 1],所以下次判断就从i+k开始
     */
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();// 反转要转成char
        // 1. 每隔 2k 个字符的前 k 个字符进行反转
        for (int i = 0; i < ch.length; i += 2 * k) {
            // 2. 剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符
            if (i + k <= ch.length) {// 这里判断是个数,不用-1
                reverse(ch, i, i + k - 1);
                continue;
            }
            // 3. 剩余字符少于 k 个，则将剩余字符全部反转
            reverse(ch, i, ch.length - 1);// 因为是剩下小于k的开始位置从i开始
        }
        return new String(ch);

    }

    // 定义翻转函数
    public void reverse(char[] ch, int i, int j) {
        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }

    }

}
