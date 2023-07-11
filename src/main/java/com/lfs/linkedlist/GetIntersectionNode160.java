package com.lfs.linkedlist;

/*
    链表相交 160或 面试题02.07
 */
public class GetIntersectionNode160 {
    public static void main(String[] args) {
        ListNode p1 = ListNode.of(1, 2, 6, 3, 6);
        ListNode p2 = ListNode.of(5, 8, 4, 7);
        ListNode intersectionNode = new GetIntersectionNode160().getIntersectionNode(p1, p2);
        System.out.println(intersectionNode);
    }

    /*
        headA: 1,2,3,4,5
        headB: 0,3,4,5
        相交于3 (若存在相交点，则后缀必定相同，即后缀必定均为3,4,5)  c=3,4,5

        循环过程：
        curA: 1,  2,  3,  4,  5,  null,  0,  3 退出循环
        curB: 0,  3,  4,  5, null,  1,   2,  3 退出循环

        无论是A+B 还是B+A 他们两个相加长度肯定相等,只要他们共尾就会有相等的时候
        (a+c) + (b+c) = (b+c) + (a+c), 其中a,b分别是非共享部分长度,c是共享长度 最后部分一定是+c,所以一定能找到共尾的起始部分
     */
    // 方法1
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode p1 = a;
        ListNode p2 = b;
        while (true) {// 没有返回null 但能返回一个null, 因为他们两个加起来长度一样,最后只有一个节点p1.next == p2.next都等于null,正好满足了p1 == p2 返回了null
            if (p1 == p2) {
                return p1;
            }
            if (p1 == null) {
                p1 = b;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = a;
            } else {
                p2 = p2.next;
            }
        }
    }

    /*方法2
        求两个链表之间的差值，然后令长的一方指针向后移动，移动到与另一方长度一样时 判断是否相等 不相等 双方同时移动

                ↓
                1   2   3   4   5
        ↓
        1   2   3   4   5   6   7

                ↓
                1   2   3   4   5
                ↓
        1   2   3   4   5   6   7

        此时判断是否指针指向节点是否相等,不相等双方指针都向后移动
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        while (curA != null) { // 求链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) { // 求链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

}
