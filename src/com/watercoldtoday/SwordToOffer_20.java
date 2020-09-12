package com.watercoldtoday;

public class SwordToOffer_20 {
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) return false;
        s = s.trim();
        if (s == null || s.length() == 0) return false;
        //if (!Character.isDigit(s.charAt(s.length()-1))) return false;
        int pointcnt = 0;
        int ecnt = 0;
        int numcnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                numcnt++;
            }
            if (s.charAt(i) == '.') {
                pointcnt++;
                //if (i == 0) continue;
                //小数点不能最后一位
                //if (i == s.length()-1) return false;
            }
            //小数点多于两位,或者两个字母以上
            if (pointcnt > 1 || ecnt > 1) return false;
            //如果是字母
            if (Character.isLowerCase(s.charAt(i)) || Character.isUpperCase(s.charAt(i))) {
                //如果不是e，返回假
                if (s.charAt(i) != 'e' || s.charAt(i) != 'E') {
                    return false;
                } else {
                    ecnt++;
                    if (i == 0 || i == s.length() - 1) return false;
                }
            }
            //如果是符号
            if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (s.charAt(i) == '+') {
                    //不是第一个
                    if (i != 0) return false;
                    else continue;
                }
                if (s.charAt(i) == '-') {
                    if (i != 0 || s.charAt(i - 1) != 'E' || s.charAt(i - 1) != 'e') return false;
                    else continue;
                }
            }
        }
        return numcnt > 0;
    }

    public static void main(String[] args) {
        SwordToOffer_20 s20 = new SwordToOffer_20();
        String s = "2e0";
        System.out.println("ans is " + s20.isNumber(s));
    }
}
