package com.lfs.dp;

import com.lfs.binarytree.TreeNode;

public class test {
    public int rob(TreeNode root) {
        int[] res = robInterval(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robInterval(TreeNode root) {
        int[] dp = new int[2];
        if (root == null) return dp;

        int[] left = robInterval(root.left);
        int[] right = robInterval(root.right);

        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        dp[1] = root.val + left[0] + right[0];

        return dp;
    }
}
