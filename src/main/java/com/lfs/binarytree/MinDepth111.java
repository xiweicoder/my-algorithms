package com.lfs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
    二叉树的最小深度
 */
public class MinDepth111 {
    /*
        层序遍历，遇到的第一个叶子节点所在层就是最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;// 注意depth前面统计最小次数,放后面有可能还没统计直接return了
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return depth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);// 加入左节点
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }

    // 递归方式
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        int d1 = minDepth2(root.left);
        int d2 = minDepth2(root.right);
        if (d1 == 0) return d2 + 1;// 只有一条腿的时候,不应该采用少腿的一方的深度
        if (d2 == 0) return d1 + 1;
        return Math.min(d1, d2) + 1;
    }
}
