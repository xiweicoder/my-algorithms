package com.lfs.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    二叉树的右视图
 */
public class RightSideView199 {
    /*
        每次返回每层的最后一个字段即可。
        每次poll一个元素的同时,都会加入一些新的元素,而最后加入的元素就是我们看到的节点,也是最后poll的元素,
        因为i与size是差1的,所以当每层最后一个元素时(我们看到的)即 size-1 = i 加入集合
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        if (root == null) return result;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                if (i == size - 1) {//每层的最后一个元素
                    result.add(poll.val);
                }
            }
        }
        return result;
    }
}
