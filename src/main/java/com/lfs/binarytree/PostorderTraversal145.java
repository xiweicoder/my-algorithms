package com.lfs.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    后序遍历
    左右值
 */
public class PostorderTraversal145 {
    // 方法一
    /*
        (每个节点都会压栈,都会经过判断)
        后序遍历的前面和前序中序一样，不一样在弹栈的地方
        需要弹栈时,不要马上弹出,先判断 1.当前栈顶的右孩子是否为空 2.当前栈顶的右孩子是否等于上次弹栈元素(上次能弹栈说明没有左右孩子了)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();

        TreeNode cur = root;
        TreeNode pop = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == pop || peek.right == null) {// 重点代码
                    result.add(peek.val);
                    pop = stack.pop();
                } else {// 否则说明 还有右孩子,需要遍历
                    cur = peek.right;
                }
            }
        }
        return result;
    }

    // 方法二 递归实现
    public List<Integer> postorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    public void postOrder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        postOrder(node.left, result);
        postOrder(node.right, result);
        result.add(node.val);
    }

    public static void main(String[] args) {
        /*
                1
               / \
              2   3
             /   / \
            4   5   6
         */
        TreeNode root = new TreeNode(
                new TreeNode(new TreeNode(4), 2, null),
                1,
                new TreeNode(new TreeNode(5), 3, new TreeNode(6))
        );
        List<Integer> list = new PostorderTraversal145().postorderTraversal(root);
        System.out.println(list);
    }
}
