package cn.zs.exam.duxiaoman;

import javax.xml.transform.Source;
import java.util.Scanner;
/*
N=3 k =2
in:
3 2
0#0
0#1
000

out :
4


3表示 3*3矩阵
从左上角出发
每次可以向上下左右走
走到右下角要多久
每走一步要1s
# 代表陷阱 进去了要加k=2 秒
1代表墙壁 不能走

* */
public class Main2 {
    static char [][] data ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        Integer n = Integer.valueOf(s1[0]);
        Integer k = Integer.valueOf(s1[1]);
        data = new char[n][n];
        for (Integer integer = 0; integer < n; integer++) {
            String s2 = scanner.nextLine();
            for (int i = 0; i < s2.length(); i++) {
                data[integer][i] = s2.charAt(i);
            }
        }
//        for (int i = 0; i < data.length; i++) {
//            for (int i1 = 0; i1 < data[i].length; i1++) {
//                System.out.print(data[i][i1]+" ");
//            }
//            System.out.println();
//        }
        //
        int dp[][] = new int[n][n];
        dp[0][0] = 0;
        for (int i = 0; i < data.length; i++) {
         //   if (data[][])
        }

    }
}
