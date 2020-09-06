package cn.zs.exam.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/*
*   20200906 美团笔试
*   土地 共有 各自要的 数目
* */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        int q = scanner.nextInt();
        Set<Integer> setA = new HashSet<>();
//        setA.add()
        for (int i = 0; i < p; i++) {
            int data = scanner.nextInt();
            setA.add(data);
        }
        int numA = 0;
        int numB =0;
        int num = 0;
        for (int i = 0; i < q; i++) {
            Integer data = scanner.nextInt();
           if (setA.contains(data)){
               setA.remove(data);
               num++;
           }else {
               numB++;
           }
        }
        System.out.print(numA+" "+numB+" "+num);
    }

    public static void p() {
        Scanner in = new Scanner(System.in);
        logo:
        while (true) {
            String s = in.nextLine();
            if (s == null || s.length() == 0) break;
            int n = Integer.parseInt(s);
            TreeMap<Integer, Integer> map = new TreeMap<>();
            String[] split = in.nextLine().split(" ");
            int one = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(split[i]);
                if (num != 1 && num < 3) {
                    System.out.println("NO");
                    continue logo;
                }
                if(num == 1) one++;
                else one = one - num + 1;
            }
            if(one != 0){
                System.out.println("NO");
            }else System.out.println("YES");
        }
    }
}
