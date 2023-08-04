package com.lfs.greedy;

class test {
    public int largestSumAfterKNegations(int[] nums, int k) {

        int min = -101;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
            min = Math.min(min, nums[i]);
            sum += nums[i];
        }
        if (k % 2 != 0) {
            sum -= 2 * min;
        }
        return sum;
    }
}

