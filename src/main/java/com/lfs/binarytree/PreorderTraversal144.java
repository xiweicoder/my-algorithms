package com.lfs.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    二叉树前序遍历
    值左右
    走的路径一样
 */
public class PreorderTraversal144 {
    // 方法一
    /*
        思路: 遍历左节点,一直向左走,同时压栈记录走过的路径,当左节点为空时,开始回走,
        回走的同时,遍历右节点,当有左孩子的时候还是照常处理,形成循环
        简单思路: 根节点走左孩子,左孩子为空,走右孩子,右孩子有左孩子,走左孩子,左孩子为空,走右孩子...
        左为主,左空走右,右左走左
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;

            } else {// 回走
                TreeNode pop = stack.pop();
                cur = pop.right;
            }
        }
        return result;
    }

    // 方法二 递归实现
    public List<Integer> preorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    public void preOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }
}
