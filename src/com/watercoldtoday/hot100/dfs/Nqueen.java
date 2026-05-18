package com.watercoldtoday.hot100.dfs;

import java.util.ArrayList;
import java.util.List;

public class Nqueen {

    // 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    public List<List<String>> solveNqueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] diag1 = new boolean[2*n - 1];
        boolean[] diag2 = new boolean[2*n - 1];
        boolean[] cols = new boolean[n];
        char[][] board = new char[n][n];
        for (int r = 0; r < n; ++r) {
            for (int c = 0; c <n; ++c) {
                board[r][c] = '.';
            }
        }
        dfs(board, diag1, diag2, cols,  0, ans);
        return ans;
    }

    private void dfs(char[][] board, boolean[] diag1, boolean[] diag2, boolean[] cols, int r, List<List<String>> ans) {
        int n = board.length;
        if (r == n) {
            ans.add(new ArrayList<>(buildBoard(board)));
            return;
        }
        for (int c = 0; c < n; ++c) {
            if (!diag1[r+c]  && !diag2[r-c+n-1] && !cols[c]) {
                board[r][c] = 'Q';
                diag1[r+c] = diag2[r-c+n-1] = cols[c] = true;
                dfs(board, diag1,diag2, cols, r+1, ans);
                diag1[r+c] = diag2[r-c+n-1] = cols[c] = false;
                board[r][c] = '.';
            }
        }

    }

    private List<String> buildBoard(char[][] board) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < board.length; ++i) {
            temp.add(new String(board[i]));
        }
        return temp;
    }

    public static void main(String[] args) {
        Nqueen nqueen = new Nqueen();
        System.out.println(nqueen.solveNqueens(4));
    }
}
