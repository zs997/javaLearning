package cn.zs.exam.alibb;

import java.util.ArrayList;
import java.util.Scanner;
/*
*   阿里巴巴的笔试题
*   对一个字符串
*   按照list
* */
public class DeleteMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder(s);
        int count = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(sc.nextLine());
        }
        int i = 0;
        while((i = contrains(list,sb.toString())) != -1){
                String target = list.get(i);
                int index = sb.indexOf(target);
                sb=sb.delete(index,index+target.length());
        }
        System.out.println(sb.toString());
    }
    public static int contrains(ArrayList<String> list,String s){
       for(int i = 0; i < list.size(); i++) {
            if (s.contains(list.get(i))){
                return i;
            }
        }
        return -1;
    }

}
