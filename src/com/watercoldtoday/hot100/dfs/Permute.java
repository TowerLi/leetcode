package com.watercoldtoday.hot100.dfs;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    /**
     * 示例 1：
     *
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * 示例 2：
     *
     * 输入：nums = [0,1]
     * 输出：[[0,1],[1,0]]
     * 示例 3：
     *
     * 输入：nums = [1]
     * 输出：[[1]]
     */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        dfs(ans, vis, new ArrayList<>(), nums);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, boolean[] vis, List<Integer> temp, int[] nums) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (vis[i]) continue;
            vis[i] = true;
            temp.add(nums[i]);
            dfs(ans, vis, temp, nums);
            temp.remove(temp.size()-1);
            vis[i] = false;
        }
    }

    public static void main(String[] args) {
        Permute permute = new Permute();
        System.out.println(permute.permute(new int[] {1,2,3}));
        System.out.println(permute.permute(new int[] {0,1}));
        System.out.println(permute.permute(new int[] {1}));
    }
}
