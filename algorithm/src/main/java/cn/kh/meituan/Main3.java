package cn.kh.meituan;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int res = sub(s1,s2);
        if(res!=-1){
            System.out.println("YES");
            System.out.println(res);
        }else{
            System.out.println("NO");
        }
    }
    public static int sub(String s1,String s2){
        int res = 0,index = 0;
        for(int i=1;i<=s2.length();i++){
            if(s2.charAt(i-1)==s1.charAt(index)){
                res+=i;
                index++;
            }
            if(index == s1.length()) return res;
        }
        return -1;
    }
}
