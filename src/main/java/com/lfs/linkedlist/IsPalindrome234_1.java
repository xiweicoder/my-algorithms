package com.lfs.linkedlist;

/*
    判断是否是回文链表
    回文: 正读反读都一样
        1 2 1
        1 2 3 2 1

    此题用到: 反转链表, 找中间点等之前学过的内容 详细看之前几个题
 */
public class IsPalindrome234_1 {

    /*
        找中间点，将中间点后面的节点反转，然后将反转后的链表与原链表前半段比较
        1   2   3   2   1     截取后:  3   2   1
        1   2   3   比较

        步骤1: 找中间点
        步骤2: 中间点后半个链表反转
        步骤3: 反转后链表与原链表逐一比较

     */
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middle(head);// 中间节点以及之后的节点
        ListNode newHead = reverse(mid);// 反转之后的新链表

        // 步骤三: 进行比较
        while (newHead != null) {
            if (newHead.val != head.val) {
                return false;
            }
            newHead = newHead.next;
            head = head.next;
        }
        return true;
    }

    //步骤一:  找中间点
    private ListNode middle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    //步骤二:  反转链表
    private ListNode reverse(ListNode o1) {
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }
}
