package com.watercoldtoday;

/**
 * 347. 前 K 个高频元素
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
import java.util.*;
public class Leetcode_347 {
    /**
     * 求前N大，用小顶堆，求前N小，用大顶堆。
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums,int k) {
        Map<Integer,Integer> fremap = new HashMap<Integer,Integer>();
        for (int num : nums) {
            fremap.put(num,fremap.getOrDefault(num,0) + 1);
        }
        //int[] 第一个元素代表元素的值，第二个代表该值出现的次数
        //用最小堆保存频率最大的k个元素
        PriorityQueue<int[]> q = new PriorityQueue<int[] >(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for (Map.Entry<Integer,Integer> entry : fremap.entrySet()) {
            int num = entry.getKey(), cnt = entry.getValue();
            if (q.size() == k) {
                if (q.peek()[1] < cnt) {
                    q.poll();
                    q.offer(new int[]{num,cnt});
                }
            }else {
                q.offer(new int[]{num,cnt});
            }
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = q.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        Leetcode_347 leetcode_347 = new Leetcode_347();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] ans = leetcode_347.topKFrequent(nums,k);
        System.out.println("ans is : " + Arrays.toString(ans));
    }

}
