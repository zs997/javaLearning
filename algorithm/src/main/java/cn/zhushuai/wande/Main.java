package cn.zhushuai.wande;
import java.util.*;
public class Main {
    public static void wind1(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int [][] dp = new int[len1][len2];


        for (int i = 1 ; i < len1 ; i++){
            dp[i][0] = i;
        }

        for (int i = 1 ; i < len2 ; i++){
            dp[0][i] = i;
        }

        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                int a = Math.min((dp[i-1][j] + 1),(dp[i][j-1] + 1));
                int b = 0;
                if(s1.charAt(i) == s2.charAt(j))
                    b = Math.min((dp[i-1][j] + 1),(dp[i-1][j-1] + 0));
                else
                    b = Math.min((dp[i-1][j] + 1),(dp[i-1][j-1] + 1));
                dp[i][j] = Math.min(a,b);
            }
        }
        System.out.println(dp[len1-1][len2-1]);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        wind1(s1,s2);

    }
}