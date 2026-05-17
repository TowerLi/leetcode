package com.watercoldtoday.hot100.binary_search;

public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int l = 0, r = rows * cols;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (matrix[mid/cols][mid%cols] == target) {
                return true;
            }else if (matrix[mid/cols][mid%cols] < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length, cols = matrix[0].length;
        int top = 0, bottom = rows;
        while (top < bottom) {
            int midRow = top + (bottom - top) / 2;
            if (matrix[midRow][cols-1] == target) {
                return true;
            }
            if (matrix[midRow][cols-1] < target) {
                top = midRow + 1;
            }else {
                bottom = midRow;
            }
        }
        if (top == rows) return false;
        int l = 0, r = cols;
        while (l < r) {
            int mid = l + (r-l)/2;
            if (matrix[top][mid] == target) {
                return true;
            }else if (matrix[top][mid] < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        System.out.println(searchMatrix.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(searchMatrix.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));
    }
}
