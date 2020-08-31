package cn.zs.exam.kedaxunfei;

import java.util.Scanner;
/*
*
3,3
2  3 1
1 5 1
4 2 1
* */
public class Keda1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        Integer m = Integer.valueOf(split[0]);
        Integer n = Integer.valueOf(split[1]);
        int data[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                data[i][j] = sc.nextInt();
            }
        }
       // int dp [][] = new int[m][n];
        for (int i = 1; i < n; i++) {
            data[0][i] += data[0][i-1];
        }
        for (int i = 1; i < m; i++) {
            data[i][0] += data[i-1][0];
        }
        for (int i = 1; i < m;i++){
            for(int j = 1;j <n;j++){
                data[i][j] += Math.max(data[i-1][j],data[i][j-1]);
            }
        }
        System.out.println(data[m-1][n-1]);

    }
}
