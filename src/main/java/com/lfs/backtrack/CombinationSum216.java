package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    组合总和3
    出所有相加之和为 n 的 k 个数的组合
 */
public class CombinationSum216 {
    /*
        目标值是n , k是元素个数
        两个剪枝操作, 一个控制和的大小不要大于目标和     一个控制循环次数 和77的剪枝一样
        本质上和77一模一样, 但要注意一些细节地方 for循环要等于=
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(n, k, 1, 0);
        return result;
    }

    private void backTracking(int targetSum, int k, int startIndex, int sum) {
        // 减枝
        if (sum > targetSum) {
            return;
        }

        if (path.size() == k) {
            if (sum == targetSum) result.add(new ArrayList<>(path));
            return;
        }

        // 减枝 9 - (k - path.size()) + 1
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backTracking(targetSum, k, i + 1, sum);
            //回溯
            path.removeLast();
            //回溯
            sum -= i;
        }
    }
}
