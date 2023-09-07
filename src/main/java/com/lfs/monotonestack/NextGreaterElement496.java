package com.lfs.monotonestack;

import java.util.*;

/*
    下一个更大元素
 */
public class NextGreaterElement496 {
    /*
        输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
        输出：[-1,3,-1]
        nums1是nums2的子集，4在nums2右边没有比4大的元素 返回 -1
        1 在nums2中，比1大的元素是3 返回 3
        2 同理    返回 -1

        map: [(4,0)(1,1)(2,2)]

        stack: 0
        3 > 1 Map包含1,拿到nums1的1的索引1，在结果的该索引处赋值为当前在nums2的值
        弹出处理完的0 压入 1

        stack: 1

        大体思路:
            map作好与nums1的映射关系,先压入索引0,避免空栈，然后判断nums2[0] 与nums2[1]的大小关系,发现nums2[1]更大，大于栈顶元素1，
            因为nums1是nums2的子集，我们在nums2中一个数比另一个数更大，我们看看在nums1中存不存在栈顶元素(相比后 小的数)，因为我们可能找到一个
            nums2中比nums1元素大的数(比栈顶元素大的数)
            存在则用结果存下相比来说大的数 弹栈压栈;
            不存在则直接弹栈压栈

     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            hashMap.put(nums1[i], i);
        }
        stack.add(0);
        for (int i = 1; i < nums2.length; i++) {
            if (nums2[i] <= nums2[stack.peek()]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                    if (hashMap.containsKey(nums2[stack.peek()])) {
                        Integer index = hashMap.get(nums2[stack.peek()]);//找到nums1出对应的索引
                        res[index] = nums2[i];//将当前大的数放入对应索引处
                    }
                    stack.pop();
                }
                stack.add(i);
            }
        }

        return res;
    }
}
