package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    全排列

    {[1,2],[2,1]} 是一个组合,是两个排列
 */
public class Permute46_2 {
    /*
        组合通过startIndex来控制避免重复选取同一个元素,在本解法中通过 path.contains(nums[i])) 来避免重复
        这种方法必须规定nums不能有重复的元素,有重复的元素就用used数组的形式
     */
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return result;
        backtracking(nums);
        return result;
    }

    public void backtracking(int[] nums) {
        /*
            1、通过控制 path的size 和 传入的 length 来确保排列完成
            2、通过判断path中是否存在本次的数字 来避免重复选取
            别忘了收割结果时要 return
         */
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 如果path中已有，则跳过
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums);
            path.removeLast();
        }
    }
}
