package com.watercoldtoday;

public class Day20200813 {
    /**
     * 43. 字符串相乘
     * 给定两个以字符串形式表示的非负整数 num1 和 num2，
     * 返回 num1 和 num2 的乘积，
     * 它们的乘积也表示为字符串形式。
     *
     * 示例 1:
     *
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例 2:
     *
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     *
     * num1 和 num2 的长度小于110。
     * num1 和 num2 只包含数字 0-9。
     * num1 和 num2 均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int n1 = num1.length(), n2 = num2.length();
        String ans = "0";
        for (int i = n2 - 1; i >= 0; i--) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            for (int j = n2 - 1; j > i; j--) {
                sb.append("0");
            }
            int x = num2.charAt(i) - '0';
            for (int k = n1 - 1; k >= 0; k--) {
                int y = num1.charAt(k) - '0';
                int result = x * y + carry;
                sb.append(result % 10);
                carry = result / 10;
            }
            if (carry != 0) {
                sb.append(carry % 10);
            }
            ans = addTwoSum(ans,sb.reverse().toString());
        }
        return ans;
    }

    public String addTwoSum(String num1,String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int s1 = num1.length() - 1;
        int s2 = num2.length() - 1;
        while (s1 >= 0 || s2 >= 0 || carry > 0) {
            if (s1 >= 0) {
                carry += num1.charAt(s1) - '0';
                s1--;
            }
            if (s2 >= 0) {
                carry += num2.charAt(s2) - '0';
                s2--;
            }
            sb.append(carry % 10);
            carry = carry / 10;
        }
        return sb.reverse().toString();
    }
    public String multiplyy(String num1,String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        int n1 = num1.length(), n2 = num2.length();
        int[] ans = new int[n1+n2];
        for (int i = n1 - 1; i >=0 ;i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n2 -1; j >= 0 ;j--) {
                int y = num2.charAt(j) - '0';
                ans[i+j+1] += x * y;
            }
        }

        for (int i = n1 + n2 -1; i > 0; i--) {
            ans[i-1] += ans[i] / 10; //进位
            ans[i] = ans[i] % 10;
        }
        int index = 0;
        if (ans[0] == 0) index = 1;
        else index = 0;
        StringBuilder sb = new StringBuilder();
        while (index < n1 + n2) {
            sb.append(ans[index]);
            index++;
        }
        return sb.toString();
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helpSymmetric(root.left,root.right);
    }
    public boolean helpSymmetric(TreeNode left,TreeNode right) {
        if (left == null && right == null ) return true;
        return (left.val == right.val) && helpSymmetric(left.left,right.right)
                && helpSymmetric(left.right,right.left);
    }
    //中序[9,3,15,20,7] ，后序[9,15,7,20,3]；
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helpBuild(0,inorder.length-1,0,postorder.length,
                inorder,postorder);
    }
    public TreeNode helpBuild(int leftin,int rightin,int leftpost,int rightpost,
                              int[] inorder,int[] postorder) {
        if (leftin > rightin || leftpost > rightpost) return null;
        TreeNode root = new TreeNode(postorder[rightpost]);
        int index = leftin;
        while (index <= rightin && inorder[index] != postorder[rightpost]) index++;
        int leftNum = index - leftin;//左子树个数
        root.left = helpBuild(leftin,index-1,leftpost,leftpost+leftNum-1,inorder,postorder);
        root.right = helpBuild(index+1,rightin,leftpost+leftNum,rightpost-1,inorder,postorder);
        return root;
    }

    public static void main(String[] args) {
        Day20200813 d13 = new Day20200813();
        String num1 = "123";
        String num2 = "456";
        String ans;
        ans = d13.multiply(num1,num2);
        System.out.println("ans is : " + ans);
        ans = d13.multiplyy(num1,num2);
        System.out.println("ans is : " + ans);
    }
}
