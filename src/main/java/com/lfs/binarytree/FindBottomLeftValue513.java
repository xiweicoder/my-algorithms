package com.lfs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
    找树左下角的值
 */
public class FindBottomLeftValue513 {
    /*
         与199相似
         因为i++  要求最左边的值: i == 0, 每层遍历的第一个元素
     */
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
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
                /*
                    每层第一个元素 这里既不是累加操作,也不是求最大值,就是找每层的第一个元素,
                    直到最后一层,结果会不断的覆盖,最终剩下最后一层的第一个元素
                 */
                if (i == 0) {
                    res = poll.val;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        int a = new FindBottomLeftValue513().findBottomLeftValue(root);
        System.out.println(a);
    }
}
