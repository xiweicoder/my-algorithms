package com.lfs.linkedlist;

/*
    707

    设计链表
 */
public class MyLinkedList {
    //单链表
    class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    int size;
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(-1); // 哨兵
        head.next = new ListNode(0);
    }

    public int get(int index) {
        ListNode node = findNode(index);
        if (node == null) return -1;
        return node.val;


    }

    public ListNode findNode(int index) {// 链表就没有索引，因为用了哨兵，所以定义i = -1 每次循环+1 记录索引位置
        int i = -1;
        ListNode p = head;
        for (; p.next != null; i++, p = p.next) {
            if (index == i) {
                return p;
            }
        }
        return null;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        ListNode last = findLast();
        last.next = new ListNode(val);
    }

    public ListNode findLast() {
        int i = -1;
        ListNode p;
        for (p = head; p.next != null; i++, p = p.next) {
        }
        return p;
    }

    public void addAtIndex(int index, int val) {// 0 1 2 3  3
        if (index > size) return;
        if (index < 0) index = 0;
        ListNode pred = findNode(index - 1);
//        ListNode curr = findNode(index);
        if (pred.next != null) {
            ListNode curr = new ListNode(val);
            curr.next = pred.next;
            pred.next = curr;
        }
    }

    public void deleteAtIndex(int index) {
        ListNode pred = findNode(index - 1);
        if (pred == null) return;
        if (pred.next == null) return;
        pred.next = pred.next.next;
    }
}
