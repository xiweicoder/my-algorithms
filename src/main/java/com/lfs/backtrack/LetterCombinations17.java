package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.List;

/*
    电话号码的字母组合
    注意 是组合
 */
public class LetterCombinations17 {
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {// 传过来一个 " "
            return result;
        }

        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits, map, 0);
        return result;
    }

    StringBuilder sb = new StringBuilder();//拼串

    private void backtracking(String digits, String[] map, int index) {
        if (index == digits.length()) {//假如digits=“23” 索引为 0 1 是合理的, 当 index = 2 = digits时就不能再拼串了要收割结果
            result.add(sb.toString());// 拼完的串就是结果
            return;
        }

        String letter = map[digits.charAt(index) - '0'];// map[2] = "abc"
        for (int i = 0; i < letter.length(); i++) {// 拿着abc 做文章
            sb.append(letter.charAt(i));
            backtracking(digits, map, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
