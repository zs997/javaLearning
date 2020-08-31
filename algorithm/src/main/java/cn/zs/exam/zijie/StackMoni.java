package cn.zs.exam.zijie;

import java.util.Scanner;
import java.util.Stack;
/*
*   2020春季 字节 模拟栈操作
* */
public class StackMoni {
   static Stack<String> stack = new Stack<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
//      String str = new String("");
        StringBuilder sb = new StringBuilder("");
        String lastData = "";
        for (int i = 0; i < n; i++) {
            String data = sc.nextLine();
            String[] commands = data.split(" ");
            lastData = doCommand(lastData, sb, commands);
        }
    }
    private static String  doCommand(String lastData,StringBuilder sb, String[] commands) {
        stack.push(sb.toString());
        String nums = commands[0];
        Integer command = Integer.valueOf(nums);
        if(command == 1){
            sb.append(commands[1]);
        }else if(command == 2){
            int k = Integer.valueOf(commands[1]);
            sb.delete(sb.length()-k,sb.length());
        }else if(command == 3){
            System.out.println(sb.toString().charAt(Integer.valueOf(commands[1])-1));
        }else if(command == 4){
            sb = new StringBuilder(stack.pop());
        }else{}
        return sb.toString();
    }
}


 /*
*
*
* 8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1

c
y
a
*
* */