package com.lfs.binarytree;

/*
    另一棵树的子树
 */
public class IsSubtree572 {
    /*
        判断subRoot是否是root的子树
        1.判断两棵树是否相等(简单判断是不是一颗树)
        2.判断root的左子树 与subRoot是否相等
        3.判断root的右子树 与subRoot是否相等
        递归...
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // 判断两棵树是否相等100
    public boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
