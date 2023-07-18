package com.lfs.binarytree;

public class test {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums, 0, nums.length);
    }

    private TreeNode constructMaximumBinaryTree1(int[] nums, int left, int right) {
        if (right - left < 1) return null;

        if (right - left == 1) {
            return new TreeNode(nums[left]);
        }

        int maxIndex = left;
        int max = nums[maxIndex];
        for (int i = left; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);

        root.left = constructMaximumBinaryTree1(nums, left, maxIndex);
        root.right = constructMaximumBinaryTree1(nums, maxIndex + 1, right);
        return root;
    }

}
