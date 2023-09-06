package com.lfs.monotonestack;

import java.util.Deque;
import java.util.LinkedList;

/*
    每日温度-单调栈
    放递增 找比他大的数
    放递减 找比他小的数
    单调栈: 存放之前遍历过的元素
        计算完单调栈元素的距离，就没有必要保存了，直接弹出，将其他的元素压入栈
 */
public class DailyTemperatures739 {
    /*
        [73 74 75 71 69 69 72]

        将73压入栈,然后压入74,发现74比栈顶元素73大,计算出73的距离后将73索引弹出栈 栈内元素: 74
        将75压入栈 同理   栈内元素: 75
        将71压入栈，发现 71小于75，那我们直接压入栈即可     栈内元素: 71 75
        将69压入栈 同理   栈内元素: 69 71 75
        将69压入栈 同理   栈内元素: 69 69 71 75
        将72压入栈 发现找到比栈顶元素的大元素了，计算距离弹出69
        同理继续 弹出 69 71    栈内元素: 72 75
        . . .

        这样我们能够保证栈内的元素时递增的
     */

    public int[] dailyTemperatures(int[] temperatures) {

        int lens = temperatures.length;
        int[] res = new int[lens];

        /*
         如果当前遍历的元素 大于栈顶元素，表示 栈顶元素的 右边的最大的元素就是 当前遍历的元素，
         所以弹出 栈顶元素，并记录
         如果栈不空的话，还要考虑新的栈顶与当前元素的大小关系
         否则的话，可以直接入栈。
         注意，单调栈里 加入的元素是 下标。
         */
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);//压入索引0
        for (int i = 1; i < lens; i++) {//从索引1开始,索引0我们已经压入
            if (temperatures[i] <= temperatures[stack.peek()]) {//栈顶元素大于将要压入的元素时 直接入栈
                stack.push(i);
            } else {
                /*
                    将要入栈的元素大于栈顶元素时
                 */
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    res[stack.peek()] = i - stack.peek();//计算出栈顶元素的距离 当前索引 - 栈顶索引 = i - stack.peek()
                    stack.pop();// 弹出栈顶元素
                }
                stack.push(i);// 压入元素
            }
        }
        return res;
    }

    //简化版本
    /*
        public int[] dailyTemperatures(int[] temperatures) {
        int lens=temperatures.length;
        int []res=new int[lens];
        Deque<Integer> stack=new LinkedList<>();
        for(int i=0;i<lens;i++){

           while(!stack.isEmpty()&&temperatures[i]>temperatures[stack.peek()]){
                    res[stack.peek()]=i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
        }

        return  res;
    }
}
     */
}
