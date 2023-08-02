package com.lfs.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    N皇后
 */
public class SolveNQueens51 {
    /*
        行不能重复;列不能重复;斜着两条对角线不能重复
     */
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];//构造棋盘
        for (char[] c : chessboard) {
            Arrays.fill(c, '.');// 题目要求用 . 填充
        }
        backTrack(n, 0, chessboard);
        return res;
    }


    public void backTrack(int n, int row, char[][] chessboard) {
        if (row == n) {// 一行走完,收割结果
            res.add(charToList(chessboard));
            return;
        }

        /*
            第一行第一列 第二列 第三列 ... 到边界 -> 第二行第一列...
         */
        for (int col = 0; col < n; ++col) {
            if (isValid(row, col, n, chessboard)) {
                chessboard[row][col] = 'Q';
                backTrack(n, row + 1, chessboard);
                chessboard[row][col] = '.';
            }
        }

    }

    //二维数组转string类型list
    public List<String> charToList(char[][] chessboard) {
        List<String> list = new ArrayList<>();

        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));//这里要用这种形式复制,不要直接valueOf，不然会拖慢速度
        }
        return list;
    }


    /*
        检查列:
        只用检查列,行为什么不用检查,因为我们就是按照行放置的,行不可能冲突(会回溯)

        检查对角线:
        假设本次皇后在坐标 32 位置 那我们要检查:

                \ /   这两个方向是否有Q存在
                 32

        左上: 21 [32]
        右上: [32] 23 14
        我们要检查走过的路,也就是上面的部分,因为下面的部分我们还没进行检查,没办法进行排查

        11 12 13 14 15
        21 22 23 24 25
        31 32 33 34 35
        41 42 43 44 45
        51 52 53 54 55
     */
    public boolean isValid(int row, int col, int n, char[][] chessboard) {
        // 检查列 行动列不动
        for (int i = 0; i < row; ++i) { // 相当于剪枝
            if (chessboard[i][col] == 'Q') {
                return false;
            }
        }

        // 检查45度对角线 左上 \
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }

        // 检查135度对角线 右上 /
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {//注意这里的条件
            if (chessboard[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
