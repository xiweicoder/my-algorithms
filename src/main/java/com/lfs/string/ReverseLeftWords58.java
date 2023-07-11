package com.lfs.string;

/*
    左旋转字符串
    这题很灵活,这里给出两种方法,2种反转方式,可以有四种题解
    java等提供的API都是左闭右开,含头不含尾

 */
public class ReverseLeftWords58 {

    /*
        1.反转前n个
        2.反转length -n 个
        3.整个串都反转
     */
    public String reverseLeftWords(String s, int n) {
        int len = s.length();
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);// n是索引比原个数大一,反转函数是左闭右闭,所以反转前n个字符  是 (0,n-1) 从零开始到n-1个字符 =n
        reverseString(sb, n, len - 1);
        return sb.reverse().toString();
    }

    //反转函数,[]左闭右闭,左右都包括
    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);// 获取索引为start处的字符 sb.charAt
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }

    //解法二：空间复杂度：O(1)。用原始数组来进行反转操作
    /*
        1.先整个串都反转
        2.反转前length-3个
        3.反转剩下的3个
     */
    public String reverseLeftWords2(String s, int n) {
        char[] chars = s.toCharArray();
        reverse(chars, 0, chars.length - 1);
        reverse(chars, 0, chars.length - 1 - n);
        reverse(chars, chars.length - n, chars.length - 1);
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }

    public String reverseLeftWords3(String s, int n) {
        StringBuilder sb = new StringBuilder();
        re(sb, 0, n - 1);
        re(sb, n, s.length() - 1);
        return re(sb, 0, s.length() - 1).toString();

    }

    private StringBuilder re(StringBuilder sb, int start, int end) {

        if (start < end) {
            char temp = sb.charAt(start);

            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, sb.charAt(temp));
            start++;
            end--;
        }
        return sb;
    }
}