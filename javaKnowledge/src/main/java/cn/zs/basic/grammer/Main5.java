package cn.zs.basic.grammer;

//import cn.zs.basic.classloader.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class Main5 {
//    static  final int[] a ={100,200};
//    static final int [] a = new  int[2]{100,200} ;
//    static {a = new int[2];a[0] = 100;a[1]=200;}
//static  final int[] a;
//static  void init(){
//    a = new int[3];
//    a[0] = 100;
//    a[1] = 200;
//}
    public static void main(String args[]){
//        HashMap<String,String> resa =new HashMap<>();
//        resa.put(null,null);
//        System.out.println(a[0]);
//        System.out.println(a[1]);
//        HashSet
        System.out.println('a'+0);
        int y = 10;
        int x = 0;
        do{
            y--;
            ++x;

        }while (x<5);
        System.out.println(x+","+y);
        Hashtable<String,String> resss= new Hashtable<>();
    //    resss.put(null,"");
        System.out.println("a"=="a");
    }
}
