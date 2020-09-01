package cn.zs.practice.leetcode;

import cn.zs.commonStructure.TreeNode;

import java.util.ArrayList;

public class LeetCode95UniqueBinarySearchTreesII {

    public ArrayList<TreeNode> generateTrees (int n) {
        ArrayList<TreeNode> arrayList = generateTreesHelper(1, n);
        return arrayList;
    }
    public ArrayList<TreeNode> generateTreesHelper(int low,int high){
        ArrayList<TreeNode> res = new ArrayList<>();
        if (low > high){
            res.add(null);
            return  res;
        }
        for (int i = low; i <= high ; i++) {
            ArrayList<TreeNode> left = generateTreesHelper(low, i - 1);
            ArrayList<TreeNode> right = generateTreesHelper(i + 1, high);
            for (int m = 0; m < left.size(); m++) {
                for (int n = 0; n < right.size(); n++) {
                    TreeNode root = new TreeNode(i);
                    root.left = left.get(m);
                    root.right = right.get(n);
                    res.add(root);
                }
            }
        }
        return  res;
    }
}
