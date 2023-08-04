package com.lfs.greedy;

/*
    柠檬水找零
 */
public class LemonadeChange860 {
    /*
        bills = [5,5,5,10,20]
        一份卖5元,所以前3位我们不需找零,一开始我们没有任何钱
        1、 5
        2、 10 5
        3、 20  10+5  5+5+5 优先采用10+5的策略
     */
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {//1、遇到5直接++
                five++;
            } else if (bills[i] == 10) {// 2、遇到10
                five--;
                ten++;
            } else if (bills[i] == 20) {// 3、遇到20有两种消费策略,优先花10元,次之花3个5元
                if (ten > 0) {
                    ten--;
                    five--;
                } else {
                    five -= 3;// 花费3个5元
                }
            }
            if (five < 0 || ten < 0) return false;
        }

        return true;
    }
}
