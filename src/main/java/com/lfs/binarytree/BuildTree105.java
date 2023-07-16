package com.lfs.binarytree;

import java.util.HashMap;
import java.util.Map;

/*
    从前序与中序遍历序列构造二叉树
 */
public class BuildTree105 {
    /*
    前提:节点值不会重复
    根据前 中 序遍历才能还原，只单单根据前或中序不能还原

    根据前序可知 root = 1,
    根据中序与前序可知 root = 1 前面的元素是左子树部分，后面的是右子树,
    重复操作:
    根据前序可知 root = 2, 3
    根据中序与前序可知 root = 2 前面的元素4是左子树部分，后面没有右子树,
    根据中序与前序可知 root = 3 前面的元素6是左子树部分，后面7是右子树,
       preOrder = {1,2,4,3,6,7}
       inOrder = {4,2,1,6,3,7}

       根 1
           前          中
           pre         in
       左  2,4         4,2
       右  3,6,7       6,3,7


       根 2
       左 4

       根 3
       左 6
       右 7
*/
    int rootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(map, 0, preorder.length - 1, preorder);
    }

    public TreeNode buildTree(Map<Integer, Integer> map, int left, int right, int[] preorder) {
        if (left > right) return null;

        int rootVal = preorder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        rootIndex++;
        root.left = buildTree(map, left, map.get(rootVal) - 1, preorder);
        root.right = buildTree(map, map.get(rootVal) + 1, right, preorder);
        return root;
    }
    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 3, 6, 7};
        int[] inOrder = {4, 2, 1, 6, 3, 7};
        TreeNode root = new BuildTree105().buildTree(preOrder, inOrder);
        System.out.println(root);
    }
    /*
            int[] preOrder = {1, 2, 4, 3, 6, 7};
            int[] inOrder = {4, 2, 1, 6, 3, 7};
     */
}
