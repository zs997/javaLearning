package cn.zs.exam.qushi;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main2 {
    static  int i = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String s1 = scanner.nextLine();
         i = Integer.parseInt(s1);
        helper(0,new boolean[s.length()],new StringBuilder(s));


        System.out.println(min);
    }
    static int min = Integer.MAX_VALUE;
    public static void helper(int delnum,boolean del[],StringBuilder sb){
        if (delnum == i){
            String s = sb.toString();
            int i = Integer.parseInt(s);
            min = Math.min(i,min);

        }else {
            for (int j = 0; j < sb.length(); j++) {
                if (!del[j])
                {
                    del[j] = true;
                    char c = sb.charAt(j);
                    sb.deleteCharAt(j);
                    helper(delnum+1,del,sb);
                    sb.insert(j,c);
                    del[j] = false;
                }
            }
        }
    }
}
