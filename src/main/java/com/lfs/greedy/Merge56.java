package com.lfs.greedy;

import java.util.*;

/*
    合并区间
    使区间没有重叠部分
 */
public class Merge56 {
    /*
        [[1,3][8,10][2,6][15,18]]
        输出:[1,6][8,10][15,18] [1,3][2,6]，有重叠部分需要合在一起
        [1 3]
           [2 6]
                  [8 10]
                          [15 18]
     */

    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        res.add(intervals[0]);// 先放入一个区间
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res.getLast()[1]) {// 比较本区间的左边界 小于等于 上一个区间的右边界  说明有重叠部分
                int start = res.getLast()[0];// 拿到上一个区间的左边界(其实左边界不用动,单独拿出来写更美观)
                int end = Math.max(intervals[i][1], res.getLast()[1]);//拿到最大右边界,因为右边界我们是不确定的,有可能上一个区间的右边界也大于本区间的 例如:  上: [1 4] 本:[2 3] 我们选4

                //合并区间
                res.removeLast();
                res.add(new int[]{start, end});
            } else {//没有重叠部分,直接放入结果中
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
