package com.lfs.linkedlist;

/*
    合并多个升序链表
    分治法 (分 治 合)
    基于21
 */
public class MergeKLists23 {

    /*
        将一个链表切分，不断切分，切到数组中只有一个链表就不切分
        再切分时 分为左右两个链表，当左右都只有一个链表时进行两个有序链表的合并
        并返回到上一层与 r 或 l 再次进行合并 ...
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return split(lists, 0, lists.length - 1);
    }

    // 返回合并后的链表 i,j代表左右边界
    private ListNode split(ListNode[] lists, int i, int j) {
        if (i == j) return lists[i]; // 数组内只有一个链表时，就不用切分了
        int m = (i + j) >> 1;
        ListNode left = split(lists, i, m);// 左侧
        ListNode right = split(lists, m + 1, j);// 右侧
        return mergeTwoLists(left, right);
    }

    //合并两个链表
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
        if (p2 != null) {
            p.next = p2;
        }
        if (p1 != null) {
            p.next = p1;
        }
        return s.next;
    }
}
