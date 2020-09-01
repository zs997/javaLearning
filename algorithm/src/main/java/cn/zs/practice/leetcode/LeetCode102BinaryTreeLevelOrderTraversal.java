package cn.zs.practice.leetcode;

import cn.zs.commonStructure.TreeNode;

import java.util.ArrayList;

//二叉树层序遍历
public class LeetCode102BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        ArrayList<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove(0);
                temp.add(remove.val);
                if (remove.left != null){
                    queue.add(remove.left);
                }
                if (remove.right != null){
                    queue.add(remove.right);
                }
            }
            res.add(temp);
        }
        return  res;
    }
}
