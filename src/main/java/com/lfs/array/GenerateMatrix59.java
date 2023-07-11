package com.lfs.array;

/*
    螺旋矩阵
    1   2  3
    8   9  4
    7   6  5

    1       2       3       4

    12      13      14      5

    11      16      15      6

    10      9       8       7


    给你一个正整数 n ，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class GenerateMatrix59 {
    /*
        遇到边界时，增加相应的边界，然后转换方向继续遍历
        left -> right  循环条件: 右边界>左边界      top++ 向内收缩1
        top -> bottom  循环条件: 下边界>上边界
        right -> left  循环条件: 右边界>左边界
        bottom -> top  循环条件: 下边界>上边界

        循环条件其实就两个，就是不能让左大于右,上大于下
        t++;   因为左->右 按照数组的存储来说，下次top指针变大
        r--;    top -> bottom 最右边一列填满，right最大值-1
        b--;     right -> left 最下边一列填满，bottom最大值-1
        l++;     bottom -> top 最左边一列填满，left的下次的指针增大
     */
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;  // 初始化num来填充，tar数组作为容器
        while (num <= tar) {  // 1 <= 25

            /*
                每次循环i都不同，i作为变量每次发生变动;  而不变的是填充的哪个方向就是那个
                l -> r i作为列;    填充的top      tar[t][i]
                t -> b i作为行;    填充的right    tar[i][r]
                r -> l i作为列;    填充的bottom   tar[b][i]
                b -> t i作为行;    填充的left     tar[i][l]
             */
            for (int i = l; i <= r; i++) mat[t][i] = num++; // left to right.
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++; // top to bottom.
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++; // right to left.
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++; // bottom to top.
            l++;
        }
        return mat;
    }


    /*
        难点在于循环条件:   n-loop ; loop
        何时大于，何时小于 为什么?
        同时还要维护start ，既可以作为行 又可以作为列 每循环一圈 +1
     */
    public int[][] generateMatrix2(int n) {
        int loop = 0;  // 控制循环次数
        int[][] res = new int[n][n];
        int start = 0;  // 每次循环的开始点(start, start)
        int count = 1;  // 定义填充数字
        int i, j; // i:行 j:列

        while (loop++ < n / 2) { // 判断边界后，loop从1开始
            // 模拟上侧从左到右
            for (j = start; j < n - loop; j++) { // j < n-loop 目的是完成左闭右开
                res[start][j] = count++;
            }

            // 模拟右侧从上到下
            for (i = start; i < n - loop; i++) {
                res[i][j] = count++;
            }

            // 模拟下侧从右到左
            for (; j >= loop; j--) { // 到这时j已经最大了，不需要初始化. loop最小是1，>= 1 也实现左闭右开
                res[i][j] = count++;
            }

            // 模拟左侧从下到上
            for (; i >= loop; i--) {
                res[i][j] = count++;
            }
            start++;
        }

        if (n % 2 == 1) {
            res[start][start] = count;
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] ints = new GenerateMatrix59().generateMatrix2(4);
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.print(ints[i][j] + "     ");

            }
            System.out.println();
        }
    }
}
