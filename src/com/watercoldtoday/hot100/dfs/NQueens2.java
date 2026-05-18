package com.watercoldtoday.hot100.dfs;

public class NQueens2 {
    int ans = 0;
    public int totalNQueens(int n) {
        ans = 0;
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2*n -1];
        boolean[] diag2 = new boolean[2*n -1];

        dfs(0, n, cols, diag1, diag2);
        return ans;
    }

    private void dfs(int r, int n, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (r == n) {
            ans ++;
            return;
        }
        for (int c = 0; c < n; ++c) {
            if (diag1[r+c] || diag2[r-c+n-1] || cols[c]) continue;
            diag1[r+c] = diag2[r-c+n-1] = cols[c] = true;
            dfs(r+1, n, cols, diag1, diag2);
            diag1[r+c] = diag2[r-c+n-1] = cols[c] = false;
        }
    }

    public static void main(String[] args) {
        NQueens2 nQueens2 = new NQueens2();
        System.out.println(nQueens2.totalNQueens(4));
        System.out.println(nQueens2.totalNQueens(1));
    }
}
