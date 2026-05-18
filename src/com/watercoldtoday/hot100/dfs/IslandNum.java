package com.watercoldtoday.hot100.dfs;

public class IslandNum {

    /**
     * 示例 1：
     *
     * 输入：grid = [
     *   ['1','1','1','1','0'],
     *   ['1','1','0','1','0'],
     *   ['1','1','0','0','0'],
     *   ['0','0','0','0','0']
     * ]
     * 输出：1
     * 示例 2：
     *
     * 输入：grid = [
     *   ['1','1','0','0','0'],
     *   ['1','1','0','0','0'],
     *   ['0','0','1','0','0'],
     *   ['0','0','0','1','1']
     * ]
     * 输出：3
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int count = 0;
        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                if (grid[r][c] == '1') {
                    count++;
                    dfs(r,c, rows, cols, grid);
                }
            }
        }
        return count;
    }

    private void dfs(int r, int c, int rows, int cols, char[][] grid) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != '1') {
            return;
        }
        grid[r][c] = '0';
        dfs(r+1,c, rows, cols,grid);
        dfs(r-1,c, rows, cols,grid);
        dfs(r,c+1, rows, cols,grid);
        dfs(r,c-1, rows, cols,grid);
    }

    public static void main(String[] args) {
        char[][] grid1 = new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        char[][] grid2 = new char[][] {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        IslandNum islandNum = new IslandNum();
        System.out.println(islandNum.numIslands(grid1));
        System.out.println(islandNum.numIslands(grid2));
    }
}
