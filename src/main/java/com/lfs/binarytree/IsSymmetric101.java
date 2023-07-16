package com.lfs.binarytree;

/*
    对称二叉树
 */
public class IsSymmetric101 {
    /*
        边上的对比,里面的对比
        注意里面的三个判断都不能省略
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;//都为空时 返回true
        if (left == null || right == null) return false;// 走到这肯定有一个不为空,这时只要有一个为空,就不可能对称;防止空指针
        if (left.val != right.val) return  false;// 真正的比较语句
        return check(left.left, right.right) && check(left.right, right.left); // 递归
    }
}
