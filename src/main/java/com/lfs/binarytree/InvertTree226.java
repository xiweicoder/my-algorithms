package com.lfs.binarytree;

/*
    反转二叉树
 */
public class InvertTree226 {
    /*
        递归 左 = 右
            右 = 左
     */
    public TreeNode invertTree(TreeNode root) {
        fn(root);
        return root;
    }

    private void fn(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        fn(node.left);
        fn(node.right);
    }
}
