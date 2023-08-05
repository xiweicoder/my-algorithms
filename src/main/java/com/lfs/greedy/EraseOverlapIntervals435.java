package com.lfs.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
    无重叠区间
 */
public class EraseOverlapIntervals435 {
    /*
        [[1,2],[2,3],[3,4],[1,3]] result = 1
        [1 2]
             [2 3]
                  [3 4]
         [1     3]
         删除[1 3] 区间就没有重叠部分 判断有多少重叠的区间就是答案
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int result = 0;


        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {// 右区间的左边界 小于 左区间的右边界 = 有重叠部分
                result++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return result;
    }
}
