package com.watercoldtoday;

import java.util.*;

/**
 * 40. 组合总和 II
 * 给定一个数组 candidates 和一个目标数 target
 * 找出 candidates 中所有可以使数字和为 target 的组合。
 * https://leetcode-cn.com/problems/combination-sum-ii/
 */
public class Leetcode_40 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if (target <= 0) return ans;
        Arrays.sort(candidates);
        //回溯
        //backtrack(ans,list,candidates,target,0);
        backtrack(0,target,ans,list,candidates);
        //去重
        //ans = new ArrayList<List<Integer>>(new HashSet<List<Integer>>(ans));
        return ans;
    }
    private void backtrack(List<List<Integer>> ans,List<Integer> list,int[] candidates,int target,int start) {
        if (0 == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            //剪枝
            if (candidates[i] > target ) {
                continue;
            }
            list.add(candidates[i]);
            backtrack(ans,list,candidates,target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
    private void backtrack(int begin,int target,List<List<Integer>> ans,List<Integer> path,int[] candidates) {
        if (target == 0) {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
        if (begin >= candidates.length || candidates[begin] > target) {
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            //去重
            if (i > begin && candidates[i] == candidates[i-1]) {
                continue;
            }
            path.add(candidates[i]);
            System.out.println("递归以前 =>" + path + ",剩余 = " + (target-candidates[i]));
            backtrack(i+1,target-candidates[i],ans,path,candidates);
            path.remove(path.size()-1);
            System.out.println("递归以后 =>" + path + ",剩余 = " + (target-candidates[i]));
        }
    }
    /**
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * @param args
     */
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Leetcode_40 leetcode_40 = new Leetcode_40();
        List<List<Integer>> ans = leetcode_40.combinationSum2(candidates,target);
        System.out.println("ans is : " + ans);
    }
}
