package cn.zhushuai;

public class Main4 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();
        TreeNode n4 = new TreeNode();
        TreeNode n5 = new TreeNode();
        TreeNode n6 = new TreeNode();
        TreeNode n7 = new TreeNode();
        TreeNode n8 = new TreeNode();
        root.left = n1;
        n1.left = n2;
        n2.left = n3;
        n3.left = n4;
        n4.left = n5;
        n5.left = n6;
        n6.left = n7;
        n7.left = n8;
        System.out.println(depth(root));
    }
    public  static  int depth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(depth(root.left),depth(root.right))+1;
    }
}
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
}