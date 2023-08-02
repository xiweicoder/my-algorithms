package com.lfs.backtrack;

import java.util.*;

public class test {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];// 构造棋盘
        for (char[] c : chess) {
            Arrays.fill(c, '.');//题目要求
        }
        backtracking(n, 0, chess);
        return res;
    }

    private void backtracking(int n, int row, char[][] chess) {
        if (row == n) {
            res.add(charToList(chess));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, chess)) {
                chess[row][col] = 'Q';
                backtracking(n, row + 1, chess);
                chess[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] chess) {
        for (int i = 0; i < row; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j <= n - 1; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    //二维数组转string类型list
    private List<String> charToList(char[][] chess) {
        ArrayList<String> list = new ArrayList<>();
        for (char[] c : chess) {
            list.add(String.valueOf(c));
        }
        return list;
    }


}
