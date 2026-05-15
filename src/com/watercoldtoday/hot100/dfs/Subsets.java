package com.watercoldtoday.hot100.dfs;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    //示例 1：
    //
    //输入：nums = [1,2,3]
    //输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    //示例 2：
    //
    //输入：nums = [0]
    //输出：[[],[0]]
    public List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, ans, new ArrayList<>(), 0);
        return ans;

    }

    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> temp, int idx) {
        ans.add(new ArrayList<>(temp));
        for (int i = idx; i < nums.length; ++i) {
            temp.add(nums[i]);
            dfs(nums,ans,temp, i+1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        System.out.println(subsets.subset(new int[] {1,2,3}));
        System.out.println(subsets.subset(new int[] {0}));
    }
}

