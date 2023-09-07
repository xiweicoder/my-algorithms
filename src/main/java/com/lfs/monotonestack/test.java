package com.lfs.monotonestack;

import java.util.Deque;
import java.util.LinkedList;

public class test {
    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        for (int i = 1; i < len; i++) {
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            } else if (height[i] == height[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int h = Math.min(height[stack.peek()], height[i]) - height[mid];
                        int w = i - stack.peek() - 1;
                        int res = h * w;
                        sum += res;
                    }

                }
                stack.push(i);
            }
        }
        return sum;
    }
}
