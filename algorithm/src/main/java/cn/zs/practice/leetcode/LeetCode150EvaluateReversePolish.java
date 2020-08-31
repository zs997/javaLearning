package cn.zs.practice.leetcode;

import java.util.Stack;

public class LeetCode150EvaluateReversePolish {
    public static void main(String[] args) {
            String data[] = {"2","1","+","3","*"};
        LeetCode150EvaluateReversePolish test = new LeetCode150EvaluateReversePolish();
        int i = test.evalRPN(data);
        System.out.println(i);
    }
    public int evalRPN (String[] tokens) {
        // write code here
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if (isOperator(c)){
                String b = stack.pop();
                String a = stack.pop();
                String calcul = calcul(a, b, c);
                stack.push(calcul);
            }else {
                stack.push(c);
            }
        }
        //System.out.println(stack.pop());
        String pop = stack.pop();
        return Integer.valueOf(pop);
    }
    public  String  calcul(String a,String b,String operator){
        int a1 = Integer.valueOf(a);
        int b1 = Integer.valueOf(b);
        int res;
        if (operator.equals("+")){
            res = a1+b1;
        }else if(operator.equals("-")){
            res = a1-b1;
        }else if(operator.equals("*")){
            res = a1*b1;
        }else {
            res = a1/b1;
        }
        return String.valueOf(res);
    }
    public boolean isOperator(String c){
        if("+".equals(c) || "-".equals(c)|| "*".equals(c) ||"/".equals(c)){
            return true;
        }
        return false;
    }
}
