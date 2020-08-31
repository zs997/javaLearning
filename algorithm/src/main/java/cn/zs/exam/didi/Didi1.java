package cn.zs.exam.didi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Didi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        LinkedList<int []> res= new LinkedList<>();
        for (int i = 100; i <num-100 && i<1000 ; i++) {
            int otherNum = num -i;
            String temp = i+"";
            char a = temp.charAt(0);
            char b = temp.charAt(1);
            char c = temp.charAt(2);
            int acc = Integer.valueOf(""+a+c+c);
            if(a!=b && a!=c && b != c && acc == otherNum){
                res.add(new int[]{i,otherNum});

            }
            System.out.println(res.size());
            for (int [] nums : res){
                System.out.println(nums[0]+" "+nums[1]);
            }
        }
    }
}
