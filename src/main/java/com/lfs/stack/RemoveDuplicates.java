package com.lfs.stack;

import java.util.Stack;

/*
    删除字符串中所有的相邻重复项
 */
public class RemoveDuplicates {

    /*
        思路:
        将字符串依次拿取,栈为空或栈中元素与peek元素不同,将当前元素压栈,
            else(peek元素与当前元素相等),pop栈中元素
        最后遍历栈,逆向拼接栈中的元素 并返回
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        String str = "";
        while (!stack.isEmpty()) {
            str = stack.pop() + str;// 顺序不能颠倒,要将早弹出栈的拼接在后面
        }
        return str;
    }

    //方法二: 采用字符串作为栈  仔细想想思路和方法一  一模一样
    public String removeDuplicates2(String s) {
        // 将 res 当做栈
        // 也可以用 StringBuilder 来修改字符串，速度更快
        // StringBuilder res = new StringBuilder();
        StringBuffer res = new StringBuffer();
        // top为 res 的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当 top > 0,即栈中有字符时，当前字符如果和栈中字符相等，弹出栈顶字符，同时 top--
            if (top >= 0 && res.charAt(top) == c) {// c 是一直变动的    res.charAt(top)是栈peek
                res.deleteCharAt(top);
                top--;
                // 否则，将该字符 入栈，同时top++
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String i = new RemoveDuplicates().removeDuplicates("abbaca");
        System.out.println(i);
    }
}
