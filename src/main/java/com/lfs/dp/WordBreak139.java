package com.lfs.dp;

import java.util.HashSet;
import java.util.List;

/*
    单词拆分
 */
public class WordBreak139 {
    /*
        wordDict集合是物品
        s 是背包
        s = "leetcode", wordDict = ["leet", "code"]
        看wordDict能否组成s
        完全背包问题

        1.状态定义:dp[j] 字符串的长度为j; 字符串长度为j能被字典中的单词组成dp[j]=true
        2.递推公式:
             ...   j    i
            如果j之前的字符串能被字典单词组成 并且 j-i也能被单词组成则:
            dp[i] = true


        3.初始化: dp[0] = true 非零dp = false (防止影响其他值最小操作)


        4.装满背包对物品的顺序是有要求的，排列    [1,5][5,1]不是一个东西
            先背包再物品
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        //substring 从1开始 l 这个单词
        for (int i = 1; i <= s.length(); i++) {//背包
            for (int j = 0; j < i && !dp[i]; j++) {//物品   !dp[i]:之前匹配过的单词 直接跳过 j<i 单词不能指向同一个字母，同一个字母没法切分单词范围
                if (set.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
