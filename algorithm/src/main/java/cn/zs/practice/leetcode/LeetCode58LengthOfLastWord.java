package cn.zs.practice.leetcode;

public class LeetCode58LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0 ||s.equals(" ")){
            return 0;
        }
        int i = 0;
        for( i = s.length()-1;i >= 0;i--){
            if(s.charAt(i) == ' '){
                break;
            }
        }
        return s.length()-i-1;
    }
}
