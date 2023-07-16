package com.lfs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
    二叉树的最大深度
 */
public class MaxDepth104 {
    /*
        这里面递归最快
            深度:2         深度:3        深度:1
            1            1            1
           / \          / \
          2   3        2   3
                            \
                             4
     */
    /*
        方法一 层序遍历
        采用队列的方式,先将根节点加入队列,当队列不为空时进行循环,循环次数为之前加入队列节点个数,循环时,再加入节点
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);// 加入左节点
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            depth++;// 注意depth在for循环之外统计
        }
        return depth;
    }

    // 方法二 后序遍历  leetcode中不要使用这种,用递归的方式更快
    public int maxDepth2(TreeNode root) {
        TreeNode cur = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pop = null;
        int max = 0;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                max = Math.max(stack.size(), max);
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == pop || peek.right == null) {
                    pop = stack.pop();
                } else {
                    cur = peek.right;
                }
            }
        }
        return max;
    }


    // 方法三 后序遍历 (递归)
    public int maxDepth3(TreeNode root) {
        if (root == null) return 0;

        int d1 = maxDepth3(root.left);
        int d2 = maxDepth3(root.right);
        return Math.max(d1, d2) + 1;
    }
}
