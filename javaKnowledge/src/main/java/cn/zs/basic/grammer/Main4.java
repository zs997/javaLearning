package cn.zs.basic.grammer;

import java.util.ArrayList;

public class Main4 {
    public static void main(String args[]) {
//        try{
//            int a = 1/0;
//            return;
//        }catch (Exception e){
//            System.out.println("2");
//            return;
//        }finally {
//            System.out.println("3");
//            return;
//        }
//    }
        int a = 10101&11100&11100;
        int b = 10101|11100|11100;
        int c = 10101^11100|11100;
        System.out.println(a);
        String s = String.valueOf(a);
        System.out.println(s);
        System.out.println();

        //整型转二进制
        int d = -1;
        int e = 1;
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(e));
        System.out.println(Integer.toBinaryString(d+e));
        //二进制转int，二进制用0b开头
      ///  0b11111;
      //  System.out.println(bn);
       // ArrayList<TreeNode>

        }
}
