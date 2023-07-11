package com.lfs.linkedlist;

/*
    删除链表倒数第n个节点
    并返回头节点
 */
public class RemoveNthFromEnd19 {

    /*
        快慢指针法
        哨兵节点在 -1处，不影响其他节点
        定义两个指针，p1 p2,删除倒数第2个,先让p2走 2+1 步(方便后面删除操作)
        然后p1,p2同时走，走到p2 = null 这时p1.next就是要删除的节点 删除即可

        p1 p2 本身是一样的，但p2先走3步，他们就差3,当p2走到尽头那一刻,p1距离终点null也只差3,(p1此时是倒数第3个元素)我们利用好3   删除2就要拿到他的前一个元素，所以差3

     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);
        ListNode p1 = s;
        ListNode p2 = s;

        /*
         p2该走多少步,要是想p2走完p1正好在被删除点,走n步,但我们是删除节点,为了删除方便让p2多走一步,
         这样p1就在被删除节点的前面,方便删除
         */
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

    /*
        递归方式
        定义: 当遍历完 当前节点为null时返回值为0,每返回一层 +1 :可以得到倒数节点的索引
            删除倒数第二个节点， 当返回值为2时，即我们需要删除的节点  null: 0    倒数第一层:  1    倒数第二层:  2
   recursion(ListNode p=1, int n=2) {
    recursion(ListNode p=2, int n=2) {
    	recursion(ListNode p=3, int n=2) {
    		recursion(ListNode p=4, int n=2) {
    			recursion(ListNode p=5, int n=2) {
    				recursion(ListNode p=null, int n=2) {
    					return 0; // 最内层序号0
					}
                    return 1; // 上一次返回值+1
				}
                return 2;
			}
            if(返回值 == n == 2) {
                // 删除 next
            }
            return 3;
		}
        return 4;
	}
    return 5;
}
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode s = new ListNode(-1, head);// 哨兵作为头 防止漏删除1 多递归一次删除倒数第五个元素
        recursion(s, n);
        return s.next;
    }

    // 1 2 3 4 5 删除4 倒数第二个节点 n = 2
    private int recursion(ListNode p, int n) {
        if (p == null) {
            return 0;
        }
        int nth = recursion(p.next, n); // 下一个节点的倒数位置

        if (nth == n) {
            p.next = p.next.next;
        }
        return nth + 1;
    }
}
