package cn.zs.exam.wangyi;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(helper(s));
    }
    public static int helper(String s){
        for (int i = s.length(); i > 0; i--) {
            if(check(s,i)){
                return i;
            }
        }
        return 0;
    }

    public static  boolean check(String s,int n){
        int a = 0;
        int b = 0;
        int c = 0;
        int x = 0;
        int y = 0;
        int z = 0;
        int window = 0;
        int right = 0;
        int left = 0;
        while(left < s.length() - n + 1){
            if(window < n){
                if (s.charAt(right) == 'a') {
                    a++;
                }
                if (s.charAt(right) == 'b') {
                    b++;
                }
                if (s.charAt(right) == 'c') {
                    c++;
                }
                if (s.charAt(right) == 'x') {
                    x++;
                }
                if (s.charAt(right) == 'y') {
                    y++;
                }
                if (s.charAt(right) == 'z') {
                    z++;
                }
                right++;
                window++;
            }
            if(window == n){
                if(a % 2==0 && b % 2==0&& c % 2==0&& x % 2==0&& y % 2==0&& z % 2==0){
                    return true;
                }
                if (s.charAt(left) == 'a') {
                    a--;
                }
                if (s.charAt(left) == 'b') {
                    b--;
                }
                if (s.charAt(left) == 'c') {
                    c--;
                }
                if (s.charAt(left) == 'x') {
                    x--;
                }
                if (s.charAt(left) == 'y') {
                    y--;
                }
                if (s.charAt(left) == 'z') {
                    z--;
                }

                left++;
                window--;
            }
        }
        return  false;
    }
}