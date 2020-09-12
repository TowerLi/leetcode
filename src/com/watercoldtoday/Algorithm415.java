package com.watercoldtoday;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 *
 * 两个相邻元素间的距离为 1 。
 *
 * 示例 1:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 *
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 *
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * 注意:
 *
 * 给定矩阵的元素个数不超过 10000。
 * 给定矩阵中至少有一个元素是 0。
 * 矩阵中的元素只在四个方向上相邻: 上、下、左、右。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Algorithm415 {

    public static void main(String[] args) {
        int[][] testArr = {{0,0,0},{0,1,0},{1,1,1}};
        int[][] testArr2 = {{0,1,0,1,1},{1,1,0,0,1},{0,0,0,1,0},{1,0,1,1,1},{1,0,0,0,1}};
        int[][] ans = updateMatrix(testArr2);
        for (int i = 0,count = 0;i < ans.length;i++) {
            for (int j = 0;j < ans[0].length;j++) {
                count++;
                System.out.print(ans[i][j]+" ");
                if (count%5 == 0) {
                    System.out.println();
                }
            }
        }

    }

    public static int[][] updateMatrix(int[][] martix) {
        //广度搜索坐标，左右上下
        int[][] dirs = new int[][] {{-1,0},{1,0},{0,-1},{0,1}};
        int m = martix.length,n = martix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[] > queue = new LinkedList<>();
        //将所有的0加入队列中
        for (int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++){
                if(martix[i][j] == 0) {
                    queue.offer(new int[]{i,j});
                    seen[i][j] = true;
                }
            }
        }

        //BFS
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int i = point[0],j = point[1];
            for (int d = 0;d < 4;++d){
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    queue.offer(new int[] {ni,nj});
                    seen[ni][nj] = true;
                }
            }
        }
        return dist;
    }
    public static int[][] updateMatrix2(int[][] matrix) {
        Queue<int[] > queue = new LinkedList<>();
        int m = matrix.length,n = matrix[0].length;
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[] {i,j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }
        int[] dx = new int[] {-1,1,0,0};
        int[] dy = new int[] {0,0,-1,1};
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0],y = point[1];
            for (int i = 0;i < 4;i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == -1) {
                    matrix[newX][newY] = matrix[x][y] + 1;
                    queue.offer(new int[] {newX,newY});
                }
            }
        }
        return matrix;
    }
}
