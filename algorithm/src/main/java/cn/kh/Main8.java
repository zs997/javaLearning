package cn.kh;

import java.util.Scanner;

public class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        double res = max3(a+b,b,b)/(max3(a,b+c,c)+max3(a,b,b+c));

        System.out.format("%.2f",res);
    }

    public static double max3(int a,int b,int c){
        int d = Math.max(a,b);
        return Math.max(d,c);
    }
}
