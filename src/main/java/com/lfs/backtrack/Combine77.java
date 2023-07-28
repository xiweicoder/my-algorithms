package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    组合
    给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合
    组合不强调顺序,是没有顺序的 12 21 一样
    排列强调顺序,是有顺序之分的
 */
/*
    递归三部曲:  (很重要)
    1、递归函数的返回值以及参数
    2、回溯函数终止条件
    3、单层搜索的过程
 */
public class Combine77 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    public void backtracking(int n, int k, int startIndex) {// 1

        if (path.size() == k) {// 2
            result.add(new ArrayList<>(path));
            return;
        }

        // 3
        /*
            n = 15 ，k = 4。
            path.size() == 1 的时候，接下来要选择 3 个数，搜索起点最大是 13，最后一个被选的是 [13, 14, 15]；  13 + 3 -1
            path.size() == 2 的时候，接下来要选择 2 个数，搜索起点最大是 14，最后一个被选的是 [14, 15]；      14 + 2 -1
            path.size() == 3 的时候，接下来要选择 1 个数，搜索起点最大是 15，最后一个被选的是 [15]；          15 + 1 -1
            可以归纳出：
            搜索起点的上界 + 接下来要选择的元素个数 - 1 = n
            其中，接下来要选择的元素个数 = k - path.size()，整理得到：
            搜索起点的上界 = n - (k - path.size()) + 1      (搜索起点的最大值)
            所以，我们的剪枝过程就是：把 i <= n 改成 i <= n - (k - path.size()) + 1 ：
         */
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {// 注意我们这里是操作 i 有等于的情况
            path.add(i);
            backtracking(n, k, i + 1);// 改变起始索引
            path.removeLast();// 回溯
        }// 4 - (2-1 )+1
    }
}
