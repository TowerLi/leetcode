package com.watercoldtoday;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
	public int orangesRotting(int[][] grid){
		int M = grid.length;
		int N = grid[0].length;
		Queue<int[] > queue = new LinkedList<>();
		
		int freshNum = 0; //新鲜橘子的数量
		for (int i = 0;i < M;i++) {
			for (int j = 0;j < N;j++) {
				if (grid[i][j] == 1) {
					freshNum++;
				} else if (grid[i][j] == 2) {
					queue.add(new int[]{i,j});
				}
			}
		}


		//BFS遍历开始
		int min = 0; //腐烂需要的分钟数，即BFS的宽度。
		while (freshNum > 0 && !queue.isEmpty()) {
			min++;
			int n = queue.size();
			for (int a = 0; a < n; a++) {
				int[] orange = queue.poll();
				int r = orange[0];
				int c = orange[1];
				if (r - 1 >= 0 && grid[r - 1][c] == 1) {
					grid[r - 1][c] = 2; //被感染
					freshNum--;
					queue.add(new int[]{r - 1, c});
				}
				if (r + 1 <= M && grid[r + 1][c] == 1) {
					grid[r + 1][c] = 2; //被感染
					freshNum--;
					queue.add(new int[]{r + 1, c});
				}
				if (c - 1 >= 0 && grid[r][c - 1] == 1) {
					grid[r][c - 1] = 2; //被感染
					freshNum--;
					queue.add(new int[]{r, c - 1});
				}
				if (c + 1 <= N && grid[r][c + 1] == 1) {
					grid[r][c + 1] = 2; //被感染
					freshNum--;
					queue.add(new int[]{r, c + 1});
				}
			}
		}
		if (freshNum > 0) {
			return -1;
		} else {
			return min;
		}
	}
}