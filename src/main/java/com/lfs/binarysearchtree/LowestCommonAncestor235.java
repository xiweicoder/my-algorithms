package com.lfs.binarysearchtree;

/*
    二叉搜索树的最近公共祖先
 */
public class LowestCommonAncestor235 {
   /*
            __ 6 __
           /       \
          2         8
         / \       / \
        0   4     7   9
           / \
          3   5

          待查找节点 p q 在某一节点的两侧，那么此节点就是最近的公共祖先
          注意 p q 有可能是 p:4   q:5     但我们写的代码也包含了这种情况,我们的条件只是小于,不满足条件直接返回的情况那就是大于等于,
          我们包含了等于的情况,所以 p=4 = root.val时
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if (p.val < root.val && q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            if (p.val > root.val && q.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }
}
