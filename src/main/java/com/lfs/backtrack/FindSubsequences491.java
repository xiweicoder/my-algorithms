package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
    递增子序列
 */
public class FindSubsequences491 {
    /*
        这道题不能排序,排序会破坏结构,导致结果出现错误(子序列,顺序变了序列也就变了),就不能用子集2 等去重方法做了

        树层上不能重复取, (横着不能重复取)
        树枝上可以重复去, (竖着可以重复取)
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums, 0);
        return result;
    }

    private void backTracking(int[] nums, int startIndex) {
        if (path.size() >= 2) result.add(new ArrayList<>(path));// 收割结果 (里面字母大于等于2时)
        HashSet<Integer> set = new HashSet<>();// set要写在递归里面
        for (int i = startIndex; i < nums.length; i++) {
            /*
                1、set中包含我们本次所取元素,说明这个元素我们之前取过,跳过本次循环
                2、本次所取得元素如果小于path最右边的元素,就不是递增了 跳过本次循环
             */
            if (!path.isEmpty() && path.get(path.size() - 1) > nums[i] || set.contains(nums[i])) continue;
            set.add(nums[i]);
            path.add(nums[i]);
            backTracking(nums, i + 1);
            path.removeLast();
        }
    }
}
