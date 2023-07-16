package com.lfs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
    填充每个节点的下一个右侧节点指针(非完全二叉树)
 */
public class Connect117 {
    class Node {
        public int val;
        public Connect116.Node left;
        public Connect116.Node right;
        public Connect116.Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Connect116.Node _left, Connect116.Node _right, Connect116.Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /*
        与116一模一样的代码
     */
    public Connect116.Node connect(Connect116.Node root) {
        Queue<Connect116.Node> queue = new LinkedList<>();
        if (root == null) return root;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Connect116.Node cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }

            for (int i = 1; i < size; i++) {
                Connect116.Node next = queue.poll();

                if (next.left != null) {
                    queue.offer(next.left);
                }
                if (next.right != null) {
                    queue.offer(next.right);
                }
                cur.next = next;// 上一个指向下一个节点
                cur = next; // 重新赋值,循环操作
            }
        }
        return root;
    }
}
