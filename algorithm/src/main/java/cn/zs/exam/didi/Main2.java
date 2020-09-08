package cn.zs.exam.didi;

import java.util.Scanner;
//打印矩阵
public class Main2 {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        snake(n);
    }
    public static void snake(int n){
        if (n <= 0)
            return;
        if (n == 1){
            System.out.println(1);
            return;
        }
        long data[] = new long[n*n];
        data[0] = 1;
        data[1] = 1;
        for (int i = 2; i < data.length; i++) {
            data[i] = data[i-1]+data[i-2];
        }
        long matrix [][] = new long[n][n];
        int i = data.length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while (i >= 0){
            for(int j = left;j <= right;j++){
                matrix[top][j] = data[i];
                i--;
            }
            for (int j = top+1;j <= bottom;j++){
                matrix[j][right] = data[i];
                i--;
            }
            for (int j = right-1;j >= left;j--){
                matrix[bottom][j] = data[i];
                i--;
            }
            for (int j = bottom-1;j > top;j--){
                matrix[j][left] = data[i];
                i--;
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[0].length-1; k++) {
                System.out.print(matrix[j][k]+" ");
            }
            System.out.println(matrix[j][matrix[0].length-1]);
        }
    }

}
