package com.lfs.linkedlist;

/*
    反转链表
 */
public class ReverseList206 {


    /*
        方法5  旧链表的头节点移动到新链表的头节点位置  头节点每次不同
        n1: 新的链表，初始为null
        o1: 旧链表头节点      但其实打印o1 是整个链表,但o1.next就单独拿出来了
        o2: 旧链表的第二个节点，下一次循环的的第一个元素 记录的作用
        原始链表: [1,2,3,4,5]
        反转之后[5,4,3,2,1]
        1 -> 2 -> 3 -> 4 -> 5

           n1               o1
        1 -> n1     2 -> 3 -> 4 -> 5
        n1 -> 1     2 -> 3 -> 4 -> 5
            让2成为新的o1,记录新的节点2(3)
        2-> n1 ->1      3 -> 4 -> 5
        n1 -> 2 ->1      3 -> 4 -> 5
            ......


     */
    // 注意:  旧头换新头
    public ListNode reverseList(ListNode o1) {
        if (o1 == null || o1.next == null) {// 空链表或只有一个节点的情况单独拿出来
            return o1;
        }
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next; //记录
            o1.next = n1; // 旧链表的头节点移动到新链表中
            n1 = o1;// 让n1再成为新链表的头节点
            o1 = o2; // 让o1再成为旧链表头部位置
        }
        return n1;
    }

    /* 方法1 不推荐 占用多余的空间
        构造一个新链表，从旧链表依次拿到每个节点，创建新节点添加至新链表头部，完成后新链表即是倒序的
     */
    private ListNode reverseList2(ListNode o1) {
        ListNode n1 = null; // 创建新节点 来容纳旧节点，以及作为节点的下一个节点
        ListNode p = o1; // 拿到旧的整个节点
        while (p != null) {
            /*
            新节点 = 1 -> null
            新节点 = 2 -> 1 -> null
            新节点 = 3 -> 2 -> 1 -> null
            ...

             */
            n1 = new ListNode(p.val, n1);
            p = p.next;
        }
        return n1;

    }

    public ListNode reverseList3(ListNode o1) {
        if (o1 == null || o1.next == null) {
            return o1;
        }
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    public static void main(String[] args) {
        ListNode o1 = ListNode.of(1, 2, 3, 4, 5);
        System.out.println("原始链表: " + o1);
        ListNode listNode = new ReverseList206().reverseList(o1);
        System.out.println("反转之后: " + listNode);
    }

    private ListNode reverseList5(ListNode o1) {
        ListNode n1 = null;
        while (o1 != null) {
            ListNode  o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }
}
