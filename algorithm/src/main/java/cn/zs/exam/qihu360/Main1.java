package cn.zs.exam.qihu360;

import java.util.Scanner;
/*
 *   字符串合法性
 * */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String s = scanner.nextLine();
            String[] s1 = s.split(" ");
            for (String s2 : s1) {
                System.out.println(print(s2));
            }
        }

    }

    private static String print(String s2) {
        int len = s2.length();
        if (len < 8 || len > 120)
            return "Irregular password";
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
            return "Irregular password";
        return "Ok";
    }
}

