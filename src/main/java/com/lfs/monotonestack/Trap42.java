package com.lfs.monotonestack;

import java.util.Deque;
import java.util.LinkedList;

/*
    接雨水
 */
public class Trap42 {
    public int trap(int[] height) {
        /*
            当前元素小于栈顶元素直接压入栈
            当前元素等于栈顶元素 弹出栈顶元素压入当前元素() 就是删除一个相同的元素
            当前元素大于栈顶元素 (这是一个持续的过程要用while) 当大于时才会产生凹槽 才能保留雨水
                弹出并获取栈顶元素(因为我们还要获取栈顶元素的下个元素,所以我们需要弹出栈顶元素才能获取到) mid
                获取左柱高度(此时的左柱就是当前栈顶元素)，我们要 求左柱与右柱(当前元素)的最小值
                    用最小值 减去 中间柱子的高度(mid) 就是 凹槽的高度(h)
                求宽: 用右柱 减去 中间柱子 - 1 可得: 当前元素索引 - 第一次弹出元素(mid)索引 - 1
            此时我们可以求得凹槽的面积

                当前元素: 右柱    i
                第一次弹出并获取的元素: 中间柱 stack.pop()
                弹出后获取的栈顶元素: 左柱  stack.peek()

                像 i stack.pop() stack.peek() 都是索引 (宽)
                要想求高 或 判断高度大小 别忘了 加 height[]

         */
        int len = height.length;
        if (len <= 2) return 0;
       
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);

        int sum = 0;
        for (int index = 1; index < len; index++) {
            if (height[index] < height[stack.peek()]) {
                stack.push(index);
            } else if (height[index] == height[stack.peek()]) {
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop();
                stack.push(index);
            } else {
                while (!stack.isEmpty() && (height[index] > height[stack.peek()])) {
                    int mid = stack.pop();//在判空前写,在判空内写 判空就没有意义了
                    if (!stack.isEmpty()) {
                        int left = stack.peek();//左柱 当前元素是右柱
                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) sum += hold;
                    }
                }
                stack.push(index);// 不满足条件时一样要压入栈
            }
        }
        return sum;
    }
}
