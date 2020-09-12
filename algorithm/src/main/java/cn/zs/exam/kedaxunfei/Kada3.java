package cn.zs.exam.kedaxunfei;

import java.util.Scanner;
/* ___avsd___asff_SFAG__
去除字符串前后的‘_’
中间部分只留一个
*/
public class Kada3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s == null ||s.length() ==0){
            System.out.println(s);
        }
        char[] chars = s.toCharArray();
        int slow = 0;
        int fast = 0;
        boolean head = false;
        while (fast < chars.length){
             if(chars[fast] !='_'){
                 head = true;
                chars[slow++] = chars[fast++];
            }else if (!head){
                 //开头
                fast++;
            }else if (chars[fast-1] !='_'){
                 //中间第一个_
                 chars[slow++] = chars[fast++];

             }else {
                 fast++;
             }
        }
        String s1 = new String(chars,0,slow-1);
        System.out.println(s1);
    }
}
