package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
    组合总和2
 */
public class CombinationSum40 {
    /*
        本题重点在去重,去重操作和 hashtable15 操作相似
     */
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        backTracking(candidates, target, 0);
        return res;
    }

    private void backTracking(int[] candidates, int target, int startIndex) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        /*
            i > startIndex 而不是i>0 因为是多次判断
            递归的话 ↓ i是不会变的
            for循环 →  i 会+1

            本身是for循环里面有递归,递归并不会导致i变化
            只有一次循环完后(也是递归多次后),i+1 会触发去重操作 
            我们去的是后面小树的逻辑, 112 1开始的情况我们包含了 后面的1的情况我们去重了
         */
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {// 注意这里的剪枝操作,和写在外面的sum > target 相等 但是效率要快很多
            //正确剔除重复解的办法
            //跳过同一树层使用过的元素
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }

            sum += candidates[i];
            path.add(candidates[i]);
            // i+1 代表当前组内元素只选取一次
            backTracking(candidates, target, i + 1);

            sum -= candidates[i];
            path.removeLast();
        }
    }
}
