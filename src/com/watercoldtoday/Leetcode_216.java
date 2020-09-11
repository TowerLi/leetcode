package com.watercoldtoday;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * https://leetcode-cn.com/problems/combination-sum-iii/
 */
public class Leetcode_216 {
    List<List<Integer>> ans;
    List<Integer> list;
    public List<List<Integer>> combinationSum3(int k,int n) {
        ans = new ArrayList<>();
        list = new ArrayList<>();
        if (k < 0 || k > 27) return ans;
        dfs(k,n,1);
        return ans;
    }

    private void dfs(int k,int target,int begin) {
        if (target == 0 && list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        //剪枝
        if (list.size() + (9 - begin + 1) < k || list.size() > k) {
            return;
        }
        //选当前数
        if (target - begin >= 0) {
            list.add(begin);
            dfs(k,target-begin,begin+1);
            list.remove(list.size()-1);
        }
        //不选当前数
        dfs(k,target,begin+1);
    }

    private void backtrack(int k, int n, int start) {
        //剪枝
        if (list.size() + (9 - start + 1) < k || list.size() > k) {
            return;
        }
        if (list.size() == k) {
            if (n == 0) {
                ans.add(new ArrayList<>(list));
                return;
            }
        }
        for (int i = start; i <= 9; i++) {
            list.add(i);
            backtrack(k,n-i,i+1);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 9;
        //[[1,2,6], [1,3,5], [2,3,4]]
        Leetcode_216 leetcode_216 = new Leetcode_216();
        List<List<Integer>> ans = leetcode_216.combinationSum3(k,n);
        System.out.println("ans is " + ans);
    }
}
