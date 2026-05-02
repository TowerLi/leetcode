package com.watercoldtoday.interview;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 某餐馆有n张桌子，每张桌子有一个参数：a 可容纳的最大人数；
 * 有m批客人，每批客人有两个参数:b人数，c预计消费金额。
 * 在不允许拼桌的情况下，请实现一个算法选择其中一部分客人，使得总预计消费金额最大
 *
 * 输入描述:
 * 输入包括m+2行。
 * 第一行两个整数n(1 <= n <= 50000),m(1 <= m <= 50000)
 * 第二行为n个参数a,即每个桌子可容纳的最大人数,以空格分隔,范围均在32位int范围内。
 * 接下来m行，每行两个参数b,c。分别表示第i批客人的人数和预计消费金额,以空格分隔,范围均在32位int范围内。
 * 输出描述:
 * 输出一个整数,表示最大的总预计消费金额
 * 示例1
 * 输入
 * 3 5
 * 2 4 2
 * 1 3
 * 3 5
 * 3 7
 * 5 9
 * 1 10
 * 输出
 * 20
 */
public class CMBWingLung {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 读取 n 和 m
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        int m = sc.nextInt();

        // 2. 使用 TreeMap 存储桌子容量及其数量
        // Key: 桌子容量, Value: 该容量桌子的个数
        TreeMap<Integer, Integer> tableMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int capacity = sc.nextInt();
            tableMap.put(capacity, tableMap.getOrDefault(capacity, 0) + 1);
        }

        // 3. 读取客人信息并存储在二维数组中
        // guests[i][0] 是人数, guests[i][1] 是消费金额
        int[][] guests = new int[m][2];
        for (int i = 0; i < m; i++) {
            guests[i][0] = sc.nextInt(); // 人数
            guests[i][1] = sc.nextInt(); // 消费
        }

        // 4. 按消费金额降序排序，如果金额相同，按人数升序排序
        Arrays.sort(guests, (a, b) -> {
            if (b[1] != a[1]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        long totalMoney = 0; // 结果可能超过 int 范围

        // 5. 贪心匹配
        for (int i = 0; i < m; i++) {
            int personCount = guests[i][0];
            int money = guests[i][1];

            // 寻找大于等于 personCount 的最小桌子容量
            Integer suitableCapacity = tableMap.ceilingKey(personCount);

            if (suitableCapacity != null) {
                totalMoney += money;
                // 更新桌子数量，如果该容量桌子用完了，从 map 中移除
                int count = tableMap.get(suitableCapacity);
                if (count == 1) {
                    tableMap.remove(suitableCapacity);
                } else {
                    tableMap.put(suitableCapacity, count - 1);
                }
            }

            // 如果所有桌子都分配完了，提前结束
            if (tableMap.isEmpty()) break;
        }

        System.out.println(totalMoney);
    }
}