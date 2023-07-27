package com.lfs.binarysearchtree;

import java.util.ArrayList;

/*
    二叉搜索树中的众数
 */
/*
    注意求众数,而不是求count 众数是树的value，重点就是递归里面的两块逻辑
 */
public class FindMode501 {
    TreeNode prev = null;
    ArrayList<Integer> list;
    int count = 0;
    int maxCount = 0;


    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        recursion(root);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void recursion(TreeNode root) {
        if (root == null) return;

        recursion(root.left);
        int curValue = root.val;
        if (prev == null || prev.val != curValue) {
            count = 1;
        } else {
            count++;
        }

        if (maxCount < count) {
            list.clear();
            list.add(curValue);
            maxCount = count;
        } else if (maxCount == count) {
            list.add(curValue);
        }
        prev = root;
        recursion(root.right);
    }
}
