package cn.zs.practice.leetcode;

public class LeetCode409LongestPalindrome {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() <= 1 )    return s;


        char [] arr = s.toCharArray();
        int len = arr.length;
        int start = 0;
        int length = 0;
        boolean pali [][] = new boolean [len][len];

        for(int i = 0; i < pali.length; i++){
            pali[i][i] = true;
            length = 1;

        }

        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] == arr[i+1]){
                pali[i][i+1] = true;
                start = i;
                length = 2;
            }
        }

        for(int n = 2; n < len; n++){
            for(int i = 0; i+n < len; i++){
                if(arr[i] == arr[i+n]){
                    pali[i][i+n] = pali[i+1][i+n-1];
                    start = i;
                    length = n;
                }
            }
        }

        return s.substring(start,start+length+1);
    }

}
