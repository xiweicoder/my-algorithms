package com.lfs.binarysearchtree;

/*
    二叉树的最近公共祖先
 */
public class LowestCommonAncestor236 {
    /*
        本来会有两种情况,但是我们的代码能够将这两种情况都包含
        倒着遍历采用后序遍历的方式
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) { // 递归结束条件
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 值 的处理 left right都是 满足条件的值(满足递归结束条件)就是等于 p 或 q
        if (left == null && right == null) { // 若未找到节点 p 或 q
            return null;
        } else if (left == null && right != null) { // 若找到一个节点
            return right;
        } else if (left != null && right == null) { // 若找到一个节点
            return left;
        } else { // 若找到两个节点
            return root;
        }
    }
}
