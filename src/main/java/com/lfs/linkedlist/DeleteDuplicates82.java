package com.lfs.linkedlist;

/*
    删除重复元素
    有重复的全删除，重复元素一个不保留  [1123] -> [23]
    链表练习中采用了完全不简写的情况 **
 */
public class DeleteDuplicates82 {

    /*
        p1 是待删除的上一个节点，每次循环对比 p2、p3 的值
        * 如果 p2 与 p3 的值重复，那么 p3 继续后移，直到找到与 p2 不重复的节点，p1 指向 p3 完成删除
        * 如果 p2 与 p3 的值不重复，p1，p2，p3 向后平移一位，继续上面的操作
        * p2 或 p3 为 null 退出循环
        * p2 为 null 的情况，比如链表为 1 1 1 null
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2;
        ListNode p3;

        /*
            定义3个指针 p1 指向哨兵，p2指向第一个元素，p3指向第二个元素
            思路: 进入循环比较p2和p3的值，若相等，p3向后移动一位,移动之后然后多次判断p3和p2的值是否相等,只要相等p3就移动，
            多次判断(while) 完后即找到了不重复的值 然后删除p1 和 p3 之间相同的值
            若最终 p3 p2 值不相等
         */

        while ((p2 = p1.next) != null && (p3 = p2.next) != null) {
            if (p2.val == p3.val) {
                p3 = p3.next;
                while (p3 != null && p3.val == p2.val) {
                    p3 = p3.next;
                }
                // 找到了不重复的值 删除操作
                p1.next = p3;
            } else { // 值不相同  p1,p2,p3都向后移动
                p1 = p1.next;
            }

        }
        return s.next;
        //全都不抽取出来的情况
/*        while (p2 != null && p3 != null) {
            if (p2.val == p3.val) {
                p3 = p3.next;
                while (p3 != null && p3.val == p2.val) {
                    p3 = p3.next;
                }
                // 找到了不重复的值 删除操作
                p1.next = p3;
            } else { // 值不相同  p1,p2,p3都向后移动
                p1 = p1.next;
            }
            p2 = p1.next;

            *//*
                 注意** 维护指针时 p2有可能为null要判断否则空指针
                  s   1    1   1   null
                  p1  p2            p3
                  删除后:
                  s null
                  p1  p2    p3   此时p2为null一定要判空
             *//*
            if (p2 != null) {
                p3 = p2.next;
            }
        }*/
    }
}
