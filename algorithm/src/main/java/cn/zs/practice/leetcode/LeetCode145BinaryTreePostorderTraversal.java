package cn.zs.practice.leetcode;

import cn.zs.commonStructure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class LeetCode145BinaryTreePostorderTraversal {
    ArrayList<Integer> recurveList = new ArrayList<>();
    //方法1 递归
    public ArrayList<Integer> postorderTraversal1 (TreeNode root) {
        // write code here
        postorderTraversalHelper(root);
        return recurveList;
    }
    public void postorderTraversalHelper(TreeNode root){
        if(root == null){
            return;
        }
        postorderTraversalHelper(root.left);
        postorderTraversalHelper(root.right);
        recurveList.add(root.val);
    }

    //方法 2 后序遍历 左右根  反之 根右左  猜想  根右左 逆序？
    public ArrayList<Integer> postorderTraversal (TreeNode root) {
        // write code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            res.add(0,pop.val);
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);
        }
       // Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {

    }
}
