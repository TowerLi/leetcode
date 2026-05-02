package com.watercoldtoday.interview.didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2025-08-21
 * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表 intervals
 * ，其中 intervals[i] = [starti, endi] 表示第 i 个区间的开始和结束，
 * 并且 intervals 按照 starti 升序排列。
 * 同样给定一个区间 newInterval = [start, end] 表示另一个区间的开始和结束。
 *
 * 在 intervals 中插入区间 newInterval，使得 intervals
 * 依然按照 starti 升序排列，且区间之间不重叠（如果有必要的话，可以合并区间）。
 *
 * 返回插入之后的 intervals。
 *
 * 注意 你不需要原地修改 intervals。你可以创建一个新数组然后返回它。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * [1,2],[3,5],[4,8],[6,7],[8,10],[12,16]
 * 提示：
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals 根据 starti 按 升序 排列
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */
public class Test2 {

    public int[][] getNewInterval(int[][] intervals,int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int[][] in2 = new int[intervals.length + 1][2];
        int l = newInterval[0], r = newInterval[1];
        for (int i = 0; i < intervals.length; ++i) {
            int curL = intervals[i][0], curR = intervals[i][1];
            in2[i][0] = curL;
            in2[i][1] = curR;
        }
        in2[intervals.length][0] = l;
        in2[intervals.length][1] = r;

        Arrays.sort(in2, (a,b) -> a[0] -b[0]);
        for (int[] curinterval : in2) {
            int ll = curinterval[0];
            int rr = curinterval[1];
            if (list.size() == 0) {
                list.add(new int[]{ll, rr});
            }else {
                if (list.get(list.size() - 1)[1] >= ll) {
                    list.get(list.size() - 1)[1] = Math.max(rr,list.get(list.size() - 1)[1]);
                }else {
                    list.add(new int[]{ll, rr});
                }
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {
        Test2 test2 = new Test2();
        int[][] intervals = new int[2][2];
        intervals[0] = new int[]{1,3};
        intervals[1] = new int[]{6,9};
        System.out.println(Arrays.deepToString(test2
                .getNewInterval(intervals, new int[]{2, 5})));
        //  * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
        int[][] intervals2 = new int[5][2];
        intervals2[0] = new int[]{1,2};
        intervals2[1] = new int[]{3,5};
        intervals2[2] = new int[]{6,7};
        intervals2[3] = new int[]{8,10};
        intervals2[4] = new int[]{12,16};
        System.out.println(Arrays.deepToString(test2
                .getNewInterval(intervals2, new int[]{4, 8})));
    }
}
