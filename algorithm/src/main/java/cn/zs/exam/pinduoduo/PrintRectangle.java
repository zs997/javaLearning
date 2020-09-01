package cn.zs.exam.pinduoduo;

import java.util.Scanner;
/*
*   打印米字分割的矩阵
* */
public class PrintRectangle {
    public static void main(String[] args) {
        p1();
    }
    public static void p1() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1 || (n % 2 == 1 && (i == n / 2 || j == n / 2))) {
                    continue;
                } else {
                    if (j >= n / 2) {
                        if (i < n / 2) {
                            if (i + j < n - 1) res[i][j] = 1;
                            else res[i][j] = 8;
                        } else {
                            if (i > j) res[i][j] = 6;
                            else res[i][j] = 7;
                        }
                    } else {
                        if (i < n / 2) {
                            if (i > j) res[i][j] = 3;
                            else res[i][j] = 2;
                        } else {
                            if (i + j < n - 1) res[i][j] = 4;
                            else res[i][j] = 5;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j != n-1){
                    System.out.print(res[i][j]+" ");
                }else System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
}
