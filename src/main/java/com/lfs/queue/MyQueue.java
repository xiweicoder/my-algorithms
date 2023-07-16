package com.lfs.queue;

import java.util.Stack;

/*
    用栈实现队列 232
    用两个栈实现队列,入栈直接放入stackIn，
    出栈时,先将stackIn元素全都放入stackOut(dumpStackIn),再正常弹出元素
 */
public class MyQueue {
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stackIn = new Stack<>(); // 负责进栈
        stackOut = new Stack<>(); // 负责出栈
    }

    /**
     * 加入队列
     * 正常加入
     */
    public void push(int x) {
        stackIn.push(x);
    }

    /**
     * 从队列的开头移除并返回元素
     */
    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }

    /**
     * 返回队列开头的元素
     */
    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    /**
     * 如果队列为空，返回 true ；否则，返回 false
     */
    public boolean empty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }

    // 如果stackOut为空，那么将stackIn中的元素全部放到stackOut中
    private void dumpStackIn() {
        if (!stackOut.isEmpty()) return;// 只有stackOut中没有元素时才能再放入元素
        while (!stackIn.isEmpty()) {// 注意这里是while
            stackOut.push(stackIn.pop());
        }
    }
}
