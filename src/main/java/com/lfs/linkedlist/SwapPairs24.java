package com.lfs.linkedlist;

/*
    两两交换链表中的节点
    注意点: cur是一个初始指向哨兵的指针,cur是灵活变动的,我们需要维护的也是cur  cur是非常重要的在这题
    在使用哨兵时别忘记,链接哨兵和所给head节点的关系

 */
public class SwapPairs24 {

    public ListNode swapPairs(ListNode head) {
        /*
           cur
            s    1   2   3   4   5  交换一次后:
                                         cur的指针是关键 cur始终要指向 两个交换节点前一个节点
                   cur
            s   2   1   3   4   5
         */
        ListNode s = new ListNode(-1, head);
        ListNode cur = s;
        ListNode p1;
        ListNode p2;
        while (cur.next != null && cur.next.next != null) {// 一定要是cur.next不然空指针
            // 赋值操作一定要在while中进行,起始也是在维护节点, cur变动了,p1 p2 紧随其后  cur ->p1->p2,维持好阵型
            p1 = cur.next;
            p2 = p1.next;

            /*
                交换操作 顺序不能变
                s(cur)  1   2   3   4   5
                cur -> 2     1 -> 3     2 -> 1    交换并维护好cur后:
                s   2   1(cur)   3   4   5
             */
            cur.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            // 维护cur节点
            cur = p1;
        }
        return s.next;
    }
}

