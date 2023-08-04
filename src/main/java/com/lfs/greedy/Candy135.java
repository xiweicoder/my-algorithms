package com.lfs.greedy;

/*
    分发糖果
 */
public class Candy135 {
    /*
        两个方面都要考虑,我们分开想

        1、右孩子比左孩子得分高的情况
        [1,2,2,5,4,3,2]
         1 2 1 2 1 1 1  糖果数量
        2、左孩子比右孩子得分高的情况 (从后向前遍历)
            如果还是从前向后遍历,结果就有问题
        [1,2,2,5,4,3,2]
         1 2 1 2 1 1 1  糖果数量
         1 2 1 4 3 2 1 最终数量
     */
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candy = new int[len];
        candy[0] = 1;
        for (int i = 1; i < len; i++) {//要从1开始,我们比较至少要有两个数
            if (ratings[i] > ratings[i - 1]) {//右比左大时
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }

        for (int i = len - 2; i >= 0; i--) {// len-2: len-1是索引最后一个, len-2是倒数第二个元素
            if (ratings[i] > ratings[i + 1]) {//左比右大时
                /*
                    这里要取之前糖果的最大值,才能保证两种情况都照顾到
                    candy[i]: 第一种情况下的糖果
                    candy[i + 1] + 1: 第二种情况下的糖果
                 */
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        // 求和
        int ans = 0;
        for (int num : candy) {
            ans += num;
        }
        return ans;
    }
}
