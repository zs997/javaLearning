package cn.zhushuai;

import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Stack;

public class Main5 {
    public static void main(String[] args) {
        Main5 queue = new Main5();
        queue.push(1);
        queue.push(2);
        int pull = queue.pull();
        System.out.println(pull);

    }
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void push(int val){
        stack1.push(val);
    }
    public int pull(){
        if (stack2.isEmpty()){
            if (stack1.isEmpty()){
                return -1;
            }else {
                while (!stack1.isEmpty())
                    stack2.push(stack1.pop());
            }
        }
        Integer pop = stack2.pop();
        return pop;
    }

}
