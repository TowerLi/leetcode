package com.watercoldtoday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Day20200806 {
    String x = "";
    //找回文对个数
    class Node {
        int[] ch = new int[26];
        int flag;
        public Node() {
            flag = -1;
        }
    }
    List<Node> tree = new ArrayList<Node>();

    public List<List<Integer>> palindromePairs(String[] words) {
        tree.add(new Node());
        int n = words.length;
        for (int i = 0; i < n; i++) {
            insert(words[i],i);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            int m = words[i].length();
            for (int j = 0; j <= m; j++) {
                if(isPalindrome(words[i],j,m-1)) {
                    int leftId = findwords(words[i],0,j-1);
                    if (leftId != -1 && leftId != i) {
                        ans.add(Arrays.asList(i,leftId));
                    }
                }
                if (j != 0 && isPalindrome(words[i],0,j-1)) {
                    int rightId = findwords(words[i],j,m-1);
                    if (rightId != -1 && rightId != i) {
                        ans.add(Arrays.asList(rightId,i));
                    }
                }
            }
        }
        return ans;
    }

    public void insert(String s, int id) {
        int len = s.length(), add = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                tree.add(new Node());
                tree.get(add).ch[x] = tree.size() - 1;
            }
            add = tree.get(add).ch[x];
        }
        tree.get(add).flag = id;
    }

    public boolean isPalindrome(String s,int left,int right) {
        int len = right - left + 1;
        for (int i = 0; i < len /2; i++) {
            if (s.charAt(left+i) != s.charAt(right-i)) {
                return false;
            }
        }
        return true;
    }

    public int findwords(String s, int left,int right ) {
        int add = 0;
        for (int i = right; i >= left; i--) {
            int x = s.charAt(i) - 'a';
            if (tree.get(add).ch[x] == 0) {
                return -1;
            }
            add = tree.get(add).ch[x];
        }
        return tree.get(add).flag;
    }

    public static void main(String[] args) throws InterruptedException {

        
    }
}
