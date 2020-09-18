package cn.kh;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.next();
            int count = 0;
            for (int i = 0 ; i < str.length() ; i ++){
                if (str.charAt(i) >= '0' && str.charAt(i) <= '9'){
                    count ++;
                    if (count == 4 && i + 1 < str.length()&&!(str.charAt(i + 1) >= '0' && str.charAt(i + 1) <= '9')){
                        System.out.print(Integer.parseInt(str.substring(i - 3 ,i + 1)) +" ");
                    }
                }else{
                    count = 0;
                }
            }
            if (count == 4){
                System.out.println(Integer.parseInt(str.substring(str.length()-4)));
            }
        }
    }
}
