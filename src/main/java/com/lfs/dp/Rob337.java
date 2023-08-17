package com.lfs.dp;

import com.lfs.binarytree.TreeNode;

/*
    打家劫舍3
    树
 */
public class Rob337 {
    /*
        当前节点 偷 还是 不偷
         1、dp数组的含义:
         dp[0]: 不偷 最大值
         dp[1]: 偷 最大值

         后序遍历方式
         具体见代码随想录23 有过程分析比较详细
     */
    public int rob(TreeNode root) {
        int[] res = robInternal(root);
        return Math.max(res[0], res[1]);
    }

    int[] robInternal(TreeNode root) {
        int[] dp = new int[2];
        if (root == null)
            return dp;

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        //不偷当前节点,左右孩子分别在偷与不偷中的最大值 (也可能不偷孩子)
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];//偷当前节点 当前节点的价值 + 左右孩子不偷的价值
        return dp;
    }
}
