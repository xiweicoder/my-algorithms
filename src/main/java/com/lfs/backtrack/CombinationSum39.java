package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    组合总和
 */
public class CombinationSum39 {

    /*
        先排序,当sum> target时直接终止本次循环来剪枝优化
        本题代码都写在方法里面,都可以,写在外面也可以
        本题是可以重复的,所以在递归时并不是 i+1 而是i
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    private void backtracking(
            int[] candidates, int target, int startIndex) {

        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;

            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, i);

            sum -= candidates[i];
            path.removeLast();
        }
    }
}
