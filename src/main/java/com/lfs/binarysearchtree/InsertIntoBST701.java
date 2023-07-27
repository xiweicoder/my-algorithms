package com.lfs.binarysearchtree;

/*
    二叉搜索树的插入操作
 */
public class InsertIntoBST701 {
    /*
        我们插入节点可以都插入在叶子结点的位置 这样简单很多。当然我们也可以不插入在叶子结点的位置,但这样就复杂了
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}
