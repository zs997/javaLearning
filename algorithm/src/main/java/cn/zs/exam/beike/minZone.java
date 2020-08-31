package cn.zs.exam.beike;

import java.util.Scanner;
/*2020贝壳秋
    给定一个数组
    求
    各个子数组中
    使得数组中每个元素 相或（|）最大的数组中
    找出最短的数组
    最短多少？
* */
public class minZone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr [] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(minlength(arr));

    }
    public static int minlength(int arr[]){
        int n = arr.length;
        // i到j区间最大值
        int max = 0;
        int dp [][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = arr[i];
            max = Math.max(max,dp[i][i]);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i+1;j < n;j++){
                dp[i][j] = dp[i][j-1]|arr[j];
                max =Math.max(max,dp[i][j]);
            }
        }
        int length = 0;
        while (true){
            for (int i = 0;i+length < n;i++){
                if (dp[i][i+length] == max){
                    return length+1;
                }
            }
            length++;
        }

    }
}
