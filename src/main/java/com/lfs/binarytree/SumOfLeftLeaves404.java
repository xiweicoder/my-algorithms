package com.lfs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
    左叶子之和
 */
public class SumOfLeftLeaves404 {
    /*
        注意题目: 是左叶子结点: 左树的一个节点,并且这个节点没有左孩和右孩 ,这个左树可以是右树里面的左树
     */
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {// 只在左边操作
                    queue.offer(poll.left);

                    if (poll.left.left == null && poll.left.right == null) {// 判断是不是叶子节点
                        sum += poll.left.val;
                    }
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return sum;
    }
}
