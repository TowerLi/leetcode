package com.watercoldtoday;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return new int[0];
        int n = nums.length;
        int[] ans = new int[n-k+1];
        //双向队列存储nums的下标，用于滑动清理
        //nums最多添加一次，清理一次，总体时间小于2n，属于线性的时间复杂度
        Deque<Integer> deque = new ArrayDeque<Integer>();
        int windowsIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            //剔除无效数据 最多K个数据，下标小于i-k+1的数据要清理出局
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            //剔除无效数据,上一个数据小于当前i，也是无效数据，不可能在i没被剔除之前成为最大数，也要提前清理
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            if (i + 1 >= k) {
                ans[windowsIndex++] = nums[deque.peek()];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode_239 leetcode_239 = new Leetcode_239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] ans = leetcode_239.maxSlidingWindow(nums,k);
        System.out.println("ans is : " + Arrays.toString(ans));
    }
}
