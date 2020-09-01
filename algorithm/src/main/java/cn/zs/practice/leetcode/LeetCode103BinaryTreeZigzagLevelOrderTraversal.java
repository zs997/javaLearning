package cn.zs.practice.leetcode;

import cn.zs.commonStructure.TreeNode;

import java.util.*;

public class LeetCode103BinaryTreeZigzagLevelOrderTraversal {
    public static void main(String[] args) {

    }
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
//      Queue<TreeNode> queue = new ArrayDeque<>();
        ArrayList<TreeNode> queue = new ArrayList<>();

        if (root == null)
            return ans;
        queue.add(root);
        //层数
        int num = 1;
        while (!queue.isEmpty()){
            int n = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode remove = queue.remove(0);
                temp.add(remove.val);
                if (remove.left != null){
                    queue.add(remove.left);
                }
                if (remove.right != null){
                    queue.add(remove.right);
                }
            }
            if (num %2 ==0){
                // num&1 != 1
                Collections.reverse(temp);
            }
            ans.add(temp);
            num++;
        }

        return ans;
    }
}
