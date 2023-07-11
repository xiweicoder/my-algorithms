package com.lfs.hashtable;

import java.util.HashSet;
import java.util.Set;

/*
    判断快乐数
 */
public class IsHappy202 {
    /*
        根据我们的探索，我们猜测会有以下三种可能。
        1.最终会得到 1。 7
        2.最终会进入循环。 116
        3.值会越来越大，最后接近无穷大。  不会发生,每次都会变小一位数
        也就是说输入一个n会有两种情况发生:  n=1 或  n进入死循环

        思路:
        先将n放入set中, 当n(每位的平方和) != 1 并且 在set中不存在时进入循环,
        只要发现新计算返回的n在set不存在就放到set中
        只要n =1 或 n进入死循环 就返回 true 或 false

     */
    public boolean isHappy(int n) {
        Set<Integer> record = new HashSet<>();
        while (n != 1 && !record.contains(n)) {// set中不包含n进行循环(n没有在死循环)
            record.add(n);
            n = getNextNumber(n);
        }
        return n == 1;
    }

    // 用来辅助计算 每位的平方和 计算111
    private int getNextNumber(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;// 取余求个位数 111
            res = temp * temp + res;//
            n = n / 10;// 求个位数之前的数
        }
        return res;
    }
}
