package com.lfs.binarysearchtree;

/*
    根据前序遍历结果构建二叉搜索树
 */
public class BstFromPreorder1008 {

    /*
        直接拿到前序的第一个元素创建出根节点
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 1; i < preorder.length; i++) {// 注意 是从1开始
            int val = preorder[i];
            insert(root, val);
        }
        return root;
    }

    private TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            root.left = insert(root.left,val);
        }
        if (val > root.val) {
            root.right = insert(root.right,val);
        }
        return root;
    }
}
