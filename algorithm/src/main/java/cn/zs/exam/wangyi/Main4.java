package cn.zs.exam.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main4 {
    static  long sum =0;
    static  long max = Long.MIN_VALUE;
    static  int data[] ;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        data= new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            data[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 0; i < data.length; i++) {
            sum+= data[i];
        }
        Arrays.sort(data);
        helper(0,sum,new boolean[data.length]);
        if (max > 0){
            System.out.println(max);
        }else {
            System.out.println(-1);
        }
    }
    public static void helper(int curLevel,long curV,boolean removeList []){
        if (curLevel == data.length){
            return;
        }else {
            if (curV % 7 == 0){
                max = Math.max(curV,max);
            }else {
                for (int i = 0; i < removeList.length; i++) {
                    if (!removeList[i] &&(curV - data[i]) > max){
                       removeList[i] = true;
                       helper(curLevel+1,curV-data[i],removeList);
                       removeList[i] =false;
                    }
                }
            }

        }

    }
}
