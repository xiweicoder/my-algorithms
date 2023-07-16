package com.lfs.binarytree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    N叉树的层序遍历
 */
public class LevelOrder429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /*
        与102相比多个遍历加入队列的过程
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> listItem = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                listItem.add(poll.val);
                if (poll.children != null) {
                    for (Node c : poll.children) {
                        queue.offer(c);
                    }
                }
            }
            result.add(listItem);
        }
        return result;
    }
}
