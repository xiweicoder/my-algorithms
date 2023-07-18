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
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) { // 用map保存中序序列的数值对应位置
            map.put(inorder[i], i);
        }

        return findNode(preorder, 0, preorder.length, inorder, 0, inorder.length);  // 前闭后开
    }

    public TreeNode findNode(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        // 参数里的范围都是前闭后开
        if (preBegin == preEnd) return null;
        int rootIndex = map.get(preorder[preBegin]);  // 找到前序遍历的第一个元素在中序遍历中的位置
        TreeNode root = new TreeNode(inorder[rootIndex]);  // 构造结点
        int lenOfLeft = rootIndex - inBegin;  // 保存中序左子树个数，用来确定前序数列的个数

        /*
            参数说明:
            preBegin + 1 : 因为是前序,第一个是根节点,所以在调用函数时要避开根节点的位置
            preBegin + lenOfLeft + 1 : +1还是为了避开根节点,数量要一致上做的妥协(不包括)
                后序左区间长度 = 后序左区间起始位置 + 中序左区间长度

            inBegin:    中序开始位置
            rootIndex:  中序中的根节点所在位置(不包括)
         */
        root.left = findNode(preorder, preBegin + 1, preBegin + lenOfLeft + 1,
                inorder, inBegin, rootIndex);

        /*
            preBegin + lenOfLeft + 1 :右边界起始位置
            preEnd: 有边界终止位置(不包括)

            rootIndex + 1 : 中序右边界起始位置
            inEnd: 中序有边界终止位置

            一轮下来 前序的preBegin    后序的rootIndex 所在索引是根节点,作为边界都不能取到
                不是作为终止位置(左闭右开),就是作为起始位置 +1,避开了根节点

         */
        root.right = findNode(preorder, preBegin + lenOfLeft + 1, preEnd,
                inorder, rootIndex + 1, inEnd);

        return root;
    }

    /*
        与106同理,只是边界不一样,本题是前序 与 中序,前序也有坑
        因为前序第一个节点就是根节点,所以我们要拿到索引为0的根节点然后++,但是在调用递归函数时就不用再++了

        不同之处2：前序的右区间末尾与 106不同,本题根节点在左区间,所以末尾不需要-1
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree(inorder, 0, inorder.length, preorder, 0, preorder.length);

    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] preorder, int pStart, int pEnd) {
        if (pStart == pEnd) return null;

        int rootValue = preorder[pStart++];
        TreeNode node = new TreeNode(rootValue);

        int mid;
        for (mid = 0; mid < inEnd; mid++) {
            if (rootValue == inorder[mid]) break;
        }

        //in
        int leftInStart = inStart;
        int leftInEnd = mid;
        int rightInStart = mid + 1;
        int rightInEnd = inEnd;

        //pre
        int leftPStart = pStart;// 注意此处经过了++已经不不包含根节点了,不需要再+1
        int leftPEnd = leftPStart + (leftInEnd - leftInStart);
        int rightPStart = leftPEnd;
        int rightPEnd = pEnd;

        node.left = buildTree(inorder, leftInStart, leftInEnd, preorder, leftPStart, leftPEnd);
        node.right = buildTree(inorder, rightInStart, rightInEnd, preorder, rightPStart, rightPEnd);
        return node;
    }
}
