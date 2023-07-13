package com.lfs.queue;

import java.util.LinkedList;
import java.util.Queue;

/*
    用队列实现栈
 */
public class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    // 将x压入栈顶
    public void push(int x) {
        queue.add(x);
    }

    // 弹出栈顶元素
    public int pop() {
        rePosition();// 将最后一个元素放在第一个位置
        return queue.poll();
    }

    // 返回栈顶元素
    /*
        不同在不删除,反而要麻烦,拿到要弹出的元素,在展示完后重新再压入栈顶(push)
     */
    public int top() {
        rePosition();
        int result = queue.poll();
        queue.add(result);
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    /*
      队列: out   1 2 3    in <-先进先出
      弹出栈的第一个元素:    栈是先进后出 应该将3弹出
      现将length -1 个元素 弹出重新加入队列,剩下的就是栈的第一个(队列的最后一个元素)
      3 1 2  pop(弹出) 3  -> 1 2

        将size-1个元素弹出来重新加入队列
     */
    public void rePosition() {
        int size = queue.size();
        size--;// 减一保证是size-1个元素
        while (size-- > 0) {// 别忘了-1
            queue.add(queue.poll());

        }
    }

}
