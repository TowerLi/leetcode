package com.watercoldtoday;

import java.util.*;

public class Day20200612 {
    /**
     * 15. 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否
     * 存在三个元素 a，b，c ，使得 a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        //排序 + 双指针
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return ans;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                //去重
                continue;
            }
            //双指针
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                }else if (nums[i] + nums[l] + nums[r] > 0) {
                    //需要左移
                    r--;
                }else {
                    l++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Day20200612 d12 = new Day20200612();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = d12.threeSum(nums);
        System.out.println("ans is ");
        System.out.println(ans);
        String prefix = "abcdef";
        prefix = prefix.substring(0, prefix.length() - 1);
        System.out.println("prefix is " + prefix);
        prefix = prefix.substring(0, prefix.length() - 1);
        System.out.println("prefix is " + prefix);
        prefix = prefix.substring(0, prefix.length() - 1);
        System.out.println("prefix is " + prefix); 
    }
}
