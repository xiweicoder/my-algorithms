package com.lfs.exercise.linkedlist;

/*
    链表练习
 */
public class LinkedListExercise {

    // 82 注意最前面判空条件不能少,最后的p2也要判断null,中间的p3也要判断null
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode s = new ListNode(-1);
        ListNode p1 = s;
        p1.next = head;

        ListNode p2 = p1.next;
        ListNode p3 = p2.next;

        while (p2 != null && p3 != null) {
            if (p2.val == p3.val) {
                p3 = p3.next;
                while (p3 != null && p3.val == p2.val) {
                    p3 = p3.next;
                }
                p1.next = p3;
            } else {
                p1 = p1.next;
            }
            p2 = p1.next;
            if (p2 != null) {
                p3 = p2.next;
            }
        }
        return s.next;
    }

    // 83 注意 因为此题与82题题目相同冲突,因此83题少个字母s  注意此题最前面也要判head是否null
    public ListNode deleteDuplicate(ListNode head) {
        if (head == null) return head;
        ListNode p1 = head;
        ListNode p2 = p1.next;

        while (p1 != null && p2 != null) {
            if (p1.val == p2.val) {
                p1.next = p2.next;
                p2 = p1.next;
            } else {
                p1 = p1.next;
                p2 = p1.next;
            }
        }
        return head;
    }

    // 237 技巧性较强的一题  如何让自己在世界上消失，但又不死？ —— 将自己完全变成另一个人，再杀了那个人就行了
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    // 142 1.不能用哨兵 2.while循环条件 3.在判断是环后还要进行循环 4.在进行最后的循环时先判断是否相等,再一步一步走
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p2 = head;
                while (true) {
                    if (p1 == p2) {
                        return p1;
                    }
                    p1 = p1.next;
                    p2 = p2.next;
                }
            }
        }
        return null;
    }

    // 160 注意: 1.p1 = headB;赋值的时候一定是原来的节点,因为p1 p2 已经变化了 2.在判断不为null的时候才走下一步 3.另一种解法注意一下
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (true) {
            if (p1 == p2) {
                return p1;
            }
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
    }

    // 141 142的下位替代
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p2 == p1) {
                return true;
            }
        }
        return false;
    }

    // 234 用到了 876 206 这2个题  注意: 遍历判断是否相等时 倒着判断提前返回 先false 遍历结束即为true
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode newList = reverseList(mid);
        while (newList != null) {
            if (newList.val != head.val) {
                return false;
            }
            newList = newList.next;
            head = head.next;
        }
        return true;
    }

    // 876 找中间节点 注意 找中间点p2 p2.next都要判断
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2 != null && p2.next != null) {

            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }

    // 206 反转链表
    public ListNode reverseList(ListNode o1) {
        ListNode n1 = null;
        while (o1 != null) {
            ListNode o2 = o1.next;
            o1.next = n1;
            n1 = o1;
            o1 = o2;
        }
        return n1;
    }

    // **21**  1.p是很重要的一个变量,p是一个随时变动的数
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
        if (p1 == null) {
            p.next = p2;
        }
        if (p2 == null) {
            p.next = p1;
        }
        return s.next;
    }

    // 203 哨兵不能为null
    public ListNode removeElements(ListNode head, int val) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = p1.next;

        while (p2 != null) {
            if (p2.val == val) {
                p1.next = p2.next;
                p2 = p1.next;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return s.next;
    }

    // 19 注意p2要走多少步才方便删除操作
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*          p2
              p1
          s 1 2 3 4

         */
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;
        for (int i = 0; i < n + 1; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return s.next;

    }

    // **24**
    public ListNode swapPairs(ListNode head) {
        ListNode s = new ListNode(-1, head);

        ListNode cur = s;
        ListNode p1;
        ListNode p2;
        while (cur.next != null && cur.next.next != null) {
            // 赋值操作一定要在while中进行,起始也是在维护节点, cur变动了,p1 p2 紧随其后  cur ->p1->p2,维持好阵型
            p1 = cur.next;
            p2 = p1.next;

            cur.next = p2;
            p1.next = p2.next;
            p2.next = p1;
            cur = p1;

        }
        return s.next;

    }
}
