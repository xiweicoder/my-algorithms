package com.lfs.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    在每个树行中找最大值
 */
public class LargestValues515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return resList;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = queue.size();// 提前记录大小 ,不能写在while中,size是一直在变化的(加加减减)

            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();// 弹出一个元素 size就--
                max = Math.max(max, poll.val);

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            resList.add(max);
        }
        return resList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        List<Integer> list = new LargestValues515().largestValues(root);
        System.out.println(list);
    }
}
