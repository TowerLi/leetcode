package com.watercoldtoday;

import java.io.UnsupportedEncodingException;

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

    public static void main(String[] args) throws UnsupportedEncodingException {
        Leetcode_38 leetcode_38 = new Leetcode_38();
       // System.out.println("ans3 is " + leetcode_38.countAndSay(3));
       // System.out.println("ans4 is " + leetcode_38.countAndSay(4));
       // System.out.println("ans5 is " + leetcode_38.countAndSay(5));
        //System.out.println("ans6 is " + leetcode_38.countAndSay(7));
        String url = java.net.URLDecoder.decode("https://51daijiao.cn/iszweb/informationCheck?obj=%7B%22namCustCorp%22%3A%22%E5%8F%A5%E5%AE%B9%E5%B8%82%E6%B6%A6%E6%A1%90%E9%80%9A%E8%AE%AF%E7%94%B5%E5%AD%90%E8%AE%BE%E5%A4%87%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8%22,%22usci%22%3A%2292440300MA5GCDKX97%22,%22namLp%22%3A%22%E5%BC%A0%E4%B8%89%22,%22cerno%22%3A%22410222197601236041%22,%22namOper%22%3A%22%E9%BB%8E%E7%BB%A7%E6%B5%A9%22,%22numMob%22%3A%2215211122211%22,%22outlet%22%3A%22410079%22,%22networkName%22%3A%22%E6%B7%B1%E5%9C%B3%E9%95%BF%E5%9F%8E%E6%94%AF%E8%A1%8C%22%7D","UTF-8");
        System.out.println("url is : " + url);

        String url2 = java.net.URLDecoder.decode("https://51daijiao.cn/iszweb/success?info=%7B%22namCustCorp%22%3A%22%E5%8F%A5%E5%AE%B9%E5%B8%82%E6%B6%A6%E6%A1%90%E9%80%9A%E8%AE%AF%E7%94%B5%E5%AD%90%E8%AE%BE%E5%A4%87%E6%9C%89%E9%99%90%E5%85%AC%E5%8F%B8%22,%22usci%22%3A%2292440300MA5GCDKX97%22,%22bankNo%22%3A%224100800003000123%22,%22networkRemark%22%3A%22%E4%B8%AD%E5%9B%BD%E5%86%9C%E4%B8%9A%E9%93%B6%E8%A1%8C%E6%B7%B1%E5%9C%B3%E9%95%BF%E5%9F%8E%E6%94%AF%E8%A1%8C%E5%9C%B0%E5%9D%80%EF%BC%9A%E6%B7%B1%E5%9C%B3%E5%B8%82%E7%A6%8F%E7%94%B0%E5%8C%BA%E7%99%BD%E6%B2%99%E5%B2%AD%E7%99%BE%E8%8A%B1%E4%BA%8C%E8%B7%AF%E7%99%BE%E8%8A%B1%E5%85%AC%E5%AF%93%E4%B8%80%E6%A5%BC%EF%BC%8C%E8%81%94%E7%B3%BB%E7%94%B5%E8%AF%9D%EF%BC%9A0755-36682815%22%7D","UTF-8");
        System.out.println("url2 is : " + url2);
    }
}
