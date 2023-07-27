package com.lfs.binarysearchtree;

import java.util.LinkedList;

/*
    二叉搜索树的范围和
 */
public class RangeSumBST938 {

    // 方法一: 直接从根节点递归 剪枝
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) return 0;

        // 两个剪枝操作,当前节点小于low那就不用看当前节点的左子树,直接去看当前节点右子树
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {// 同理
            return rangeSumBST(root.left, low, high);
        }

        //在范围内
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }

    //方法二 迭代 慢
    public int rangeSumBST2(TreeNode root, int low, int high) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int sum = 0;

        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode pop = stack.pop();

                if (pop.val > high) break;// 剪枝操作 提前返回

                if (pop.val >= low) {
                    sum += pop.val;
                }
                cur = pop.right;
            }
        }
        return sum;
    }
}
