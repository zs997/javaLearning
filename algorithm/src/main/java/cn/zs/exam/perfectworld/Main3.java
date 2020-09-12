package cn.zs.exam.perfectworld;

import java.util.Scanner;
import java.util.Stack;
// 给定一个入栈顺序一个出栈顺序
//判断是否是合法的出栈
public class Main3 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean isValidPop(int[] pushList, int[] popList) {
            Stack<Integer> stack = new Stack<>();
            int pushIndex = 0;
            int popIndex = 0;
            int length = pushList.length;
          //  stack.push(pushList[pushIndex++]);
            while(pushIndex < pushList.length) {
               stack.push(pushList[pushIndex]);
               pushIndex++;
               while (!stack.isEmpty()&& (stack.peek() == popList[popIndex])){
                   stack.pop();
                   popIndex++;
               }
            }
            if (stack.isEmpty() && popIndex== popList.length){
                return true;
            }
            return false;

    }
    /******************************结束写代码******************************/
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        boolean res;
        int _push_size = 0;
        _push_size = Integer.parseInt(in.nextLine().trim());
        int[] _push = new int[_push_size];
        int _push_item;
        for(int _push_i = 0; _push_i < _push_size; _push_i++) {
            _push_item = Integer.parseInt(in.nextLine().trim());
            _push[_push_i] = _push_item;
        }
        int _pop_size = 0;
        _pop_size = Integer.parseInt(in.nextLine().trim());
        int[] _pop = new int[_pop_size];
        int _pop_item;
        for(int _pop_i = 0; _pop_i < _pop_size; _pop_i++) {
            _pop_item = Integer.parseInt(in.nextLine().trim());
            _pop[_pop_i] = _pop_item;
        }
        res = isValidPop(_push, _pop);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
