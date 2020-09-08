package cn.zs.exam.wangyi;
import java.util.Scanner;
//选择出矩阵中十字加和最大的 输出行列坐标，
//剩余矩阵产生新矩阵 继续步骤，坐标是新的矩阵的坐标
public class MatrixRemoveMaxCross {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            progress(arr, N);
        }
    }
    public static void progress(int[][] arr, int N) {
        if (N == 1) {
            System.out.println("1 1");
            return;
        }
        int[][] dp = new int[N][N];
        int[] dpR = new int[N];
        int[] dpC = new int[N];
        for (int k = 0; k < N; k++) {
            for (int m = 0; m < N; m++) {
                dpR[k] += arr[k][m];
                dpC[k] += arr[m][k];
            }
        }
        for (int p = 0; p < N; p++) {
            for (int q = 0; q < N; q++) {
                dp[p][q] = dpR[p] + dpC[q] - arr[p][q];
            }
        }
        int max = Integer.MIN_VALUE;
        int[] index = new int[2];
        //            选出最大值
        for (int i = 0; i < N; i++) {
          for (int j = 0; j < N; j++) {
              if (dp[i][j] > max) {
                  max = dp[i][j];
                  index[0] = i;
                  index[1] = j;
              }
          }
        }
        System.out.println((index[0] + 1) + " " + (index[1] + 1));
        //            将剩余的N-1的矩阵继续重复该过程
         int[][] arr1 = new int[N - 1][N - 1];
         int rr = 0;
         int cc = 0;
         for (int i = 0,k=0; i < N; i++) {
             if(index[0] != i ){
                 for (int j = 0,t=0; j < N; j++) {
                    if (index[1] != j && cc < N - 1 && rr < N - 1) {
                         arr1[k][t++] = arr[i][j];
                     }
                 }
                 k++;
              }
         }
         progress(arr1, N - 1);
    }

}

