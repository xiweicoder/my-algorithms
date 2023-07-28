package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class test {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;

    }

    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < n; i++) {
            path.add(startIndex + 1);
            backtracking(n, k, startIndex + 1);
            path.pop();
        }
    }
}
