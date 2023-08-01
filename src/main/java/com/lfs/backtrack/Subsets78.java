package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    子集
 */
public class Subsets78 {

    /*
        在每个节点中收割结果
     */
    List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果

    public List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        return result;
    }

    private void subsetsHelper(int[] nums, int startIndex) {
        // 一开始就收获到空集
        result.add(new ArrayList<>(path));//「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。

        if (startIndex >= nums.length) return;  //终止条件可不加,和for循环条件正好相反,不写也会退出循环
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }
}
