package com.watercoldtoday;

/**
 * 预测赢家
 * https://leetcode-cn.com/problems/predict-the-winner/solution/
 */
public class Leetcode_486 {
    public boolean PredictTheWinner(int[] nums) {
        return dfs(nums,0,nums.length-1,0,0,true);
        //return dfs(nums,0,nums.length-1) >= 0;
    }
    private int dfs(int[] nums,int i, int j) {
        if (i == j) return nums[i];
        int pick1 = nums[i] - dfs(nums,i+1,j);
        int pick2 = nums[j] - dfs(nums,i,j-1);
        return Math.max(pick1,pick2);
    }

    private boolean dfs(int[] nums,int left,int right,int sumA,int sumB,boolean isA) {
        if (left > right) return sumA >= sumB;
        // 玩家A总会挑最优，所以为或，B不会，所以为且
        if(isA) return dfs(nums,left+1,right,sumA+nums[left],sumB,false)
                    || dfs(nums,left,right-1,sumA+nums[right],sumB,false);
        return dfs(nums,left+1,right,sumA,sumB+nums[left],true)
                && dfs(nums,left,right-1,sumA,sumB+nums[right],true);
    }

    public boolean PredictW(int[] nums) {
        int n = nums.length;
        //dp[i][j]代表i到j范围内，玩家1与玩家2的分数差
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        //自底向上开始DP
        for (int i = n-2; i >=0; --i) {
            for (int j = i +1; j < n; ++j) {
                dp[i][j] = Math.max(nums[i] - dp[i+1][j],nums[j]-dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }

    public static void main(String[] args) {
        Leetcode_486 leetcode_486 = new Leetcode_486();
        int[] nums = {1, 5, 233, 7};
        System.out.println("result is " + leetcode_486.PredictTheWinner(nums));
        System.out.println("result is " + leetcode_486.PredictW(nums));
        System.out.println("====== another test ======");
        nums = new int[]{1, 5, 2};
        System.out.println("result is " + leetcode_486.PredictTheWinner(nums));
        System.out.println("result is " + leetcode_486.PredictW(nums));
    }
}
