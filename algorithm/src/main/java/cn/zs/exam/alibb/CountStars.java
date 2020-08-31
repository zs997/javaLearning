package cn.zs.exam.alibb;

import java.util.Scanner;
/*
*       n个星星 求解星星的排列数量
*       给出一个序列，表示第几个不能是哪号星星
*       应该用 错排公式  数学题*
* */
public class CountStars {
    private static  int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int forbid [] = new int[n];
        for (int i = 0; i < n; i++) {
            //forbid[i] = j 在位置i不能放j
            forbid[i]  = sc.nextInt();
        }
        //n个星星有没有使用过
        boolean visited [] = new boolean[n+1];
        helper(0,visited,forbid);
        System.out.println(count);
    }
    public static void helper(int index,boolean visited[],int [] forbid){
        if (index == forbid.length){
            count++;
        }else{
            //在index处，尝试放上星星 i
            for (int i = 1; i < visited.length; i++) {
                if (!visited[i] && forbid[index] != i){
                    visited[i] = true;
                    helper(index+1,visited,forbid);
                    visited[i] = false;
                }
            }
        }
    }
}
