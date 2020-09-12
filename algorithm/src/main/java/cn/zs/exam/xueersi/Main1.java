package cn.zs.exam.xueersi;

import cn.zs.commonStructure.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Main1 {
    public String notReCuPreOrder (TreeNode root) {
        // write code here
        if(root == null){
            return "";
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        StringBuilder sb  = new StringBuilder();
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            sb.append(temp.val+",");
            if(temp.right != null){
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
        String substring = sb.substring(0, sb.length() - 1);
        return  substring;
    }
}
