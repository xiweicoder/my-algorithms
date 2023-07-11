package com.lfs.linkedlist;

/*
    删除有序链表的重复节点
    重复元素保留一个
 */
public class DeleteDuplicates83 {

    //双指针
    //p1 p2分别指向链表前两个元素，比较p1 p2的值，若相等删除p2,若不等都向后平移一位，直到p2=null
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2;
        while ((p2 = p1.next) != null) { // p2 = p1.next 这行代码使用了3处地方，现在抽取到循坏条件处，具体可见203
            if (p1.val == p2.val) {
                // 删除p2
                p1.next = p2.next;
            } else {
                // 向后平移一位
                p1 = p1.next;
            }
        }
        return head;
    }
}
