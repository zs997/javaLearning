package cn.zs.exam.langchao;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();
        int data [] = new int[nextInt];
        for (int i = 0; i < nextInt; i++) {
            data[i] = sc.nextInt();
        }
        int dp[] = new int[nextInt+1];
        for (int i = 0; i < nextInt; i++) {
            dp[data[i]] = dp[data[i]-1]+1;
        }
        int max = dp[0];
        for (int i = 0; i < nextInt+1; i++) {
            if (dp[i] > max)
                max = dp[i];
        }
        System.out.println(nextInt-max);
    }
}
