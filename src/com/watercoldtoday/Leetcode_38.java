package com.watercoldtoday;

/**
 * 38 Count and Say
 * https://leetcode-cn.com/problems/count-and-say/
 */
public class Leetcode_38 {
    /**
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 6.	   312211
     * 7.	   13112221
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) return "1";
        if (n == 2) return "11";
        StringBuilder sb = new StringBuilder("11");
        for (int i = 3; i <= n; ++i) {
            StringBuilder tmp = new StringBuilder(sb);
            sb.delete(0,sb.length());
            for (int j = 1,cnt = 1; j < tmp.length(); ++j) {
                if (tmp.charAt(j) == tmp.charAt(j-1)) {
                    cnt++;
                }else {
                    sb.append(cnt);
                    sb.append(tmp.charAt(j-1));
                    cnt = 1;
                }
                if (j == tmp.length()-1) {
                    sb.append(cnt);
                    sb.append(tmp.charAt(j));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Leetcode_38 leetcode_38 = new Leetcode_38();
       // System.out.println("ans3 is " + leetcode_38.countAndSay(3));
       // System.out.println("ans4 is " + leetcode_38.countAndSay(4));
       // System.out.println("ans5 is " + leetcode_38.countAndSay(5));
        System.out.println("ans6 is " + leetcode_38.countAndSay(7));
    }
}
