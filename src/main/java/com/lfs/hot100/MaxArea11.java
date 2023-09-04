package com.lfs.hot100;

/*
    盛水最多的容器
 */
public class MaxArea11 {
    /*
        若向内移动短板,水槽的短板 可能变大，因此下个水槽的面积 可能增大 。
        若向内移动长板,水槽的短板不变或变小，因此下个水槽的面积 一定变小
        因此，初始化双指针分列水槽左右两端，循环每轮将短板向内移动一格，并更新面积最大值，直到两指针相遇时跳出；即可获得最大面积

        容器面积 = 高 * 底边长度(j - i)
        高是由最短板决定的，所以我们尽量移动指针找长板
        底边长度是变化的，
     */
    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res = 0;

        /*
            每次移动短板就比较一下谁才是下一次移动的短板
            j代表右侧短板
            i代表左侧短板
            如果右侧短板大于左侧短板 左侧短板++
            如果左侧短板大于右侧短板 右侧短板--
         */
        while (i < j) {
            if (height[i] < height[j]) {
                res = Math.max(res, (j - i) * height[i++]);
            } else {
                res = Math.max(res, (j - i) * height[j--]);
            }
        }
        return res;
    }
}
