package cn.kh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String regex = "\\d{4}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(s);
        while (m.find()){
            String str = m.group();
            if(!"".equals(str)&&str.length()<5&&Integer.parseInt(str)>=1000&&Integer.parseInt(str)<=3999){
                System.out.print(str+" ");
            }
        }
    }
}
