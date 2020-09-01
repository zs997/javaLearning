package cn.zs.practice.leetcode;

import cn.zs.commonStructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;
//中序遍历
public class LeetCode94BinaryTreeInorderTraversal {
    public static void main(String[] args) {

    }
    public ArrayList<Integer> inorderTraversal (TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
       if (root == null){
           return  res;
       }
       Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode temp = root.left;
        while (!stack.isEmpty() || temp != null){
           if (temp != null){
               stack.push(temp);
               temp = temp.left;
           }else {
               TreeNode pop = stack.pop();
               res.add(pop.val);
               temp = pop.right;

           }
        }

       return res;
    }
}
