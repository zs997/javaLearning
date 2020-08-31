package cn.zs.practice.leetcode;
/*
 计算两个字符串的最长公共子序列的长度，字符不区分大小写。

* 输入描述：输入两个字符串，分两行输入。

* 输出描述：输出一个整数。

* 示例：

* 输入：

12asdfa
we2rasdaswer

* 输出：5
* */

import java.util.Scanner;

/**
 *   dp[i][j] 表示第一个串 0 ~i 坐标 第二个串 0~j 坐标 最长的公共子序列
 *   * */
public class LeetCode1143LCS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(findLCS(s1,s2));
    }
    public static int longestCommonSubsequence(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m][n];
        for (int j = 0; j < n; j++) {
            //s1一个字符，s2 j+1个字符
            if(s1.charAt(0) == s2.charAt(j) ||(j-1 >=0 && dp[0][j-1] == 1) ){
                dp[0][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            //s1 i+1个字符 s2一个字符
            if (s1.charAt(i) == s2.charAt(0) || dp[i-1][0] == 1){
                dp[i][0] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static int findLCS(String A,  String B) {
        int n = A.length();
        int m = B.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }


}
