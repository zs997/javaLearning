package cn.zs.exam.xiaomi;

import java.util.Scanner;
/*
*   字符串合法性
*   12_Aaqq12
Password123
PASSWORD_123
PaSS^word
12_Aaqq
* */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        for (String s2 : s1) {
            System.out.println(print(s2));
        }
    }

    private static int print(String s2) {
        int len = s2.length();
        if (len < 8 || len > 120)
            return 1;
        boolean numFlag = false;
        boolean englishFlag = false;
        boolean EFlag = false;
        boolean specialFlag = false;
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (c >= '0' && c <= '9'){
                numFlag = true;
            }else if (c >= 'a' && c <= 'z'){
                englishFlag = true;
            }else if(c >= 'A' && c <= 'Z'){
                EFlag = true;
            }else {
                specialFlag = true;
            }
        }
        if (numFlag && englishFlag && EFlag && specialFlag)
            return 0;
        return 2;
    }
}
