package com.lfs.linkedlist;

/*
    找到环的入口
    阶段1
    * 龟一次走一步，兔子一次走两步
    * 当兔子能走到终点时，不存在环
    * 当兔子能追上龟时，可以判断存在环

    阶段2  依赖于阶段1
    * 从它们第一次相遇开始，龟回到起点，兔子保持原位不变
    * 龟和兔子一次都走一步
    * 当再次相遇时，地点就是环的入口
 */
public class DetectCycle142 {
    public ListNode detectCycle(ListNode head) {
        ListNode h = head; // 兔子
        ListNode t = head; // 乌龟

        while (h != null && h.next != null) { // 因为兔子走两步，为避免空指针多加个判断
            t = t.next;
            h = h.next.next;
            if (t == h) {// 相遇则为环

                // 阶段2
                t = head; // 龟回到起点
                while (true) {

                    /*
                    一定要先判断乌龟和兔子的位置是否相等，再让他们一步一步走, 顺序不能变
                    如果先走再判断,当环是收尾相连时答案就错了
                    先判断 当收尾收尾相连时，乌龟和兔子的位置本来就相等了，就不用后续步骤
                     */
                    if (t == h) {
                        return t;
                    }

                    t = t.next;
                    h = h.next;
                }
            }
        }
        // 不为环
        return null;
    }
}
