package com.watercoldtoday;

/**
 * 257. 二叉树的所有路径
 * https://leetcode-cn.com/problems/binary-tree-paths/
 */
import java.util.*;
public class Leetcode_257 {

    /**
     * Definition for a binary tree node.
     */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        //BFS
        List<String> ans = new ArrayList<String>();
        if (root == null) return ans;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<String> path = new LinkedList<>();
        nodeQueue.offer(root);
        path.offer(root.val + "");

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            String curpath = path.poll();
            if (node.left == null && node.right == null) {
                ans.add(curpath);
            }
            if (node.left != null) {
                nodeQueue.offer(node.left);
                path.offer(curpath + "->" + node.left.val);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                path.offer(curpath + "->" + node.right.val);
            }
        }
        return ans;
    }
    //DFS
    List<String> ans;
    public List<String> binaryTreePaths2(TreeNode root) {
        this.ans = new ArrayList<>();
        if (root == null) return ans;
        dfs(root,"");
        dfs2(root,new StringBuffer());
        return ans;
    }
    private void dfs(TreeNode root,String path) {
        path += root.val;
        if (root.right == null && root.left ==null) {
            ans.add(path);
            return;
        }
        if (root.left != null) {
            dfs(root.left,path + "->");
        }
        if (root.right != null) {
            dfs(root.right,path + "->");
        }
    }
    //StringBuffer
    private void dfs2(TreeNode root,StringBuffer sb) {
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
            return;
        }
        if (root.left != null) {
            dfs2(root.left,new StringBuffer(sb).append("->"));
        }
        if (root.right != null) {
            dfs2(root.right,new StringBuffer(sb).append("->"));
        }
    }
}
