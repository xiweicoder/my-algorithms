package com.lfs.binarysearchtree;

import java.util.LinkedList;

/*
    判断是否合法
 */
public class IsValidBST98 {
    /*
        可以剪枝操作,当不满足条件时,并不会立刻退出左树递归，我们可以多加一个判断,并且在最后的结果返回中,少一个返回,就直接返回isValidBST(root.right);
     */
    long prev = Long.MIN_VALUE;// 注意一定要定义在外面,不然递归拿不到值

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (!left) return false;

        if (prev >= root.val) return false;
        prev = root.val;
        return isValidBST(root.right);
    }

    //迭代法 慢
    public boolean isValidBST2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        long prev = Long.MIN_VALUE;
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode pop = stack.pop();

                if (prev >= pop.val) return false;
                prev = pop.val;
                p = pop.right;
            }
        }
        return true;
    }
}
