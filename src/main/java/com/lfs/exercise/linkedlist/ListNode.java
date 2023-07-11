package com.lfs.exercise.linkedlist;

public class ListNode {
     ListNode next;
     int val;

    public ListNode( int val,ListNode next) {
        this.next = next;
        this.val = val;
    }

    public ListNode() {
    }

    public ListNode(ListNode next) {
        this.next = next;
    }

    public ListNode(int val) {
        this.val = val;
    }
}
