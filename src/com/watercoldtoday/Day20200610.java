package com.watercoldtoday;

import java.util.*;

public class Day20200610 {
    public static int[] solution(String s) {
        TreeNode root = Deserialize(s);
        List<Integer> ans = preorderTraversal(root);
        int[] res = ans.stream().mapToInt(Integer::valueOf).toArray();
        return res;
    }
    //先序遍历
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
            ans.add(cur.val);
        }

        return ans;
    }

    //层序遍历反序列化
    public static TreeNode Deserialize(String s) {
        TreeNode head = null;
        if (s == null || s.length() == 0) {
            return head;
        }
        String[] nodes = s.split(",");
        TreeNode[] treeNodes = new TreeNode[nodes.length];
        for (int i = 0; i < nodes.length; i++) {
            if (!"#".equals(nodes[i])) {
                treeNodes[i] = new TreeNode(Integer.valueOf(nodes[i].trim()));
            }
        }
        for (int i = 0,j = 1;j < treeNodes.length; i++) {
            if (treeNodes[i] != null) {
                treeNodes[i].left = treeNodes[j++];
                treeNodes[i].right = treeNodes[j++];
            }
        }
        return treeNodes[0];
    }

    public static void main(String[] args) {
        Day20200610 d10 = new Day20200610();
        String s = "1,2,3,4";
        int[] ans = d10.solution(s);
        Set<Integer> set = new HashSet<>();
        set.add(1);
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
