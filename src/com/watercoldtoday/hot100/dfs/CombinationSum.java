package com.watercoldtoday.hot100.dfs;

import java.util.ArrayList;
import java.util.List;

import static com.watercoldtoday.daily_question.Day20200420.dfs;

public class CombinationSum {
    /**
     * 示例 1：
     *
     * 输入：candidates = [2,3,6,7], target = 7
     * 输出：[[2,2,3],[7]]
     * 解释：
     * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
     * 7 也是一个候选， 7 = 7 。
     * 仅有这两种组合。
     * 示例 2：
     *
     * 输入: candidates = [2,3,5], target = 8
     * 输出: [[2,2,2,2],[2,3,3],[3,5]]
     * 示例 3：
     *
     * 输入: candidates = [2], target = 1
     * 输出: []
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, ArrayList<Integer> temp, int[] candidates, int target,int idx) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = idx; i < candidates.length; ++i) {
            if (target < candidates[i]) continue;
            temp.add(candidates[i]);
            dfs(ans,temp,candidates,target - candidates[i], i);
            temp.remove(temp.size()-1);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum.combinationSum(new int[]{2,3,5}, 8));
        System.out.println(combinationSum.combinationSum(new int[]{2}, 1));
    }
}
