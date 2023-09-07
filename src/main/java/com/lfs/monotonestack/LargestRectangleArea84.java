package com.lfs.monotonestack;

import java.util.Stack;

/*
    84. 柱状图中最大的矩形
 */
public class LargestRectangleArea84 {
    /*
        [2,1,5,6,2,3]
        以1为基准 找左边比1小的柱子，找右边比1小的柱子 发现都没有 1*6 = 6;
        以5为基准 找左边比5小的柱子，找到了1,这说明没法向左拓展,同理 向右找 我们没有找到 这说明我们可以向右拓展 5*2 = 10
        第一次弹出元素: 中间柱
        第二次获取元素: 左柱
        当前元素: 右柱
        高: 当前元素的高度
        宽: 右 - 左 - 1
        类图:   右[中 左]


        为什么要在尾部加0:
            假如原数组是[2,4,6,8]时, 加入栈中后: 栈内元素: [8,6,4,2]
            可以发现我们遍历完了也没走处理过程逻辑,因为加入栈后他本身就是单调递减的
            而要走处理逻辑要 当前元素 小于 栈顶元素 (不满足单调递减时)
            所以我们在尾部加0避免出现这种情况 :
            尾部加0后 原数组是[2,4,6,8,0]时, 加入栈中后: 栈内元素: [0,8,6,4,2]
            此时 当前元素0 小于 栈顶元素 8 while一直处理
        为什么要在首部加0:
            假如原数组是[8,6,4,2]时, 加入栈中后: 栈内元素: [8],此时下一个元素为6
            当前元素6 小于 栈顶元素8 直接触发处理逻辑 但是要走逻辑必须要有三个元素,
            此时只有两个元素 就空栈了
            首部加0后 原数组:[0,8,6,4,2],加入栈中后: 栈内元素[8,0]
            遇到6,正好3个元素 可以计算
     */
    public int largestRectangleArea(int[] heights) {
        //使用stack速度会慢,但不会报空栈的警告,使用linkedList会快一些
        Stack<Integer> st = new Stack<>();

        // 数组扩容，在头和尾各加入一个元素
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        //数组拷贝,将原数组元素复制到新数组
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        heights = newHeights;//重新命名

        st.push(0);
        int result = 0;
        // 第一个元素已经入栈，从下标1开始
        for (int i = 1; i < heights.length; i++) {
            // 注意heights[i] 是和heights[st.top()] 比较 ，st.top()是下标
            if (heights[i] > heights[st.peek()]) {
                st.push(i);
            } else if (heights[i] == heights[st.peek()]) {
                st.pop(); // 这个可以加，可以不加，效果一样，思路不同
                st.push(i);
            } else {
                while (heights[i] < heights[st.peek()]) { // 注意是while
                    int mid = st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }
}
