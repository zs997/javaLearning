package cn.zs.exam.kedaxunfei;

import java.util.Scanner;

public class Keda4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        fun(m,m);
    }
    private static void fun(int c,int n){
        if (n ==1|| n ==0){
            return;
        }
        for (int i = 2; i <=c;i++){
            if (n%i ==0){
                if (n/i ==1)
                    System.out.print(i);
                else
                    System.out.print(i+"*");
                fun(c,n/i);
                break;
            }
        }
    }


}
