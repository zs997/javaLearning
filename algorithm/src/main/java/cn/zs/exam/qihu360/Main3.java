package cn.zs.exam.qihu360;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()) {
            System.out.println(check(sc.nextLine()));
        }

    }
    public  static String check(String pwd){
        if (pwd.length()<8 || pwd.length() > 120){
            return "Irregular password";
        }
        int numCount = 0;
        int sysmbolCount = 0;
        int upperCount = 0;
        int lowerCount = 0;
        for (char c : pwd.toCharArray()) {
            if(Character.isDigit(c)){
                numCount++;
            }else if(Character.isUpperCase(c)){
                upperCount++;
            }else if(Character.isLowerCase(c)){
                lowerCount++;
            }else{
                sysmbolCount++;
            }
        }
        if( numCount== 0 || sysmbolCount == 0 || upperCount == 0 || lowerCount ==0 ){
            return "Irregular password";
        }

        return "Ok";
    }
}