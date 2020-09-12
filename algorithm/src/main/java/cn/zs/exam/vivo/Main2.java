package cn.zs.exam.vivo;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);

        String str = cin.nextLine();

        System.out.print(check(str));
    }

    static String check(String str) {
        StringBuilder s ;
        int n = str.length();
        for (int i = 0; i < n; i ++) {
            String t = str.substring(0, i) + str.substring(i + 1, n);
            s = new StringBuilder(t);
            if (s.reverse().toString().equals(t)) return t;
        }
        return "false";
    }
}