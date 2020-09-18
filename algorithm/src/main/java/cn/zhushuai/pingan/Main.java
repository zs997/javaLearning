package cn.zhushuai.pingan;

import javax.crypto.Mac;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int i = max3(a + b, b, c);
        int j = max3(a, b + c, c);
        int k = max3(a, b, b + c);
        if (j+k == 0)
            System.out.println("ERROR");
        else
            System.out.println(i*1.0/(j+k));
    }
    public static int max3(int a ,int b,int c){
        return Math.max(c,Math.max(a,b));
    }
}
