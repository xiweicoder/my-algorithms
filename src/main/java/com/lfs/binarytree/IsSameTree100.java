package com.lfs.binarytree;

/*
    相同的树
    判断是不是一颗相同的树
 */
public class IsSameTree100 {
    /*
        与101相似
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
