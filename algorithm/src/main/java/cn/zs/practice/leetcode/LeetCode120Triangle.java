package cn.zs.practice.leetcode;

import java.util.Scanner;

public class LeetCode120Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr [][] = new int[N+1][N+1];
        for(int i = 1;i <=N;i++){
            for(int j =1;j <=i;j++){
                arr[i][j] = sc.nextInt();
            }
        }

        int dp [][] = new int[N+1][N+1];
        dp[1][1] = arr[1][1];
        for(int i = 2;i<=N;i++){
            for(int j =1;j<=i;j++){
                if(j==1){
                    dp[i][j] =dp[i-1][j]+arr[i][j];
                }else if(j==i){
                    dp[i][j] =dp[i-1][j-1]+arr[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
                }
            }
        }
        int res = 0;

        for (int i = 0; i < dp[N].length; i++) {
            res = Math.max(res,dp[N][i]);
        }
        System.out.println(res);
    }
}
