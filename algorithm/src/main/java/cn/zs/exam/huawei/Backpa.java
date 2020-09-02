package cn.zs.exam.huawei;

import java.util.Scanner;
/*
    9
    5
    2 2 4 6 3
    3 4 8 9 6
* */
public class Backpa {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int weight [] = new int[n+1];
        int value[] = new int[n+1];
        for (int i = 0; i < n; i++) {
            weight[i+1] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            value[i+1] = sc.nextInt();
        }
        int values [] = new int[k+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = k; j >= weight[i] ; j--) {
                values[j] = Math.max(values[j],values[j-weight[i]]+value[i]);
            }
        }
        System.out.println(values[k]);
    }
}


