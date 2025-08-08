package com.watercoldtoday;


import java.util.Stack;

public class Day20200618 {

    /**
     * 1028. 从先序遍历还原二叉树
     * 我们从二叉树的根节点 root 开始进行深度优先搜索。
     *
     * 在遍历中的每个节点处，我们输出 D 条短划线（其中 D 是该节点的深度），然后输出该节点的值。
     * （如果节点的深度为 D，则其直接子节点的深度为 D + 1。根节点的深度为 0）。
     *
     * 如果节点只有一个子节点，那么保证该子节点为左子节点。
     *
     * 给出遍历输出 S，还原树并返回其根节点 root。
     * @param S
     * @return
     */
    public TreeNode recoverFromPreorder(String S) {
        Stack<TreeNode> s = new Stack<>();
        int i = 0;
        while (i < S.length()) {
            int level = 0;
            while (S.charAt(i) == '-') {
                level++;
                i++;
            }
            int num = 0;
            //拿到节点的数值
            while (i < S.length() && S.charAt(i) != '-') {
                char c = S.charAt(i);
                num = Character.getNumericValue(c);
                i++;
            }
            while (s.size() > level) {
                s.pop();
            }
            TreeNode n = new TreeNode(num);
            if (!s.isEmpty()) {
                TreeNode curNode = s.peek();
                if (s.peek().left != null) {
                    s.peek().left = n;
                }else {
                    s.peek().right = n;
                }
            }
            s.push(n);
        }
        while (s.size() > 1) {
            s.pop();
        }
        return s.pop();
    }

}
