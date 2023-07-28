package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    组合总和3
    出所有相加之和为 n 的 k 个数的组合
 */
public class CombinationSum216 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {

        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {

        if (sum == n) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i <= 9; i++) {
            sum = sum + i;
            path.add(i);
            backtracking(n, k, i + 1);
            path.removeLast();
        }
    }
}
