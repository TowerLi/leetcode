package com.watercoldtoday;

import java.util.Arrays;

/*
130. Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of
the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected
to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent
 cells connected horizontally or vertically.
 */
public class Day20200811 {
    int row, col;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        row = board.length;
        col = board[0].length;
        //第一行，最后一行
        for (int i = 0; i < col; i++) {
            infect(board, 0, i);
            infect(board, row - 1, i);
        }
        //第一列，最后一列
        for (int i = 0; i < row; i++) {
            infect(board, i, 0);
            infect(board, i, col - 1);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
        return;

    }

    public void infect(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] != 'O') return;
        board[i][j] = 'T';
        infect(board, i, j + 1);
        infect(board, i, j - 1);
        infect(board, i - 1, j);
        infect(board, i + 1, j);
        return;
    }


    public static void main(String[] args) {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        Day20200811 d11 = new Day20200811();
        d11.solve(board);
        System.out.println("board : " + Arrays.deepToString(board));
    }
}