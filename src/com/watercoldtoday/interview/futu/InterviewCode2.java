package com.watercoldtoday.interview.futu;

import java.util.ArrayList;
import java.util.List;

// 2026-05-15
public class InterviewCode2 {

//    现在给出一堆发票，每张发票都有不同的面额，给出一个要报销的金额，
//    在发票中找出加起来总面额等于或者超过报销金额，且发票总面额尽可能最小的发票集合，
//    如果有多种集合只需要输出其中一种即可。每种面额的发票只有一张，每张发票只能使用一次。
//    输入【1,3,64,10】66       输出【3，64】

    int bestSum;

    public List<Integer> findInvoices(int[] invoices, int target) {
        bestSum = Integer.MAX_VALUE;
        List<Integer> ans = new ArrayList<>();
        dfs(invoices, ans, 0, target, 0, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] invoices, List<Integer> ans, int currentSum, int target,int idx,List<Integer> temp) {
        if (currentSum > bestSum) {
            return;
        }
        if (currentSum >= target) {
            if (currentSum < bestSum) {
                bestSum = currentSum;
                ans.clear();
                ans.addAll(temp);
            }
        }
        if (idx >= invoices.length) {
            return;
        }
        temp.add(invoices[idx]);
        dfs(invoices, ans, currentSum + invoices[idx], target, idx + 1, temp);
        temp.remove(temp.size()-1);
        dfs(invoices, ans, currentSum, target, idx + 1, temp);
    }

    public static void main(String[] args) {
        // 【1,3,64,10】66       输出【3，64】
        InterviewCode2 interviewCode2 = new InterviewCode2();
        System.out.println(interviewCode2.findInvoices(new int[] {1,3,64,10}, 66));
    }
}
