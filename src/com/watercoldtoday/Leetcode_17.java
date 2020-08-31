package com.watercoldtoday;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Leetcode_17 {
    String[] phonemap = {"","","abc","def","ghi","jkl","mno","pgrs","tuv","wxyz"};
    List<String> ans = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || "".equals(digits)) return ans;
        backtrack(digits,0,"");
        return ans;
    }
    public void backtrack(String digits,int index,String cur) {
                 if (index == digits.length()) {
            ans.add(cur);
            return;
        }else {
            char c = digits.charAt(index);
            String map_string = phonemap[c-'0'];
            for (int i = 0; i < map_string.length(); i++) {
                backtrack(digits,index+1,cur+map_string.charAt(i));
            }
        }
    }

    public static void main(String[] args) {
        Leetcode_17 l17 = new Leetcode_17();
        String digits = "234";
        List<String> ans = l17.letterCombinations(digits);
        System.out.println(ans.toString());
    }
}
