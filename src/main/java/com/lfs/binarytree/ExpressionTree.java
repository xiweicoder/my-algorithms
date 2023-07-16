package com.lfs.binarytree;

import java.util.LinkedList;

/*
    根据后缀表达式构造表达式树
 */
public class ExpressionTree {
    /*
        因为这道题中的value是String类型,而我们之前的value都是int类型,所以在这里重新创建一个新的TreeNode类
     */
    static class TreeNode {
        public String val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(String val) {
            this.val = val;
        }

        public TreeNode(TreeNode left, String val, TreeNode right) {
            this.left = left;
            this.val = val;
            this.right = right;
        }

        @Override
        public String toString() {
            return this.val;
        }
    }
    /*
        表达式树
            *
           / \
          -   3
         / \
        2   1

         21-3*
         2,1入栈，遇到- 创建为root，将先前入栈的数字与root创建关系，然后再将 -
         入栈；  3入栈，遇到* 弹出 -，3, 构建关系将*作为root，并最终入栈，结束循环，栈中只有*
     */
    public TreeNode constructExpressionTree(String[] tokens) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (String t : tokens) {
            switch (t) {
                case "+", "-", "*", "/" -> {
                    TreeNode node = new TreeNode(t);
                    TreeNode left = stack.pop();
                    TreeNode right = stack.pop();
                    node.left = left;
                    node.right = right;
                    stack.push(node);
                }
                default -> {// 数字
                    stack.push(new TreeNode(t));
                }
            }
        }
        return stack.peek();// 返回展示栈中最后一个元素,也是root
    }
}
