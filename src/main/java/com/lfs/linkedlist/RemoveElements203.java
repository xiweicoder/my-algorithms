package com.lfs.linkedlist;

/*
    移除链表元素
 */
public class RemoveElements203 {

    //方法1 简化代码了 把给p2复制的动作放在了循坏开始处(p2 = p1.next)
    // 哨兵节点
    public ListNode removeElements(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        while ((p2 = p1.next) != null) {
            if (p2.val == val) {
                // 删除, p2 向后平移
                p1.next = p2.next;
            } else {
                // p1 p2 向后平移
                p1 = p1.next;
            }
        }
        return s.next; // 注意返回结果是哨兵之后
    }


    /*
        removeElements的未简化版本
        更详细，更能说明代码的执行过程
        两个节点 p1,p2 p1为哨兵节点
        p1 p2   p1:s(哨兵)  p2:1  p2指向的是真正要删除的节点，每次移动或删除要维护好p2节点
        s  1  2 3 4 5
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = p1.next; // 重复3   将3个重复抽取到while中
        while (p2 != null) {
            if (p2.val == val) {
                // 删除, p2 向后平移
                p1.next = p2.next;
                p2 = p1.next; // 重复1
            } else {
                // p1 p2 向后平移
                p1 = p1.next;
                p2 = p1.next; // 重复2
            }
        }
        return s.next;
    }

    /**
     * 方法2递归
     * 详细看黑马文档
     *
     * @param p   链表头
     * @param val 目标值
     * @return 删除后的链表头
     */
    public ListNode removeElements3(ListNode p, int val) {
        if (p == null) {
            return null;
        }
        if (p.val == val) {// 相等，返回下一个节点的递归结果，自身抛弃
            return removeElements(p.next, val);
        } else {// 不相等，返回自身，但要维护好自身之后的节点
            p.next = removeElements(p.next, val);
            return p;
        }
    }


    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 6, 3, 6);
//        ListNode head = ListNode.of(7, 7, 7, 7);
        System.out.println(head);
        System.out.println(new RemoveElements203()
                .removeElements2(head, 6));
    }
}
