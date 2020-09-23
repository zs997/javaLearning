package cn.zhushuai;

public class Main17 {
    public static void main(String args[]){
        String a = "123";
        String b =a.intern();
        String c = new String("123");
        String d = "123";
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(a == d);
       // System.out.println(a == b);
    }
}
