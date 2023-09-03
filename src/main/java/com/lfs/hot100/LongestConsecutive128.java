package com.lfs.hot100;

import java.util.HashSet;
import java.util.Set;

/*
    最长连续序列
    map
 */
public class LongestConsecutive128 {
    /*
            set中序列 没有前一位数就是起点 没有最后一位数就是终点
        思路:
            现将nums中的元素都压入set
            遍历set,找到起点 然后我们通过判断set中是否包含+1的数来判断是否是连续的,当不包含时则不连续
            可能有多个连续序列,我们找最长的即可
     */
    public int longestConsecutive(int[] nums) {
        int res = 0;    // 记录最长连续序列的长度
        Set<Integer> set = new HashSet<>();  // 记录所有的数值
        for (int num : nums) {
            set.add(num);    // 将数组中的值加入哈希表中
        }
        int seqLen;     // 连续序列的长度
        for (int num : set) {
            // 如果当前的数是一个连续序列的起点，统计这个连续序列的长度
            if (!set.contains(num - 1)) {//起点开始
                seqLen = 1;//知道是起点 那么长度肯定有1了
                
                // 一定是++num,不能是num++
                while (set.contains(++num)) seqLen++;  // 不断查找连续序列，直到num的下一个数不存在于数组中(就是终点)
                res = Math.max(res, seqLen);    // 更新最长连续序列长度
            }
        }
        return res;
    }
}
