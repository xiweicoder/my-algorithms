package com.lfs.monotonestack;

import java.util.Deque;
import java.util.LinkedList;

public class test {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new LinkedList<>();
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[heights.length - 1] = 0;
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        heights = newHeights;
        stack.push(0);

        int res = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[stack.peek()]) {
                stack.push(i);
            } else if (heights[i] == heights[stack.peek()]) {
                stack.pop();
                stack.push(i);
            } else {
                while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                    int mid = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int right = i;
                        int h = heights[mid];
                        int w = right - left - 1;
                        res = Math.max(res, w * h);
                    }
                }
                stack.push(i);
            }
        }
        return res;
    }
}
