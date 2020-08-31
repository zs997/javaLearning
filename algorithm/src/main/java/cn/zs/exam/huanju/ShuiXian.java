package cn.zs.exam.huanju;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/*
*   找出大于某一个数的最小水仙花数
* */
public class ShuiXian {
    public static void main(String[] args) {
        //System.out.println(shuiXian(153));
        Scanner sc = new Scanner(System.in);
        int nextInt = sc.nextInt();
        for (int i =nextInt+1;i<Integer.MAX_VALUE;i++){
            if (shuiXian(i))
                System.out.println(i);
                break;
        }

    }
    public long nextNarcissisticNumber (int n) {
        // write code here
        long i =n+1;
        for (;i<Long.MAX_VALUE;i++){
            if (shuiXian(i))
              //  System.out.println(i);
            break;
        }
        return i;
    }
    private static boolean shuiXian(long num){
        long origin = num;
        long N = 0;
        long sum = 0;
        ArrayList<Long> data = new ArrayList<>();
        while (num != 0){
            data.add(num%10);
            num/=10;
            N++;
        }
        for (int i = 0; i < data.size(); i++) {
            sum += Math.pow(data.get(i),N);
        }
        return sum == origin;

    }
}
