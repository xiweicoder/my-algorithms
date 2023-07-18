package com.lfs.binarytree;

import java.util.HashMap;
import java.util.Map;

/*
    从后序与中序遍历序列构造二叉树
 */
public class BuildTree106 {

    /*
        采用map优化的代码起始本质上还是一样的,有些简化操作,但是逻辑都一样,只是不用拿着后序的末尾节点，去中序找值
        构建节点时,注意注意注意!! 因为采用的是map存储中序序列,我们get到的是索引,而构建节点,需要拿着索引去中序序列拿到对应的值
     */
    Map<Integer, Integer> map;  // 方便根据数值查找位置
    // 方法一: 采用map优化中序序列
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode(inorder, 0, inorder.length, postorder, 0, postorder.length);  // 前闭后开
    }

    public TreeNode findNode(int[] inorder, int inBegin, int inEnd, int[] postorder, int postBegin, int postEnd) {
        // 参数里的范围都是前闭后开
        if (inBegin >= inEnd || postBegin >= postEnd) {  // 不满足左闭右开，说明没有元素，返回空树
            return null;
        }
        int rootIndex = map.get(postorder[postEnd - 1]);  // 找到后序遍历的最后一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点***
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定后序数列的个数(中序左区间长度)  后序左区间长度 = 后序左区间起始位置 + 中序左区间长度

        root.left = findNode(inorder, inBegin, rootIndex,
                postorder, postBegin, postBegin + lenOfLeft);//后序左区间长度 = 后序左区间起始位置 + 中序左区间长度

        root.right = findNode(inorder, rootIndex + 1, inEnd,
                postorder, postBegin + lenOfLeft, postEnd - 1);

        return root;
    }

    /*
        在这道题中因为会涉及到切分,边界问题就很重要, 这这道题严格按照左闭右开进行(包括左不包括右)
        因为左闭右开,我们一开始调用递归函数buildHelper,传入的值:
            inorder: 中序序列   {9, 3, 15, 20, 7};
            inorderStart: 中序开始位置    0
            inorderEnd: 中序结束位置  中序序列的长度,(因为不包括右,所以是长度,永远达不到)
            后序序列同理

        拿到后序序列中的最后一个元素(根节点),去中序序列中去查找所在位置,然后进行切分:
            划分区间:
            中序:
            leftInorderStart: 0
            leftInorderEnd: 1 不包括1
            rightInorderStart: 1+1 (始终不包括1,因为1是根节点不能包含)
            rightInorderEnd: inorderEnd 上面提到过了中序结束位置 不包括

            后序:
            leftPostorderStart: 0
            leftPostorderEnd: 我们并不知道在后序中怎么切,但我们知道了中序要切多少,那么在后序中也要切相等的数量
                后序起点 + (中序结束位置 - 中序开始位置)    中序结束位置 - 中序开始位置是 切分元素的长度,加上后序起点就是左后序的末尾 (并不包括)
            rightPostorderStart: leftPostorderEnd
            rightPostorderEnd:  postorderEnd - 1    后序序列长度 -1  (不包括) 不能包括后序最后一个元素, 因为后序最后一个元素是根节点
 */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0)
            return null;
        return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);

    }

    private TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if (postorderStart == postorderEnd) return null;

        int rootVal = postorder[postorderEnd - 1];// 中间节点位置 root
        TreeNode root = new TreeNode(rootVal);// 创建出一个root节点

        // 在中序中找到与后序中的root 索引位置 (用来区分左子树,右子树)
        int middleIndex;
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++) {
            if (inorder[middleIndex] == rootVal)
                break;
        }

        // 划分区间 左闭右开区间 不包含middleIndex,因为他是根节点
        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;// 结束位置 是下一次for循环条件 <的 , 是不可能取到的
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;


        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = postorderStart + (middleIndex - inorderStart);
        int rightPostorderStart = leftPostorderEnd;
        int rightPostorderEnd = postorderEnd - 1;
        root.left = buildHelper(inorder, leftInorderStart, leftInorderEnd, postorder, leftPostorderStart, leftPostorderEnd);
        root.right = buildHelper(inorder, rightInorderStart, rightInorderEnd, postorder, rightPostorderStart, rightPostorderEnd);

        return root;
    }

    public static void main(String[] args) {
        int[] postOrder = {9, 15, 7, 20, 3};
        int[] inOrder = {9, 3, 15, 20, 7};
        TreeNode root = new BuildTree106().buildTree(inOrder, postOrder);
        System.out.println(root);

    }
}
