package com.watercoldtoday.interview.bigo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * bigo一面 三数之和
 */
public class Solution2 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n-2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(List.of(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                    while (l < r && nums[l] == nums[l-1]) l++;
                    while (l < r && nums[r] == nums[r+1]) r--;
                }else if (sum < 0) {
                    l++;
                }else {
                    r--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution2.threeSum(new int[]{0,1,1}));
        System.out.println(solution2.threeSum(new int[]{0,0,0}));
    }
}
