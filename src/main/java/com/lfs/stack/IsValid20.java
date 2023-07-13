package com.lfs.stack;

import java.util.Stack;

/*
    有效的括号
 */
public class IsValid20 {
    /*
        与两数之和有些类似,遇到(就将相反的括号压栈,遇到右括号,判断并弹出
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');

            } else if (c == '{') {
                stack.push('}');
            } else {
                if (!stack.isEmpty() && c == stack.peek()) {// 注意要判空,如果第一个就是右括号就空指针
                    stack.pop();
                } else {// 不是一对的情况 (]
                    return false;
                }

            }
        }
        return stack.isEmpty();// 栈为空则全都匹配成功
    }
}
