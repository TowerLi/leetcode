package com.watercoldtoday.hot100.dfs;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs(ans,n,n, new StringBuilder());
        return ans;
    }

    private void dfs(List<String> ans, int left,int right, StringBuilder sb) {
        if (left == 0 && right == 0) {
            ans.add(new String(sb));
        }

        if (left > 0) {
            sb.append("(");
            dfs(ans,left-1, right, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if (left < right) {
            sb.append(")");
            dfs(ans,left, right-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        Parenthesis parenthesis = new Parenthesis();
        System.out.println(parenthesis.generateParenthesis(3));
        System.out.println(parenthesis.generateParenthesis(4));
    }
}
