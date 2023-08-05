package com.lfs.greedy;

import java.util.Arrays;
import java.util.Comparator;

/*
    用最少数量的箭引|爆气球
 */
public class FindMinArrowShots452 {
    /*
        本题和435不同在收集结果的时机不同
        本题是无重叠时收集结果
        435是有重叠时收集结果,也因此代码不用多写else的部分
     */
    /*
    [[1,2][3,6][7,12][4,8][10,16]]  result = 3
     [1  2]
           [3  6]
             [4   8]
                 [7  12]
                     [10  16]

             ↑ 向上射箭

    如果右边气球的左边界大于左边气球的右边界,那么一定需要多加一个气球 [1 2] [3 6] 3>2
    否则(左边气球的右边界大于右边气球的左边界) [3 6] [4 8] 6>4
        一定重叠
    在判断一次重叠后,我们还需要判断是否与下一个气球重叠,如何判断?
        判断一次后,我们要更新右边界,更新为两个重叠气球的[最小右边界]
        例如: [3 6] [4 8] [7 12]
        我们判断出  [3 6] [4 8]这两个气球是重叠的,那我们更新气球右边界,更新为6,进入下次循环 if ([7 12] [4 6]) 7>6 需要一只箭
        在判断完 [3 6] [4 8]后 当前的points[i][1] = 6 下一次循环的 points[i - 1][1]=6,进入下一次循环
            7>6 需要再加一支箭,... 下次判断的  points[i - 1][1]=12    12 >10 重叠
     */

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // 根据气球直径的开始坐标从小到大排序
        // 使用Integer内置比较方法，不会溢出
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));//按照左边界进行排序

        int count = 1;  // points 不为空至少需要一支箭
        for (int i = 1; i < points.length; i++) {// i 和 i-1 进行比较 i从1开始  不然会出现负数
            if (points[i][0] > points[i - 1][1]) {  // 右边气球的左边界大于左边气球的右边界(无重叠)
                count++; // 需要一支箭
            } else {  // 一定重叠
                points[i][1] = Math.min(points[i][1], points[i - 1][1]); // 更新重叠气球最小右边界
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2}, {3, 6}, {7, 12}, {4, 8}, {10, 16}};
        int minArrowShots = new FindMinArrowShots452().findMinArrowShots(nums);
        System.out.println(minArrowShots);
    }
}
