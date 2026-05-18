package com.watercoldtoday.hot100.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombination {

    /**
     * 示例 1：
     *
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     *
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     *
     * @param digits
     * @return
     */
    public static final Map<Integer, String> DICT = new HashMap<>();
    public List<String> letterCombination(String digits) {
        DICT.put(2, "abc");
        DICT.put(3, "def");
        DICT.put(4, "ghi");
        DICT.put(5, "jkl");
        DICT.put(6, "mno");
        DICT.put(7, "pqrs");
        DICT.put(8, "tuv");
        DICT.put(9, "wxyz");
        List<String> ans = new ArrayList<>();
        dfs(ans, 0, digits, new StringBuilder());
        return ans;
    }

    private void dfs(List<String> ans, int idx, String digits, StringBuilder temp) {
        if (temp.length() == digits.length()) {
            ans.add(new String(temp));
            return;
        }
        int num = digits.charAt(idx) - '0';
        for (Character c : DICT.get(num).toCharArray()) {
            temp.append(c);
            dfs(ans,idx+1, digits, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombination letterCombination = new LetterCombination();
        System.out.println(letterCombination.letterCombination("23"));
        System.out.println(letterCombination.letterCombination("2"));
    }
}
