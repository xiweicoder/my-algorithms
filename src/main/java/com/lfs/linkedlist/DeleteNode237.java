package com.lfs.linkedlist;

/*
    删除链表中的一个节点
 */
public class DeleteNode237 {
    /*
       1 2 3 4    3
       1 2 4 4 复制下一个节点的值
       1 2 4    删除下一个节点
       node复制下一个节点的值，然后删除下一个节点,即将自己删除
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val; // 复制值
        node.next = node.next.next;// 删除node
    }
}
