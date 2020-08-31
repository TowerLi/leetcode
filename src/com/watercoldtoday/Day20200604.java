package com.watercoldtoday;


import java.util.*;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于
 * nums 中除 nums[i] 之外其余各元素的乘积。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *
 *
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 */
public class Day20200604 {
    /**
     * 构造一个左数组与一个右数组，分别保存左边和右边的乘积
     * 空间复杂度为O（2N），时间复杂度为O（3N），遍历三次。
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;

        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];
        //L[i]为索引i左侧所有元素的乘积
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        //R[i]位索引右侧所有元素的乘积
        R[length-1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }

    /**
     * 56. 合并区间
     * 给出一个区间的集合，请合并所有重叠的区间。
     *
     * 示例 1:
     *
     * 输入: [[1,3],[2,6],[8,10],[15,18]]
     * 输出: [[1,6],[8,10],[15,18]]
     * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例 2:
     *
     * 输入: [[1,4],[4,5]]
     * 输出: [[1,5]]
     * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
     * 通过次数101,324提交次数237,471
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        //特判
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[] > list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        while (i < n) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < n -1 && right >= intervals[i+1][0]) {
                right = Math.max(right,intervals[i+1][1]);
                i++;
            }
            list.add(new int[] {left,right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }

    /**
     * KMP算法，获取匹配的子串在字符串中第一个出现的位置
     * @param str1
     * @param str2
     * @return
     */
    public int strStr(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() < 1 || str2.length() <2) {
            return -1;
        }
        int p1 = 0;
        int p2 = 0;
        int[] next = getNext(str2);
        while (p1 < str1.length() && p2 < str2.length()) {
            if (str1.charAt(p1) == str2.charAt(p2)) {
                p1++;
                p2++;
            }else if (next[p2] == -1) {
                //str2不动，str1前进一位
                p1++;
            }else {
                p2 = next[p2];
            }
        }
        return p2 == str2.length() ? p1 - p2 : -1;
    }

    /**
     * KMP算法获取next数组，最长公共前缀后缀
     * @param str2
     * @return
     */
    public static int[] getNext(String str2) {
        if (str2 == null || str2.length() == 1) {
            return new int[]{-1};
        }
        int len = str2.length();
        int[] arr = new int[len];
        arr[0] = -1;
        arr[1] = 0;
        int i = 2;
        int cur = 0;
        while (i < len) {
            if (str2.charAt(i-1) == str2.charAt(cur)) {
                arr[i++] = ++cur;
            }else if (cur > 0) {
                cur = arr[cur];
            }else {
                arr[i++] = 0;
            }
        }
        return arr;
    }

    public static int gcd(int a,int b) {
        return b == 0 ? a : gcd(b,a%b);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Day20200604 day20200604 = new Day20200604();
        int[] ans = day20200604.productExceptSelf(nums);
        for (int i : ans) {
            System.out.print(i+",");
        }
        int[][] nums1 = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] ans1 = day20200604.merge(nums1);
        System.out.println("ans1[i][j]");
        for (int i = 0; i < ans1.length; i++) {
            for (int j = 0; j < ans1[i].length;j++) {
                System.out.print(ans1[i][j]);
                System.out.print(" ");
            }
        }



        List<List<Integer>> l = new ArrayList<List<Integer>>();

        String s = "abcd";
        s.substring(0);
        Queue<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        
    }

}
