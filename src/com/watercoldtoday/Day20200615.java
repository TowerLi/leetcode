package com.watercoldtoday;

import java.util.*;

public class Day20200615 {
    /**
     *  最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     *
     * 示例 1：
     *
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     *
     * 输入: "cbbd"
     * 输出: "bb"
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = s.length() - 1;
        while (i != s.length() / 2) {
            if (s.charAt(i) == s.charAt(j)) {
                sb.append(s.charAt(i));
            }else {
                j--;
            }
            i++;
        }
        return sb.toString();

    }

    /**
     * 暴力遍历法
     * 时间复杂度：O(N^3)O(N
     * 3
     *  )，这里 NN 是字符串的长度，枚举字符串的左边界、右边界，然后继续验证子串是否是回文子串，这三种操作都与 NN 相关；
     * 空间复杂度：O(1)O(1)，只使用到常数个临时变量，与字符串长度无关。
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        //s.charAt()每次都会检查数组下标是否越界，因此转换成字符数组。
        char[] charArray = s.toCharArray();
        //枚举所有长度大于1的子串
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > maxLen && vaildPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    /**
     * 验证是否为回文串
     * @param charArray
     * @param left
     * @param right
     * @return
     */
    public boolean vaildPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 动态规划算法，dp[i][j]表示s[i,j]是否为回文串
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;

        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();
        //初始化
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j;i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - 1 - (i + 1) + 1 < 2) {
                        //当s[i+1,j-1]长度小于2，即j-i + 1< 3时，若j - i + 1= 3,那么 子串只有一个字符一定为回文串
                        // j - i + 1 = 2，子串为空串一定为回文串
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if (dp[i][j] == true && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        Day20200615 d15 = new Day20200615();
        String s = "babad";
        String ans = d15.longestPalindrome1(s);
        System.out.println("ans is " + ans);
        s = "cbbd";
        ans = d15.longestPalindrome1(s);
        System.out.println("ans is " + ans);
        s = "babad";
        ans = d15.longestPalindrome2(s);
        System.out.println("ans is " + ans);

        //遍历哈希表
        Map map = new HashMap<>();

        Collection c = map.values();
        Iterator iterator = c.iterator();
        while (iterator.hasNext()) {
            Object value = iterator.next();
        }

        iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            Object key = entry.getKey();
        }

        Set keySet = map.keySet();
        iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key = iterator.next();
            Object value = map.get(key);
        }

        //Method1 ,在for-each循环中使用entries来遍历
        Map<Integer,Integer> hmap = new HashMap<Integer, Integer>();
        hmap.put(1,1);
        hmap.put(2,90);
        hmap.put(3,111);
        hmap.put(4,1212);
        for (Map.Entry<Integer,Integer>entry : hmap.entrySet() ) {
            System.out.println("Key = " + entry.getKey() + ",Value = " + entry.getValue());
        }

        String str = Integer.toString(100,16);
        System.out.println("str:" + str);
        Queue<Integer> priorityqueue = new PriorityQueue<Integer>((a,b)->b-a);
        priorityqueue.offer(1);
        priorityqueue.offer(88);
        priorityqueue.offer(7);
        priorityqueue.offer(4);
        priorityqueue.offer(9);
        int i = 0;
        while (priorityqueue.isEmpty() == false) {
            System.out.println("priority number " + i +" = " +priorityqueue.poll());
            i++;
        }
        List<Integer> arraylist = new ArrayList<>();
        arraylist.add(1);
    }
}
