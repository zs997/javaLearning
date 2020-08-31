package cn.zs.exam.qiAnXin;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class QiAnXin {
    public static void main(String[] args) {
//        System.out.println(q1(3));
        q2();
    }
    public static int q1(int num_money){
        if (num_money <=0){
            return  -1;
        }else if (num_money ==1){
            return 1;
        }else {
            return 2*q1(num_money-1);

        }
    }
    public static void q2(){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split("//s+");
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss[i]);
        }
        ArrayList<String> list = new ArrayList<>();
        Stack<String> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < ss.length; i++) {
            String si = ss[i];
            if ("undo".equals(si)){
                String remove = list.remove(list.size() - 1);
                stack1.push(remove);
                stack2.push(list.size());
            }else if("redo".equals(si)){
                if ((!stack1.isEmpty()) && (!stack2.isEmpty())){
                    list.add(stack2.pop(),stack1.pop());
                }else {
                    list.add(si);
                }
            }else {
                    list.add(si);
            }
        }
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println(list.get(list.size()-1));
    }
}
