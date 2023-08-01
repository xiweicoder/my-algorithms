package com.lfs.backtrack;

import java.util.LinkedList;
import java.util.List;

/*
    分割回文子串
 */
public class Partition131 {
    /*
        (s, startIndex, i) i是for循环控制的,不断++,以此切割, 然后 递归时 startIndex i++ 不断循环
        重点注意 先for 再 递归
 */
    LinkedList<String> path = new LinkedList<>();
    List<List<String>> result = new LinkedList<>();

    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;

    }

    private void backtracking(String s, int startIndex) {
        //如果起始位置大于s的大小，说明找到了一组分割方案
        if (s.length() == startIndex) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (isPalindrome(s, startIndex, i)) {
                String substring = s.substring(startIndex, i + 1);//截取字符串,含头不含尾
                path.add(substring);
            } else {
                continue;
            }
            //起始位置后移，保证不重复
            backtracking(s, i + 1);// 递归不用在判断条件中
            path.removeLast();
        }

    }

    // 判断回文
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) { //这里是 i < j
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}
