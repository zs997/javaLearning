package cn.zs.exam.huawei;

import java.util.Scanner;

public class Kache {
    public static void main(String[] args) {
        maxValueDp();
    }
    public static void  maxValueDp(){
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int n = sc.nextInt();
        int data [][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            data[i][1] = sc.nextInt();
        }
        int dp [][] = new int [n+1][capacity+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] =0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int weight = data[i-1][0];
                int value = data[i-1][1];
                if ( weight < j){
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight]+value);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][capacity]);

    }
}
