package cn.hsq.baidu;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description TODO
 * @Author huanshunqi
 * @Date 2020/9/13 20:36
 * @Version 1.0
 **/
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        long n = Long.parseLong(s[0]);
        long m = Long.parseLong(s[1]);
        long sum = 0;
        for (long i = 1;i <= n * 3;i++){
            sum += i;
        }
        System.out.println(sum * m);
    }
}
