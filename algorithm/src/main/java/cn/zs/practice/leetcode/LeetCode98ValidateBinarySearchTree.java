package cn.zs.practice.leetcode;

import cn.zs.commonStructure.TreeNode;

public class LeetCode98ValidateBinarySearchTree {
    public boolean isValidBST (TreeNode root) {
        // write code here
        if (root == null || (root.left == null && root.right == null))
            return true;
        if (root.left != null && root.left.val >= root.val)
            return false;
        if (root.right != null && root.right.val <= root.val)
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
    }
}
