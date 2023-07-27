package com.lfs.binarysearchtree;

import java.util.LinkedList;

/*
    二叉搜索树的最小绝对差
        和98同理
 */
public class MinimumDifference530 {
    int result = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {
        recursion(root);
        return result;
    }

    private void recursion(TreeNode node) {
        if (node == null) return;
        recursion(node.left);
        if (prev != null) {
            result = Math.min(result, node.val - prev.val);
        }
        prev = node;
        recursion(node.right);
    }

    // 迭代法 慢
    public int getMinimumDifference2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        int result = Integer.MAX_VALUE;
        TreeNode prev = null;
        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();

                if (prev != null) {
                    result = Math.min(result, pop.val - prev.val);
                }
                prev = pop;

                p = pop.right;
            }
        }
        return result;
    }
}
