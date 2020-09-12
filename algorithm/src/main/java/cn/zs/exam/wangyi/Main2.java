package cn.zs.exam.wangyi;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(count(s));
    }
    public static int count (String s){
        int len = s.length();
        int res = 0;
        boolean [][]dp = new boolean[len][len];
        for (int i = len-1;i>=0;i--){
            for (int j = i;j < len;j++){
                dp[i][j] = (s.charAt(i)==s.charAt(j)&&((j-i < 3)||dp[i+1][j-1]));
                if (dp[i][j])
                    res++;
            }
        }
        return res-s.length();
    }
}
