package com.lfs.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    统计二叉树的节点个数
 */
public class CountNodes222 {

    // 前序 慢
    public int countNodes2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int count = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                count++;
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }
        return count;
    }

    // 前序 递归块
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
