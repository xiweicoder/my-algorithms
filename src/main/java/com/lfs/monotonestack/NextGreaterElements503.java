package com.lfs.monotonestack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
    503. 下一个更大元素 II
    环形 i就取模,取模的方式索引就回来了
 */
public class NextGreaterElements503 {
    /*
        本题与每日温度几乎没有区别
        len = 3
        len*2 = 6 模拟环
        i = 1 2 3   %3 = 原本的数值
        i = 4 % 3 = 1   当i = 4时回到索引1处

     */
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len];
        Arrays.fill(res, -1);

        stack.push(0);
        for (int i = 1; i < len * 2; i++) {
            while (!stack.isEmpty() && nums[i % len] > nums[stack.peek()]) {
                res[stack.peek()] = nums[i % len];
                stack.pop();
            }
            stack.push(i % len);
        }
        return res;
    }
}
