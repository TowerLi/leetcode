package com.watercoldtoday.interview.bytedance;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GreaterIntegerNotExceedingN {

    public int getGreatestIntegerNotExceedingN(String[] digits, int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int len = chars.length;
        char[] res = new char[len];
        if (dfs(digits, chars, res, 0)) {
            return Integer.parseInt(new String(res));
        }

        if (len > 1) {
            char[] shortAns = new char[len-1];
            Arrays.fill(shortAns, digits[digits.length - 1].charAt(0));
            return Integer.parseInt(new String(shortAns));
        }

        return 0;
    }

    private boolean dfs(String[] digits, char[] chars, char[] res, int idx) {
        if (idx == chars.length) {
            return true;
        }
        char target = chars[idx];
        for (int i = digits.length - 1; i >= 0; --i) {
            char cur = digits[i].charAt(0);
            if (cur == target) {
                res[idx] = cur;
                if (dfs(digits,chars,res, idx+1)) {
                    return true;
                }
            }else if (cur < target) {
                res[idx] = cur;
                for (int j = idx + 1; j < chars.length; ++j) {
                    res[j] = digits[digits.length - 1].charAt(0);
                }
                return true;
            }
        }

        return false;
    }

    public int getGreaterN(String[] digits, int n) {
        char[] s = String.valueOf(n).toCharArray();
        StringBuilder res = new StringBuilder();
        int len = s.length;
        if (dfs(digits, s, 0, res)) {
            return Integer.parseInt(res.toString());
        }
        if (len > 1) {
            res.setLength(0);
            char maxDigit = digits[digits.length-1].charAt(0);
            for (int i = 0; i < len - 1; ++i) {
                res.append(maxDigit);
            }
            return Integer.parseInt(res.toString());
        }
        return 0;
    }

    private boolean dfs(String[] digits, char[] s, int idx, StringBuilder res) {
        if (idx == s.length) {
            return true;
        }
        char target = s[idx];
        char maxDigit = digits[digits.length-1].charAt(0);

        for (int i = digits.length-1; i >= 0; --i) {
            char cur = digits[i].charAt(0);
            if (cur == target) {
                res.append(cur);
                if (dfs(digits, s, idx+1, res)) {
                    return true;
                }
                res.setLength(idx);
            }else if (cur < target) {
                res.append(cur);
                while (res.length() < s.length) {
                    res.append(maxDigit);
                }
                return true;
            }
        }
        return false;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {
        Queue<Long> queue = new LinkedList<>();
        // 先把所有单个卡片放进队列
        for (String d : digits) {
            queue.add(Long.parseLong(d));
        }

        long lastValid = 0; // 记录上一个合法的（<=n）最大值

        while (!queue.isEmpty()) {
            long curr = queue.poll();

            if (curr <= n) {
                lastValid = curr; // 更新最大合法值

                // 核心：在当前数字后面，尝试拼上 digits 里的每一张卡片
                // 比如 7 变成 71, 73, 75, 77
                for (String d : digits) {
                    queue.add(curr * 10 + Integer.parseInt(d));
                }
            } else {
                // 因为队列是先入先出、从小到大的，一旦curr超过了n
                // 说明后面新生成的数只会更大，直接结束循环
                break;
            }
        }

        return (int) lastValid;
    }

    public static void main(String[] args) {
        GreaterIntegerNotExceedingN gn = new GreaterIntegerNotExceedingN();
        String[] s1 = {"1", "3", "5", "7"};
        System.out.println(gn.getGreatestIntegerNotExceedingN(s1,2313));
        System.out.println(gn.getGreatestIntegerNotExceedingN(s1,1798));
        String[] s2 = {"2", "4", "9"};
        System.out.println(gn.getGreatestIntegerNotExceedingN(s2, 23121));
        String[] s3 = {"5", "7", "9"};
        System.out.println(gn.getGreatestIntegerNotExceedingN(s3, 4321));
        String[] s4 = {"2", "3", "9"};
        System.out.println(gn.getGreatestIntegerNotExceedingN(s4, 2321));
        System.out.println(gn.getGreatestIntegerNotExceedingN(s4, 23321));

        System.out.println(gn.atMostNGivenDigitSet(s4, 2321));
        System.out.println(gn.atMostNGivenDigitSet(s4, 23321));

        System.out.println(gn.getGreaterN(s4, 2321));
        System.out.println(gn.getGreaterN(s4, 23321));
    }


}
