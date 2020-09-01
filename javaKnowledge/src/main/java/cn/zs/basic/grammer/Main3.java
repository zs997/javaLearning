package cn.zs.basic.grammer;

public class Main3 {
    public static void main(String args[]){
        //1.重载
        ch(null);

        //2.重载
        ch("sd");
        ch(new Object());
     //   int check = check(3);
      //  System.out.println(check);
    }
    public static int check(int a){
        System.out.println(a);
        if (a==0||a==1)
            return a;
        else return check(a-1)+check(a-2);
    }
    public static void ch(String s){
        System.out.println("a");
    }
    public static void ch(Object o){
        System.out.println("b");
    }
}
