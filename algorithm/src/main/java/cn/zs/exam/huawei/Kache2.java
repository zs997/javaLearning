package cn.zs.exam.huawei;

import java.util.Scanner;
/*
背包问题，在背包装的最满的情况下 最大的价值
与其他背包不同  求上界，再做装满的01背包
    9
    5
    2 2 4 6 3
    3 4 8 9 6

    18
* */
public class Kache2 {
    static int weight []  ;
    static int value [];
    static int k;
    static int n;
    static int maxCap = Integer.MIN_VALUE;
    static int maxValue = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
         k = sc.nextInt();
         n = sc.nextInt();
         weight  = new int[n];
         value = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }
//        int values [] = new int[k+1];
//        for (int i = 1; i < n + 1; i++) {
//            for (int j = k; j >= weight[i] ; j--) {
//                values[j] = Math.max(values[j],values[j-weight[i]]+value[i]);
//            }
//        }
//        System.out.println(values[k]);
        heler(0,k,0);
        System.out.println(maxValue);
    }

    public static void heler(int index,int curCap,int curValue){
        if (index == n){
            int used = k - curCap;
            if (used > maxCap){
                maxCap = used;
                maxValue = curValue;
            }else if(used == maxCap){
                maxValue = Math.max(maxValue,curValue);
            }
        }else {
            heler(index+1,curCap,curValue);
           if (curCap >= weight[index]){
               heler(index+1,curCap-weight[index],curValue+value[index]);
           }

        }
    }
}
