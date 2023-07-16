package com.lfs.binarytree;

import java.util.*;

/*
    二叉树层序遍历二
    从底部开始遍历
    1.将从顶部开始遍历的代码,反转 Collections.reverse(resList);即可
 */
public class LevelOrderBottom107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<List<Integer>>();

        if (root == null) {
            return resList;

        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();// 提前记录大小

            while (size > 0) {
                TreeNode poll = queue.poll();// 弹出一个元素size--
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
        Collections.reverse(resList);
        return resList;

        // 手动反转代码
      /*  for (int i = list.size() - 1; i >= 0; i-- ) {
            result.add(list.get(i));
        }*/
    }
}
