package cn.zs.exam.wangyi;

import java.util.Scanner;
/*
* 将一个数组中每个正整数a[i]都拆成若干个和为a[i]的素数，拆开后这个数组最多能有多少个素数。
* 5： 2 3
* 4 ： 2 2
* */
public class NumOfDepartPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        int [] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum+= count(arr[i]);
        }
        System.out.println(sum);
    }
    public  static  int count(int num){
        if (num == 1)
            return 0;
        if (num == 2 || num == 3)
            return 1;
        return  num/2;
    }
}
