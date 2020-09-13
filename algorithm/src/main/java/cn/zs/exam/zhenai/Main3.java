package cn.zs.exam.zhenai;

import java.util.*;

public class Main3 {
    public static void main(String []args){

        String expression = "1+((2+3)*4)-5";
        List<String> expressionList = expressionToList(expression);
        System.out.println("中缀表达式转为list结构="+expressionList);

        List<String> suffixList = parseToSuffixExpression(expressionList);
        System.out.println("对应的后缀表达式列表结构="+suffixList);

        int calculateResult = calculate(suffixList);
        System.out.printf(expression+"=%d\n",calculateResult);
    }

    private static int calculate(List<String> list) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<list.size(); i++){
            String item = list.get(i);
            if(item.matches("\\d+")){

                stack.push(Integer.parseInt(item));
            }else {

                int num2 = stack.pop();
                int num1 = stack.pop();
                int res = 0;
                if(item.equals("+")){
                    res = num1 + num2;
                }else if(item.equals("-")){
                    res = num1 - num2;
                }else if(item.equals("*")){
                    res = num1 * num2;
                }else if(item.equals("/")){
                    res = num1 / num2;
                }else {
                    throw new RuntimeException("运算符错误！");
                }
                stack.push(res);
            }
        }
        return stack.pop();
    }
    private static List<String> parseToSuffixExpression(List<String> expressionList) {

        Stack<String> opStack = new Stack<>();

        List<String> suffixList = new ArrayList<>();
        for(String item : expressionList){

            if(isOperator(item)){

                if(opStack.isEmpty() || "(".equals(opStack.peek()) || priority(item) > priority(opStack.peek())){

                    opStack.push(item);
                }else {
                    while (!opStack.isEmpty() && !"(".equals(opStack.peek())){
                        if(priority(item) <= priority(opStack.peek())){
                            suffixList.add(opStack.pop());
                        }
                    }

                    opStack.push(item);
                }
            }else if(isNumber(item)){

                suffixList.add(item);
            }else if("(".equals(item)){

                opStack.push(item);
            }else if(")".equals(item)){

                while (!opStack.isEmpty()){
                    if("(".equals(opStack.peek())){
                        opStack.pop();
                        break;
                    }else {
                        suffixList.add(opStack.pop());
                    }
                }
            }else {
                throw new RuntimeException("有非法字符！");
            }
        }

        while (!opStack.isEmpty()){
            suffixList.add(opStack.pop());
        }
        return suffixList;
    }

    public static boolean isOperator(String op){
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }


    public static boolean isNumber(String num){
        return num.matches("\\d+");
    }

    public static int priority(String op){
        if(op.equals("*") || op.equals("/")){
            return 1;
        }else if(op.equals("+") || op.equals("-")){
            return 0;
        }
        return -1;
    }

    private static List<String> expressionToList(String expression) {
        int index = 0;
        List<String> list = new ArrayList<>();
        do{
            char ch = expression.charAt(index);
            if(ch < 47 || ch > 58){

                index ++ ;
                list.add(ch+"");
            }else if(ch >= 47 && ch <= 58){

                String str = "";
                while (index < expression.length() && expression.charAt(index) >=47 && expression.charAt(index) <= 58){
                    str += expression.charAt(index);
                    index ++;
                }
                list.add(str);
            }
        }while (index < expression.length());
        return list;
    }
}
