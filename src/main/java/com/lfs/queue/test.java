package com.lfs.queue;

import java.util.LinkedList;

public class test {
    LinkedList<Integer> queue;

    public test() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        rePosition();
        return queue.poll();
    }

    public int top() {
        rePosition();
        Integer n = queue.poll();
        queue.add(n);

        return n;

    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void rePosition() {
        int size = queue.size();
        size--;
        while (size > 0) {
            queue.add(queue.pop());
        }
    }
}
