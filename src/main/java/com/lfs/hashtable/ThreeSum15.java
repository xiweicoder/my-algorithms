package com.lfs.hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    三数之和
    详细动画: 见代码随想录
 */
public class ThreeSum15 {
    /*
        难点在于对 a b c 的去重,何时进行去重? 如何去重?
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        // 找出a + b + c = 0
        // a = nums[i], b = nums[left], c = nums[right]
        for (int i = 0; i < nums.length; i++) {
            // 排序之后如果第一个元素已经大于零，那么无论如何组合都不可能凑成三元组，直接返回结果就可以了
            if (nums[i] > 0) {
                continue;
            }

            /*
                对a去重
                为什么这样去重?
                a对标的就是for循环的i每轮循环的的时候不变动,但是排序好的数组中有重复的元素
                例如: [-1,-1,-1,2,2]

                第一轮for循环:           这里将每轮for循环中的多轮while跳过步骤
                 i(a) = -1;  b = -1;   c = 2;

                第二轮for循环:
                i(a) = -1;  b = -1;   c = 2;

                这时我们发现第一轮for循环与第二轮for循环 a的值重复了,若再进行for循环 结果与第一轮一模一样,结果与会一样,这就重复了
                但我们采用当前a与前一位(遍历过的)a进行判断 若一样 直接跳过本轮for循环,完成了对a的去重

             */
            if (i > 0 && nums[i] == nums[i - 1]) {// i>0 后面有i-1，防止索引变成负数
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (right > left) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));//创建一个新数组,把3个数放进去,将结果添加到result中
                    /*
                        找到我们的想要的三元组 这时 对 b c 去重
                        [-1 -1 -1 -1 -1 -1 -1 1 1 1 1 1 1 1] 收割结果后:
                          i  b                            c

                         [-1 -1 -1 -1 -1 -1 -1 1 1 1 1 1 1 1]
                          i      b                       c

                         我们可以发现移动b c后 b c 的值和收割结果时一样,这时我们再去收集结果,结果就会重复,
                         我们通过持续的判断(while)c 和c-- 是否相等   b 和 b++ 是否相等 完成对 b c的去重

                         当然我们去完重拿到结果,b c 还应该移动进行下次的能否作为我们结果集的判断 b++  c--

                     */
                    while (right > left && nums[right] == nums[right - 1]) right--;// 注意 [right - 1] 不能写right--,那会少判断
                    while (right > left && nums[left] == nums[left + 1]) left++;

                    //收集结果后 照常移动
                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
