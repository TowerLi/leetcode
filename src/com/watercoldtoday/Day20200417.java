package com.watercoldtoday;

import java.util.HashMap;
import java.util.Map;

/**
 * 2020-04-17 LeetCode 每日一题
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 *
 *
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class Day20200417 {
    //贪心算法
    public static boolean canJump(int[] nums) {
        int len = nums.length;

        //最大可达位置
        int rightmost = 0;
        for (int i = 0; i < len; i++) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
            }
            if (rightmost >= len - 1) {
                return true;
            }
        }
        return false;
    }
    //倒着推
    public static boolean canJump2(int[] nums) {
        int min = nums.length - 1;
        for (int i = nums.length - 2; i > 0; i--) {
            if (i + nums[i] >= min) {
                min = i;
            }
        }
        return nums[0] >= min;
    }
    //顺着推2，贪心
    public static boolean canJump3(int[] nums) {
        //前面的点可到达的最大值
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > max) {
                //不可达
                return false;
            }
            if (i + nums[i] > max) {
                max = i + nums[i];
            }
        }
        return true;
    }
    private static void printArray(int[][] a) {
        for (int i = 0; i < a.length; ++i) {
            System.out.println(a[i]);
        }
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; a[i] != null && j < a[i].length; ++j) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.println("Example I:");
        int[][] a = new int[2][5];
        printArray(a);
        System.out.println("Example II:");
        int[][] b = new int[2][];
        printArray(b);
        System.out.println("Example III:");
        b[0] = new int[3];
        b[1] = new int[5];
        printArray(b);
        
    }
}
