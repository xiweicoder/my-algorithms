package com.lfs.binarytree;

import java.util.ArrayList;
import java.util.List;

/*
    中序遍历
    左值右
 */
public class InorderTraversal94 {

    //递归实现
    public List<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    public void inOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        inOrder(node.left, result);
        result.add(node.val);
        inOrder(node.right, result);
    }
}
