package cn.zs.exam.wangyi;

import cn.zs.commonStructure.TreeNode;

import java.util.Scanner;

//樱桃节点个数
public class Main1 {
    static  int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String[] s2 = s1.split(" ");
        //节点数
        int m = Integer.parseInt(s2[0]);
        //边数
        int n = Integer.parseInt(s2[1]);

        TreeNode [] datas = new TreeNode[m+1];
        for (int i = 1; i < datas.length; i++) {
            datas[i] = new TreeNode(i);
        }
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String[] s3 = s.split(" ");
            int roots = Integer.parseInt(s3[0]);
            String flag = s3[1];
            int ch = Integer.parseInt(s3[2]);
            if (flag.equals("left")){
                datas[roots].left = datas[ch];
            }else {
                datas[roots].right = datas[ch];
            }
        }
        for (int i = 1; i < datas.length; i++) {
            if (cherry(datas[i])){
                count++;
            }
        }
        System.out.println(count);

    }
    public static boolean cherry(TreeNode root){
        if (root == null){
            return  false;
        }
        if (root.left != null && root.left.left ==null
                && root.right != null && root.right.right == null){
            return true;
        }
        return  false;
    }
}
