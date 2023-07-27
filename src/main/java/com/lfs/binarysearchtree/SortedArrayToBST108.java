package com.lfs.binarysearchtree;

/*
    将有序数组转为二叉搜索树
    构造一颗平衡二叉搜索树,为什么平衡?
    因为任何一个有序数组都可以构造一个链式的二叉搜索树
 */
public class SortedArrayToBST108 {
    /*
        找根节点,中间位置的节点,才能保证他平衡(两边分布)
        奇数取中间,偶数的话中间有两个中间值,都可以取
        左闭右闭
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums, 0, nums.length - 1);
        return root;
    }

    // 左闭右闭区间[left, right]
    private TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = traversal(nums, left, mid - 1);
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
