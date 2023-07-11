package com.lfs.linkedlist;

/*
    合并两个有序列表
 */
public class MergeTwoLists21 {
    /* 方法1
     * 谁小，把谁链给 p，p 和小的都向后平移一位
     * 当 p1、p2 有一个为 null，退出循环，把不为 null 的链给 p
     * 注意:  退出while循环的时机,以及退出循环后该做什么
     */
    public ListNode mergeTwoLists(ListNode p1, ListNode p2) {
        ListNode s = new ListNode(-1, null);
        ListNode p = s;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        // p1 或 p2 有一个为null了
        if (p2 != null) {
            p.next = p2;
        }
        if (p1 != null) {
            p.next = p1;
        }
        return s.next;
    }

    // 方法2 递归 每次比较 返回最小的节点 返回结果作为上一次返回的next
    public ListNode mergeTwoLists2(ListNode p1, ListNode p2) {
        if (p1 == null) { // p1没有元素直接返回p2
            return p2;
        }
        if (p2 == null) {
            return p1;
        }
        if (p1.val < p2.val) {
            p1.next = mergeTwoLists2(p1.next, p2);
            return p1;
        } else {
            p2.next = mergeTwoLists2(p2.next, p1);
            return p2;
        }
    }
}
