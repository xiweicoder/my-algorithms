package com.lfs.greedy;

/*
    摆动序列
 */
public class WiggleMaxLength376 {
    /*
        本题代码不多,但细节很多
        细节点:
            1、初始化上一个差值 = 0  (下坡以及两个节点时)
            2、count 和 for循环 从1开始    (当前节点起始是第二个节点,这样才能有上一个节点)
            3、if判断中 preDiff 要有等于0的情况    (这也是下坡以及两个节点的情况考虑)
            4、 preDiff = curDiff 只有出现摆动的情况(满足if)下才进行赋值操作    (避免出现单调平坡情况出问题)

        保留峰值,初始和结尾都是一个峰值,(这是题目所说),我们删除单调坡上的元素,剩下的就是我们要的元素(大体思路)
        先有当先差值才能有上一个差值
        细节部分:
            平坡时,只计入上下坡时,平的元素我们不进入循环
            1、有平坡的情况(12221)时,首先刚刚进入平坡肯定算一个,问题在于下坡,下坡时,上一个节点可以等于0,才能满足峰值
            2、只有两个元素时,我们默认给上一个节点向左延长一个相等的节点,这样3个元素就满足峰值(也就是上一个节点可以等于0)
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;

        int curDiff;//当前差值

        //上一个差值
        int preDiff = 0;// 默认上一个差值可以为0  细节重点
        int count = 1;//从1开始才能有差值  题目所说收尾都是要包含的
        for (int i = 1; i < nums.length; i++) {//注意要从1开始
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;//统计个数
                preDiff = curDiff;//摆动出现时才变动,不然 单调平坡会出问题,长度会加1
            }
        }
        return count;
    }
}
