package cn.kh.meituan;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int res = 0;
        for(int i=M;i<=N;i++){
            if(isOk(i)){
                res++;
            }
        }
        System.out.println(res);
    }
    public static boolean isOk(int num){
        String res = String.valueOf(num);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<res.length();i++){
            int val = res.charAt(i)-'0';
            if(list.contains(val)){
                return false;
            }
            list.add(val);
        }
        if(list.get(0)==0||list.get(2)==0||list.get(4)==0){
            return false;
        }
        int a = list.get(0)*10+list.get(1);
        int b = list.get(2)*10+list.get(3);
        int c = list.get(4)*10+list.get(5);
        if((a+b)!=c){
            return false;
        }
        return  true;
    }
}
