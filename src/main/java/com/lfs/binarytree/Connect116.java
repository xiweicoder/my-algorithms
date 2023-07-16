package com.lfs.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/*
    填充每个节点的下一个右侧节点指针(完全二叉树)
 */
public class Connect116 {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /*
        因为要指向下一个节点,所以就要找到两个节点,并重新赋值
     */
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return root;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            Node cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }

            for (int i = 1; i < size; i++) {
                Node next = queue.poll();

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
