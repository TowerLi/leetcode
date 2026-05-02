package com.watercoldtoday.interview.didi;

public class DiDI260430 {
    /**
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标
     * 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，
     * 如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
     * 输出：11
     * 解释：如下面简图所示：
     *    2
     *   3 4
     *  6 5 7
     * 4 1 8 3
     * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
     * 示例 2：
     *
     * 输入：triangle = [[-10]]
     * 输出：-10
     */

    public int getMinPathSum(int[][] triganle) {
        int m = triganle.length;
        for (int i = triganle.length - 2; i >= 0; --i) {
            for (int j = 0; j < triganle[i].length; ++j) {
                triganle[i][j] += Math.min(triganle[i+1][j], triganle[i+1][j+1]);
            }
        }
        return triganle[0][0];
    }

    public static void main(String[] args) {
        /**
         *  * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
         *      * 输出：11
         *      * 解释：如下面简图所示：
         *      *    2
         *      *   3 4
         *      *  6 5 7
         *      * 4 1 8 3
         *      * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
         *      * 示例 2：
         *      *
         *      * 输入：triangle = [[-10]]
         *      * 输出：-10
         */
        int[][] t1 = new int[][] {{2},{3,4}, {6,5,7}, {4,1,8,3}};
        int[][] t2 = new int[][] {{-10}};
        DiDI260430 diDI = new DiDI260430();
        System.out.println(diDI.getMinPathSum(t1));
        System.out.println(diDI.getMinPathSum(t2));
    }
}
