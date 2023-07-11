package com.lfs.linkedlist;

/*
    判断是否是回文链表
    第一种方法执行效率不高
 */
public class IsPalindrome234_2 {

    /*
      步骤1. 找中间点的同时反转前半个链表
      步骤2. 反转后的前半个链表 与 中间点开始的后半个链表 逐一比较
              p1      p2
      1   2   2   1   null

      n1
      2   1

    思路: 合并找中间节点与反转链表，让这两个步骤在一个循环中实现
        找中间点:p2走两步,p1走一步,走完p1即中间点，这时我们直接反转中点前的链表,拿着前半段链表n1与后半段链表o1比较
   */
    public boolean isPalindrome(ListNode head) {
        ListNode p1 = head; // 慢
        ListNode p2 = head; // 快
        ListNode n1 = null; // 新头
        ListNode o1 = head; // 旧头
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            // 反转链表
            o1.next = n1;
            n1 = o1;
            o1 = p1; // 这里本来是用o2更新o1,  o2 = o1.next; p1也等于o1.next  所以合在一起写了
        }
        System.out.println(n1);
        System.out.println(p1);

        /*
        问题出现在 p2 !=null p2.next != null 上   :
            p1   p2
        1 2 2 1 null    遍历完，p1落在第二个2节点上 反转链表: 2 1    原始链表变成: 2 1 null  偶数是相等的

            p1  p2
        1 2 3 2 1 null  遍历结束  反转链表: 2 1     原始链表: 3 2 1 null    奇数时不相等

        针对这种情况 我们 当奇数链表即 p2 != null 时 让原始链表再后移一位 这时就相等了
         */
        if (p2 != null) { // 奇数节点
            p1 = p1.next;
        }

        //比较是否相等
        while (n1 != null) {
            if (n1.val != p1.val) {
                return false;
            }
            n1 = n1.next;
            p1 = p1.next;
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new IsPalindrome234_2()
//                .isPalindrome(ListNode.of(1, 2, 2, 1)));
        System.out.println(new IsPalindrome234_2()
                .isPalindrome(ListNode.of(1, 2, 3, 2, 1)));
    }
}
