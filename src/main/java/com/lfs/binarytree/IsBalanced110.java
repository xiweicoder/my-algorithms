package com.lfs.binarytree;

/*
    平衡二叉树
 */
public class IsBalanced110 {
    /*
       深度:2         深度:3        深度:1
       高度:2         高度:3        高度:1
        1            1            1
       / \          / \
      2   3        2   3
                        \
                         4
    */
    /*
        采用后序遍历的方式,因为要想得到高度,就要知道左孩与右孩的高度是否符合要求,才能知道高度合不合法
        递归更容易也更快

        有的同学一定疑惑，为什么104.二叉树的最大深度中求的是二叉树的最大深度，也用的是后序遍历?
            那是因为代码的逻辑其实是求的根节点的高度，而根节点的高度就是这棵树的最大深度，所以才可以使用后序遍历。
     */
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;

        int l = getHeight(root.left);
        if (l == -1) return -1;

        int r = getHeight(root.right);
        if (r == -1) return -1;

        if (Math.abs(l - r) > 1) {
            return -1;
        } else {
            return 1 + Math.max(l, r);
        }
    }
}
