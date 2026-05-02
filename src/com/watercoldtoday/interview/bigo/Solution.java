package com.watercoldtoday.interview.bigo;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        /**
         * 实例1：
         * 输入: mat = [[1,4],[3,2]]
         * 输出: [0,1]
         * 解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
         *
         * 实例2：
         * 输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
         * 输出: [1,1]
         * 解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
         */
        int[][] mat1 = new int[][]{{10,20,15}, {21,30,14}, {7,16,32}};
        int[][] mat2 = new int[][]{{1,4}, {3,2}};
        System.out.println(Arrays.toString(solution.getPeakNum(mat1)));
        System.out.println(Arrays.toString(solution.getPeakNum(mat2)));
    }

    public int[] getPeakNum(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] rowMax = new int[m];
        for (int i = 0; i < m; ++i) {
            rowMax[i] = findMax(mat[i]);
        }
        for (int i =0; i < m; ++i) {
            int maxCol = rowMax[i];
            int rowMaxNum = mat[i][maxCol];
            if ((i - 1 < 0 || rowMaxNum > mat[i-1][maxCol] ) &&
                    (i + 1 >= m || rowMaxNum > mat[i+1][maxCol] )) {
                return new int[]{i,maxCol};
            }

        }
        return null;
    }

    private int findMax(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (arr[mid] < arr[mid+1]) {
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return l;
    }
}
