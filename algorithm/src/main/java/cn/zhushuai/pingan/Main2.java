package cn.zhushuai.pingan;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();
        System.out.println(fun(nextInt));
    }
    public static int fun(int x){
        if (x == 1)
            return 1;
        if (x==2)
            return 2;
        if (x==3)
            return 3;
        return fun(x-1)+fun(x-3);
    }

}
