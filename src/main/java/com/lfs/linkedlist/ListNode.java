package com.lfs.linkedlist;

/*
    链表的基础结构依赖于此类
    链表的定义，最最基础的，
        值,下一个节点;3个不同的构造方法
 */
public class ListNode {

    // 结点的值
    int val;

    // 下一个结点
    ListNode next;

    // 节点的构造函数(无参)
    public ListNode() {
    }

    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }

    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        sb.append("[");
        ListNode p = this;
        while (p != null) {
            sb.append(p.val);
            if (p.next != null) {
                sb.append(",");
            }
            p = p.next;
        }
        sb.append("]");
        return sb.toString();
//        return String.valueOf(this.val);
    }

    /*
        在创建节点时，一开始p定义为null,尾节点指向为null
        逆序遍历，因为p指向下一个节点，因此会出现:
        6->null
        3->6->null
        ...
        1->2->6->3->6->null

        p = 1->2->6->3->6->null 并返回，出现链状的形式

     */
    // int...   可变参数，function(x,y,z,a,c,s,f): 用来处理这种情况
    public static ListNode of(int... elements) {
        if (elements.length == 0) {
            return null;
        }
        ListNode p = null;
        for (int i = elements.length - 1; i >= 0; i--) {
            p = new ListNode(elements[i], p);
        }
        return p;
    }
}

