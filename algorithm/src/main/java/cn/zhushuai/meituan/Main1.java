package cn.zhushuai.meituan;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int count = 0;
        for (int i = m;i <= n;i++){
            int f = i%10;
            int e = i/10%10;
            int d = i/100%10;
            int c = i/1000%10;
            int b = i/10000%10;
            int a = i/100000%10;
        }
    }
}
