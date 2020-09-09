package com.watercoldtoday;

/**
 * 39. 组合总和
 * https://leetcode-cn.com/problems/combination-sum/
 */
import java.util.*;
public class Leetcode_39 {
    /**
     * 回溯算法，寻找所有可能解的问题
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates,int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        if (target < 0) return ans;
        //排序是剪枝的前提
        Arrays.sort(candidates);
        backtrack(ans,tmp,0,candidates,target);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> tmp, int start, int[] candidates, int target) {
        if (target == 0) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //剪枝
            if (target - candidates[i] < 0) {
                return;
            }
            tmp.add(candidates[i]);
            backtrack(ans,tmp,i,candidates,target-candidates[i]);
            tmp.remove(tmp.size()-1);
        }
    }


    public static void main(String[] args) {
        //7, 2 2 3;
        int[] candidates = {2,3,6,7};
        int target = 7;
        // 2 2 2 2,2 3 3,3 5;
        Leetcode_39 leetcode_39 = new Leetcode_39();
        List<List<Integer>> ans = leetcode_39.combinationSum(candidates,target);
        System.out.println("ans is : " + ans);
        candidates = new int[]{8,7,4,3};
        target = 11;
        ans = leetcode_39.combinationSum(candidates,target);
        System.out.println("ans2 is : " + ans);
    }
}
