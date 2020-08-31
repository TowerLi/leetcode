package com.watercoldtoday;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Day20200605 {
    /**
     * 面试题29. 顺时针打印矩阵
     * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
     *
     *
     *
     * 示例 1：
     *
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 示例 2：
     *
     * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     *
     * 限制：
     *
     * 0 <= matrix.length <= 100
     * 0 <= matrix[i].length <= 100
     * @param matrix
     * @return
     */
    public int[] spiralOrder(int[][] matrix) {
        //按层遍历
        //时间复杂度O(MN) ，遍历所有矩阵的元素
        //空间复杂度O（1），除了输出数组外，空间复杂度是常数。

        // 上 top,left ... top,right
        // 右 top+1,right ... bottom,right
        // 下 bottom,right-1 ... bottom,left+1
        // 左 bottom,left ... top+1,left

        //特判
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] spiralorder = new int[rows*columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int column = left; column <= right; column++) {
                spiralorder[index++] = matrix[top][column];
            }
            for (int row = top + 1; row <= bottom; row++) {
                spiralorder[index++] = matrix[row][right];
            }
            if (left < right && top < bottom) {
                for (int column = right - 1; column >= left + 1; column--) {
                    spiralorder[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row >= top + 1; row--) {
                    spiralorder[index++] = matrix[row][left];
                }
            }
            top++;
            left++;
            bottom--;
            right--;
        }
        return spiralorder;
    }
        //快速排序
   public void quicksort(int[] arr, int left, int right) {
        int test = 1;
        if (arr == null || arr.length == 0) {
            return;
        }
        if (left >= right) {
            return;
        }
        //中位数
        int pivotindex = left + ((right-left) >> 1);
        int pivot = arr[pivotindex];

        int i = left, j = right;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swapele(arr,i,j);
                i++;
                j--;
            }
        }
        if (left < j) {
            quicksort(arr,left,j);
        }
        if (right > i) {
            quicksort(arr,i,right);
        }
   }

   public static void swapele(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
   }

    public static void quickSort2(int[] arr, int low, int high)
    {
        //check for empty or null array
        if (arr == null || arr.length == 0){
            return;
        }

        if (low >= high){
            return;
        }

        //Get the pivot element from the middle of the list
        int middle = low + ((high - low) >> 1);
        int pivot = arr[middle];

        // make left < pivot and right > pivot
        int i = low, j = high;
        while (i <= j)
        {
            //Check until all values on left side array are lower than pivot
            while (arr[i] < pivot)
            {
                i++;
            }
            //Check until all values on left side array are greater than pivot
            while (arr[j] > pivot)
            {
                j--;
            }
            //Now compare values from both side of lists to see if they need swapping
            //After swapping move the iterator on both lists
            if (i <= j)
            {
                swap (arr, i, j);
                i++;
                j--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (low < j){
            quickSort2(arr, low, j);
        }
        if (high > i){
            quickSort2(arr, i, high);
        }
    }
    public static void swap (int array[], int x, int y)
    {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int length = arr.length;
        //quicksort(arr,0,length-1);
    }

    public static void main(String[] args) {
        Day20200605 d5 = new Day20200605();
        /*
        int[][] test = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ans = d5.spiralOrder(test);
        System.out.println("the ans is ");
        for (int i : ans) {
            System.out.print(i);
            System.out.print(" ");
        }*/
        int[] unsortedArray = {6, 5, 3, 1, 8, 7, 2, 4};

        System.out.println("Unsorted Arrays: " + Arrays.toString(unsortedArray));
        d5.quicksort(unsortedArray,0,unsortedArray.length-1);
        System.out.println("Sorted Arrays :" + Arrays.toString(unsortedArray));

        double d = Double.valueOf("8.90");
        String s = "5.69,8.90,8.65,5.23";
        String[] stringarr = s.split(",");
        StringBuilder sb = new StringBuilder(s);
        String.valueOf(d).length();
        for (String ss : stringarr) {
            System.out.print("the double is ");
            BigDecimal de = new BigDecimal(ss);
            System.out.println(de.doubleValue());
        }
        sb.delete(4,9);
        BigDecimal bd = new BigDecimal(stringarr[1]);
        Double de = bd.doubleValue();
        System.out.println("de:" + de);
        System.out.println("d:"+d);
        System.out.println("d length :" + String.valueOf(d).length());
        System.out.print("sb: " + sb.toString());
        Set<Integer> p = new HashSet<Integer>();
        System.out.println("hashset add 1" + p.add(1));
        System.out.println("hashset add 2" + p.add(1));
    }
}
