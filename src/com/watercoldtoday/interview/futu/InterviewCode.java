package com.watercoldtoday.interview.futu;

public class InterviewCode {

    /** 压缩字符串
     * 给你一个字符数组 chars ，请使用下述算法压缩：
     * 从一个空字符串 s 开始。对于 chars 中的每组 连续重复字符 ：
     * 如果这一组长度为 1 ，则将字符追加到 s 中。
     * 否则，需要向 s 追加字符，后跟这一组的长度。
     * 压缩后得到的字符串 s 不应该直接返回 ，需要转储到字符数组 chars 中。需要注意的是，如果组长度为 10 或 10 以上，则在 chars 数组中会被拆分为多个字符。
     * 请在 修改完输入数组后 ，返回该数组的新长度。
     * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
     * 注意：数组中超出返回长度的字符无关紧要，应予忽略。
     */
    public int compress(char[] chars) {
        //输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
        //输出：4
        //解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 “b12” 替代。
        int l = 0, r = 0, n = chars.length;
        while (r < n) {
            char currentChar = chars[r];
            int cnt = 0;
            while (r < n && currentChar == chars[r]) {
                r++;
                cnt ++;
            }
            chars[l++] = currentChar;
            if (cnt > 1) {
                for (char c : Integer.toString(cnt).toCharArray()) {
                    chars[l++] = c;
                }
            }
        }
        System.out.println(chars);
        return l;
    }

    public static void main(String[] args) {
        InterviewCode interviewCode = new InterviewCode();
        System.out.println(interviewCode.compress(new char[] {'a','a','b','b','c','c','c'}));
        System.out.println(interviewCode.compress(new char[] {'a'}));
        System.out.println(interviewCode.compress(new char[] {'a','b','b','b','b','b','b','b','b','b','b','b','b'}));
    }

}
