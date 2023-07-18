package com.lfs.binarytree;

/*
    最大二叉树
    106 同类型
 */
public class ConstructMaximumBinaryTree654 {
    /*
        最大值用来创建接地那
        最大索引切分数组
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex - leftIndex < 1) {// 没有元素了
            return null;
        }
        if (rightIndex - leftIndex == 1) {// 只有一个元素
            return new TreeNode(nums[leftIndex]);
        }
        /*
            maxIndex,maxVal 这两个的顺序不能变,maxVal要依赖maxIndex
            maxIndex:  最大索引 = 左边界, 在循环判断时,从左边界开始,不遗漏任何一个元素
            maxVal: 必须要依赖maxIndex,若给个最小值,给写死了, 但要是本来是个null,找不到,就错了
         */
        int maxIndex = leftIndex;// 最大值所在位置
        int maxVal = nums[maxIndex];// 最大值

        /*
             +1并不影响找最大索引,因为我们排除了左边只有一个元素的情况,那我们可以少遍历一次
             都要用递归传过来的值,因为有左右子树的存在,是不同的,是变化的,不能写死
             leftIndex: 左边界,可能是左树的左边界,但也可能是右树的左边界 maxIndex + 1
             rightIndex 同理
         */
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        // 根据maxIndex划分左右子树
        root.left = constructMaximumBinaryTree1(nums, leftIndex, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, rightIndex);
        return root;
    }

    public static void main(String[] args) {
        int[] s = {3, 2, 1, 6, 0, 5};

        TreeNode g = new ConstructMaximumBinaryTree654().constructMaximumBinaryTree(s);
        System.out.println(g);
    }
}
