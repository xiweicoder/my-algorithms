package com.lfs.dp;

/*
    718. 最长重复子数组
 */
public class FindLength718 {
    /*
      二维矩阵实现
      1.状态定义:
          dp[i][j]: 以i-1为结尾的nums1，以j-1为结尾的nums2的 最长重复子数组
      2.递推公式:
          dp[i][j] = dp[i - 1][j - 1] + 1;

      3.初始化:
        dp[i][0] = 0 ;  dp[0][j]  = 0; 二维数组的第一行第一列都应该为0,因为i-1 j-1 的存在,本身他们两个没有意义
        其他的元素初始化多少都可以

      4.遍历顺序
        两层for循环先遍历谁都可以、

        nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]

        [1,1] [1,2] [1,3] [1,4] [1,5]
        [2,1] [2,2] [2,3] [2,4] [2,5]
        [3,1] [3,2] [3,3] [3,4] [3,5]
        [4,1] [4,2] [4,3] [4,4] [4,5]
        [5,1] [5,2] [5,3] [5,4] [5,5]

        nums1[2] == nums[0]

   */
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        System.out.println(dp.length);

        /*
            因为我们dp数组的含义是 i-1 j-1 假设长度为8 只有等于8时,所以才能到达7 满足i-1 j-1
            从0开始，从1开始都可以
            从1开始因为我们规定是i-1 j-1 所以我们需要达到nums.length 才能获取到 数组最后一位索引 dp[i][j]
            dp[1][1] = dp[0][0]+1
         */
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 2, 1};
        int[] b = new int[]{3, 2, 1, 4, 7};


        int s = new FindLength718().findLength(a, b);
        System.out.println(s);
    }
}
