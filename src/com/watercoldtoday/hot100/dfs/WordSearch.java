package com.watercoldtoday.hot100.dfs;

public class WordSearch {

    // 输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = "ABCCED"
    //输出：true
    int rows = 0, cols = 0;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (dfs(r,c,0, word,board)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int r,int c,int idx, String word, char[][] board) {
        if (idx == word.length()) {
            return true;
        }
        if (r < 0 || r >= rows || c < 0 || c >= cols || word.charAt(idx) != board[r][c]) {
            return false;
        }
        char temp = board[r][c];
        board[r][c] = '#';
        boolean res = dfs(r+1,c, idx + 1, word, board) ||
                    dfs(r-1,c, idx+1, word,board) ||
                    dfs(r, c+1, idx + 1, word, board) ||
                    dfs(r, c-1, idx + 1, word, board);
        board[r][c] = temp;
        return res;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        System.out.println(wordSearch.exist(new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
    }
}
