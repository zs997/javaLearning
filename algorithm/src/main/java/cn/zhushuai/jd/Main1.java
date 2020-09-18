package cn.zhushuai.jd;

import java.util.ArrayList;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
         String s= "";
         if (s!= null && !"".equals(s)){

         }

    }
    public static void fun(){
        Scanner sc  = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> res = new ArrayList<>();
        String s = null;
        String reg = "[1-3][0-9][0-9][0-9]";
        while (!(s = sc.nextLine()).equals("")){
            list.add(s);
        }
        for (int i = 0; i < list.size(); i++) {
            s=list.get(i);
            String[] s1 = s.split(" ");
            for (int i1 = 0; i1 < s1.length; i1++) {
                String s2 = s1[i1];
                s2.matches(reg);
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i));
        }
        System.out.println("asdfsadfsadfsdsfdff");

    }
}
