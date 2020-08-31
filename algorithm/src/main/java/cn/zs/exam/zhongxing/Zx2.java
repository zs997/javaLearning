package cn.zs.exam.zhongxing;

import java.util.Scanner;
/*
   2
   101 2 3
   4B  12 13
* */
public class Zx2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int res [] = new int[T];
        for (int i = 0; i < T; i++) {
            String data = sc.next();
            int start = sc.nextInt();
            int end =sc.nextInt();
            res[i] = calcal(data,start,end);
        }
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int calcal(String data,int start,int end){
        int sum = 0;
        for(int i = start;i <= end;i++){
           sum += Integer.parseInt(data, 10);
        }
        return sum%2 == 0 ?0:1 ;
    }

}
