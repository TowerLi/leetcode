package com.watercoldtoday.hot100.binary_search;

import java.util.Arrays;

// leetcode 34
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1) return new int[] {-1,-1};
        int L = lower_bound(nums, target);
        if (L == nums.length || nums[L] != target) return new int[] {-1,-1};
        int R = lower_bound(nums,target+1) - 1;

        return new int[]{L,R};
    }

    private int lower_bound(int[] nums,int target) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = l + (r-l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{}, 0)));
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{1}, 1)));
    }
}
