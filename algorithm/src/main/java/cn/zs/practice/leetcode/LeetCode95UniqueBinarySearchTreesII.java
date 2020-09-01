package cn.zs.practice.leetcode;

import cn.zs.commonStructure.TreeNode;

import java.util.ArrayList;

public class LeetCode95UniqueBinarySearchTreesII {

    public ArrayList<TreeNode> generateTrees (int n) {
        // write code here
        return null;
    }
    public ArrayList<TreeNode> generateTreesHelper(int low,int high){
        ArrayList<TreeNode> res = new ArrayList<>();
        if (low > high){
            return  res;
        }
        for (int i = low; i <= high ; i++) {


        }
        return  res;
    }
}
