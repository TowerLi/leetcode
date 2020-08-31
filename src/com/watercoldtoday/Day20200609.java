package com.watercoldtoday;


import java.util.Stack;

public class Day20200609 {
    /**
     * 746. 使用最小花费爬楼梯
     * 数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。
     *
     * 每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。
     *
     * 您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。
     *
     * 示例 1:
     *
     * 输入: cost = [10, 15, 20]
     * 输出: 15
     * 解释: 最低花费是从cost[1]开始，然后走两步即可到阶梯顶，一共花费15。
     *  示例 2:
     *
     * 输入: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * 输出: 6
     * 解释: 最低花费方式是从cost[0]开始，逐个经过那些1，跳过cost[3]，一共花费6。
     * 注意：
     *
     * cost 的长度将会在 [2, 1000]。
     * 每一个 cost[i] 将会是一个Integer类型，范围为 [0, 999]。
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        //从前往后推
        //求出 f(cost.length+1)
        // f[i] = cost[i] + min(f[i-1],f[i-2])
        int cost1 = 0,cost2 = 0;
        for (int i = 0;i < cost.length;i++) {
            int cur = cost[i] + Math.min(cost1,cost2);
            cost1 = cost2;
            cost2 = cur;
        }
        return Math.min(cost1,cost2);
    }


    /**
     * 面试题46. 把数字翻译成字符串
     * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
     *
     *
     *
     * 示例 1:
     *
     * 输入: 12258
     * 输出: 5
     * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
     * 提示：
     *
     * 0 <= num < 231
     * @param num
     * @return
     */
    public int translateNum(int num) {
        //青蛙跳楼梯的变种
        //若能直接翻译numi-2numi-1 dp[i] = dp[i-1]+dp[i-2]
        //若不能直接翻译numi-2numi-1 dp [i] = dp[i-1]
        /**
         *
         * const translateNum = (num) => {
         *   const str = num.toString()
         *   const n = str.length
         *   const dp = new Array(n + 1)
         *   dp[0] = 1
         *   dp[1] = 1
         *   for (let i = 2; i < n + 1; i++) {
         *     const temp = Number(str[i - 2] + str[i - 1])
         *     if (temp >= 10 && temp <= 25) {
         *       dp[i] = dp[i - 1] + dp[i - 2]
         *     } else {
         *       dp[i] = dp[i - 1]
         *     }
         *   }
         *   return dp[n] // 翻译前n个数的方法数，即整个数字
         * }
         *
         * 作者：hyj8
         * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/shou-hui-tu-jie-dfsdi-gui-ji-yi-hua-di-gui-dong-ta/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         *
         * const translateNum = (num) => {
         *   const str = num.toString()
         *   const n = str.length
         *   let prev = 1
         *   let cur = 1
         *   for (let i = 2; i < n + 1; i++) {
         *     const temp = Number(str[i - 2] + str[i - 1])
         *     if (temp >= 10 && temp <= 25) {
         *       const t = cur // 缓存上个状态
         *       cur = prev + cur // 当前状态=上上个状态+上个状态
         *       prev = t // 更新上上个状态
         *     } else {
         *       // cur = cur
         *       prev = cur // 更新上上个状态
         *     }
         *   }
         *   return cur
         * }
         *
         * 作者：hyj8
         * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/shou-hui-tu-jie-dfsdi-gui-ji-yi-hua-di-gui-dong-ta/
         * 来源：力扣（LeetCode）
         * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
         */
        String str = String.valueOf(num);
        int n = str.length();
        //代表前N个数字可以翻译成的字符串个数
        int[] dp = new int[n+1];
        // 对于数字23， 前1 dp[1] = 1,dp[2] = 2,所以 dp[0] = 1;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2;i < n + 1; i++) {
            //i-2,i-1 两个数字
            String temp = str.substring(i-2,i);
            if (temp.compareTo("25") <= 0 && temp.compareTo("10") >= 0) {
                dp[i] = dp[i-1] + dp[i-2];
            }else {
                dp[i] = dp[i-1];
            }
        }
        return dp[n];
    }

    public int translateNum2(int num) {
        String str = String.valueOf(num);
        int n = str.length();
        int prev = 1;
        int curr = 1;
        for (int i = 2;i < n + 1; i++) {
            String temp = str.substring(i-2,i);
            if (temp.compareTo("25") <= 0 && temp.compareTo("10") >= 0) {
                int t = curr;   //缓存上一个状态
                curr = prev + curr; //当前状态= 上个状态 + 上上个状态
                prev = t;       //更新上上个状态
            }else {
                prev = curr;    //更新上上个状态
            }
        }
        return curr;
    }


    public static void main(String[] args) {
        Day20200609 d9 = new Day20200609();
        int[] cost = {10,15,20};
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int ans = d9.minCostClimbingStairs(cost2);
        System.out.println("ans is :");
        System.out.println(ans);
        int num = 12256;
        ans = d9.translateNum(num);
        System.out.println("ans is :");
        System.out.println(ans);
        ans = d9.translateNum2(num);
        System.out.println("ans is :");
        System.out.println(ans);
        Stack stack = new Stack();
        String s = "([]){}";

    }
}
