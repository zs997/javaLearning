package cn.zs.exam.qushi;



import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        String data1 = s1[0];
        String data2 = s1[1];
        char[] chars = data1.toCharArray();
        char[] chars1 = data2.toCharArray();
        TreeNo treeNo = buildTree(chars, chars1);
        pre(treeNo);
        System.out.println(sb);
    }
    static StringBuilder sb = new StringBuilder();
    public static void pre(TreeNo root){
        if (root== null )
            return;
        sb.append(root.c);
        pre(root.left);
        pre(root.right);
    }
    public static TreeNo buildTree(char [] inorder,char [] postorder){
        if (inorder == null && postorder==null)
            return null;
        return  rebuild(inorder,postorder,0,postorder.length-1,0,inorder.length-1);
    }

    private static TreeNo rebuild(char[] in, char[] post, int postLeft,
                             int postRight, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft >inRight)
            return null;
        int loc = -1;
        TreeNo t = new TreeNo(post[postRight]);
        t.left = t.right = null;
        for (int i = inLeft;i <= inRight;i++){
            if (in[i] == post[postRight]){
                loc = i;
                break;
            }
        }
        t.left = rebuild(in,post,postLeft,postRight-inRight+loc-1,inLeft,loc-1);
        t.right = rebuild(in,post,postRight-inRight+loc,postRight-1,loc+1,inRight);
        return t;
    }
}
class  TreeNo{
    char c;
    TreeNo left;
    TreeNo right;
    TreeNo(char c){this.c = c;}

}