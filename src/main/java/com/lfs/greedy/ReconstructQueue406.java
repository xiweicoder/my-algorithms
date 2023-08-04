package com.lfs.greedy;

import java.util.Arrays;
import java.util.LinkedList;

/*
    根据身高重建队列
 */
public class ReconstructQueue406 {
    /*
        [7,0],[4,4],[7,1],[5,0],[6,1],[5,2]   [h,k]
        [7,0]: 7:本人的身高   0: 说明此人前面有0个人身高>7的
        [4,4]: 4:本人的身高   4: 说明此人前面有4个人身高>4的
        身高这个属性服务于 前面有几个更高的人这个属性,我们只按照第二个属性进行排序

        思路:
            按照身高从大到小排序,身高相同的按照k从小到大排
            然后按照k,k是前面有几个比他身高高的,比他身高高的,我们不用管,因为我们排好序就是前面的一定比他高
            我们只看k,k是几,就放到索引几位置上

        [7,0],[7,1],[6,1],[5,0],[5,2],[4,4]


        [7,0]
        [7,0],[7,1]
        [7,0],[6,1],[7,1]
        [5,0],[7,0],[6,1],[7,1]
        [5,0],[7,0],[5,2],[6,1],[7,1]
        [5,0],[7,0],[5,2],[6,1],[4,4],[7,1]

     */
    public int[][] reconstructQueue(int[][] people) {
        /*
            这里面的a[1] p[1] 指的就是 k 因为people是二维数组
         */

        // 身高从大到小排（身高相同k小的站前面）
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];   //身高h相等,相等的部分按照k从小到大排序(升序)
            return b[0] - a[0];   //身高h不相等,按照从大到小排序(降序)
        });


        LinkedList<int[]> que = new LinkedList<>();
        for (int[] p : people) {
            que.add(p[1], p);   //k作为索引
        }
        return que.toArray(new int[people.length][]);
    }
}
