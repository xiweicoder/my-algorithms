package com.lfs.string;

import java.util.LinkedList;

/*
    反转字符串里的单词-栈的方式
 */
public class ReverseWords151_2 {
    public String reverseWords(String s) {
        LinkedList<String> stack = new LinkedList<>();
        s = s.trim();//删除头尾空格
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                temp.append(s.charAt(i));
                continue;
            }
            if (s.charAt(i) == ' ' && temp.length() > 0) {// 遇到空格并且前面有单词 进栈
                stack.push(temp.toString());
                temp = new StringBuilder();// 重新开始拼串
            }
        }
        if (temp.length() > 0) {// 拼接最后一个单词,因为最后一个单词后面没有空格,所以只能单独拿出来写最后一个单词的方式
            stack.push(temp.toString());
        }
        StringBuilder ans = new StringBuilder();
        // 当栈里不为空时,弹出,并判断()栈不为空 拼接空格, 当最后一个单词弹出,栈就空了,此时也不会进行拼接空格
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
            if (!stack.isEmpty()) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }
}
