package com.lfs.string;

/*
    反转字符串**
 */
public class ReverseString344 {
    public void reverseString(char[] ch) {
        int i = 0;
        int j = ch.length - 1;

        for (; i < j; i++, j--) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }
}
