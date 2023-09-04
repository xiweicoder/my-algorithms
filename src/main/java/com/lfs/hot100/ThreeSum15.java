package com.lfs.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    三数之和
 */
public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) continue;

            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));//创建一个新数组,把3个数放进去,将结果添加到result中

                    while (left < right && nums[right - 1] == nums[right]) right--;
                    while (left < right && nums[left + 1] == nums[left]) left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
