package com.lfs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
    对称二叉树
 */
public class IsSymmetric101 {
    /*
        方法一: 递归
        边上的对比,里面的对比
        注意里面的三个判断都不能省略
     */
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    private boolean check(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;//都为空时 返回true
        if (left == null || right == null) return false;// 走到这肯定有一个不为空,这时只要有一个为空,就不可能对称;防止空指针
        if (left.val != right.val) return false;// 真正的比较语句,我们不能判断他能够成立,因为我们还没继续向后判断,但是我们可以判断他不是对称的,来排除
        return check(left.left, right.right) && check(left.right, right.left); // 递归
    }

    /**
     * 方法二
     * 迭代法
     * 使用普通队列
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()) {
            TreeNode leftNode = deque.poll();
            TreeNode rightNode = deque.poll();
            if (leftNode == null && rightNode == null) {
                continue;
            }
//            if (leftNode == null && rightNode != null) {
//                return false;
//            }
//            if (leftNode != null && rightNode == null) {
//                return false;
//            }
//            if (leftNode.val != rightNode.val) {
//                return false;
//            }
            // 以上三个判断条件合并
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
                return false;
            }
            // 这里顺序与使用Deque不同
            deque.offer(leftNode.left);
            deque.offer(rightNode.right);
            deque.offer(leftNode.right);
            deque.offer(rightNode.left);
        }
        return true;
    }
}
