package com.lfs.linkedlist;

/*
    查找链表的中间节点
 */
public class MiddleNode876 {
    /*
        快慢指针
        慢指针一次走一步，快指针一次走两步，当快指针走到头(快指针=null或下一个节点=null)时，慢指针所在位置就是中间节点
        本题和 19 题类似的思路
     */
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;

        while (p2 != null && p2.next != null) {// 循环条件 p2要在前面，不然可能空指针
            p1 = p1.next;
            p2 = p2.next;
            p2 = p2.next;
        }
        return p1;
    }
}

