package cn.zs.practice.leetcode;

public class LeetCode9PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        int div = 1;
        while(x/div >= 10){
            div  = div *10;
        }
        int num = x;
        int left = 0;
        int right = 0;
        while(div != 0){
            left = num/div;
            right = num%10;
            if(left != right){
                return false;
            }
            num = (num - left*div)/10;
            div = div /100;

        }
        return true;

    }

}
