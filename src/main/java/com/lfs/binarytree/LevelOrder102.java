package com.lfs.binarytree;

import java.util.*;

/*
    二叉树的层序遍历
 */
public class LevelOrder102 {
    /*
        一定要注意:在队列遍历开始之前,先将root加入到队列中
        别忘了 root 判空 !!
        这个代码不能再优化了
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();

        if (root == null) {
            return resList;

        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();// 提前记录大小 ,不能写在while中,size是一直在变化的(加加减减)

            while (size > 0) {
                TreeNode poll = queue.poll();// 弹出一个元素 size就--
                list.add(poll.val);// listItem收集数值

                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            resList.add(list);// list加入listItem
        }
        return resList;
    }
}