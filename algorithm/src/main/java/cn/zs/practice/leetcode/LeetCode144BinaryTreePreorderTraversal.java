package cn.zs.practice.leetcode;



import cn.zs.commonStructure.TreeNode;
/*
*   先序遍历二叉树
* */

import java.util.ArrayList;
import java.util.Stack;

public class LeetCode144BinaryTreePreorderTraversal {
    public static void main(String[] args) {

    }

    public  static ArrayList<Integer> res = new ArrayList<>();
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        preOrder(root);
        return res;
    }
    public static void preOrder (TreeNode root){
        if(root == null){
            return;
        }else{
            res.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }
    public ArrayList<Integer> preorderTraversal1(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            res.add(temp.val);
            if(temp.right != null){
                s.push(temp.right);
            }
            if(temp.left != null){
                s.push(temp.left);
            }
        }
        return res;
    }

}
