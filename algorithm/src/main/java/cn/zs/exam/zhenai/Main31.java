package cn.zs.exam.zhenai;


import java.util.Scanner;
import java.util.Stack;

public class Main31 {

    private Stack<Character> cStack = new Stack<Character>();
    private Stack<Integer> iStack = new Stack<Integer>();

    // 符号等级
    static int cLevel(char c) {
        switch (c) {
            case '(':
                return 0;
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
        }
        return 0;
    }

    // 对栈进行运算
    private void dealStack() {
        char c = cStack.pop();
        int num1 = iStack.pop();
        int num2 = iStack.pop();
        switch (c) {
            case '+':
                iStack.push(num1 + num2);
                break;
            case '-':
                iStack.push(num1 - num2);
                break;
            case '*':
                iStack.push(num1 * num2);
                break;
            case '/':
                iStack.push(num1 / num2);
                break;
        }
    }

    // 返回str的表达式的值
    public int calc(char[] exp) {
        while (!cStack.isEmpty()) {
            cStack.pop();
        }
        while (!iStack.isEmpty()) {
            cStack.pop();
        }
        cStack.push('(');

        for (int i = 0; i < exp.length; i++) {
            if (exp[i] == ' ') {
                continue;
            } else if (exp[i] > '0' && exp[i] <= '9') {
                int num = exp[i] - '0';
                while (exp[i + 1] > '0' && exp[i + 1] < '9') {
                    i++;
                    num = num * 10 + exp[i] - '0';
                }
                iStack.push(num);
            } else if (exp[i] == '(') {
                cStack.push(exp[i]);
            } else if (exp[i] == '+' || exp[i] == '-' || exp[i] == '*' || exp[i] == '/') {
                while (cLevel(exp[i]) < cLevel(cStack.peek())) {
                    dealStack();
                }
                cStack.push(exp[i]);
            } else if (exp[i] == ')') {
                while (!cStack.peek().equals('(')) {
                    dealStack();
                }
                cStack.pop();
            }
        }
        return iStack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        ExpressionCalc m = new ExpressionCalc();
        while (sc.hasNext()) {
            // 程序需要前后补一个括号
//            System.out.println(m.calc((sc.nextLine() + ")").toCharArray()));
        }

    }
}