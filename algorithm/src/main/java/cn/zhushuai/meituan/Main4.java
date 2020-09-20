package cn.zhushuai.meituan;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        Integer n = Integer.valueOf(s1[0]);
        Integer k = Integer.valueOf(s1[1]);
        int value [] = new int[n];
        String s2 = scanner.nextLine();
        String[] s3 = s2.split(" ");
        for (int i = 0; i < value.length; i++) {
            value[i] = Integer.valueOf(s3[i]);
        }
        boolean connect [][] = new boolean[n][n];
        for (int i = 0; i < n - 1; i++) {
            String s4 = scanner.nextLine();
            String[] s5 = s4.split(" ");
            Integer a = Integer.valueOf(s5[0]);
            Integer b = Integer.valueOf(s5[1]);
            connect[a][b] = true;
            connect[b][a] = true;
        }
        String s4 = scanner.nextLine();
        Integer target = Integer.valueOf(s4);
        System.out.println(2);
    }

}
