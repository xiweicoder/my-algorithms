package com.lfs.string;

/*
    反转字符串里的单词-不采用javaAPI
 */
public class ReverseWords151_1 {

    /**
     * 不使用Java内置方法实现
     * <p>
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    public String reverseWords(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        // System.out.println("ReverseWords.removeSpace() called with: s = [" + s + "]");
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;// 去除首尾多余空格
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {// 循环条件 等于
            char c = s.charAt(start);
            /*
                the sky is blue  sb:the
                c: 掌管非空格拼接字符串
                sb.charAt(sb.length() - 1): 掌管不多拼接第二个空格。在拼接一个空格后,若下一个还是空格则不会拼接
             */
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {// 拼接的字符不是空格 或 拼接好字符串最后一个字符不是空格 满足其中之一进行拼串,否则++
                sb.append(c);
            }
            start++;
        }
        // System.out.println("ReverseWords.removeSpace returned: sb = [" + sb + "]");
        return sb;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    public void reverseString(StringBuilder sb, int start, int end) {
        // System.out.println("ReverseWords.reverseString() called with: sb = [" + sb + "], start = [" + start + "], end = [" + end + "]");
        while (start < end) {//不可能等于,至少要有两个字符,等于了就只有一个字符了,一个字符不能反转
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));// 设置起始索引0位置字符串为 传过来字符串的最后一个字符:  ehe sky is blue
            sb.setCharAt(end, temp);// 设置最后一个索引位置字符串为 传过来字符串的第一个字符:   ehe sky is blut
            start++;
            end--;
        }
        // System.out.println("ReverseWords.reverseString returned: sb = [" + sb + "]");
    }

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        /*
        s:start     e:end
            se
            ↓↓
            eulb si yks eht

            s   e
            ↓   ↓
            eulb si yks eht

                 se
                 ↓↓
            eulb si yks eht

                        s e
                        ↓ ↓
            eulb si yks eht

        end: 当end指向空格时,反转 start 到 end-1 长度的字符串,然后start指向end的前一位,end再指向start的前一位,重新开始循环
         */
        while (start < n) {// start 最后会跑到边界之外,两个while, 一个控制整体的进行,一个判断空格前单词
            while (end < n && sb.charAt(end) != ' ') {// 最后一个单词时,end 等于长度不进入循环,直接反转,反转(里面是索引),所以最后一位是end-1,长度才是end
                end++;
            }
            reverseString(sb, start, end - 1);// 最后一个单词
            start = end + 1;
            end = start + 1;
        }
    }

    public static void main(String[] args) {
        String s = new ReverseWords151_1().reverseWords("the sky is blue");
        System.out.println(s);
    }
}
