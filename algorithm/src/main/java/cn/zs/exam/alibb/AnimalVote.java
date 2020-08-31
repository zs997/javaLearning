package cn.zs.exam.alibb;

import java.util.Scanner;
/*
        2020春季
*       1 、投票
        有n个小动物（1~n号）参与投票。再给定n个数，代表每个小动物崇拜情况。
        第i个数代表第i个动物的崇拜情况。如果是0，代表它不崇拜任何动物，只能给自己投票。
        如果不是0，假设是j，那么它投票时可能给自己投，可能跟随j投。
        请解出每个小动物最高可能的票数。
        案例：
        4
        0 1 2 1
        第一行4，表示一共四个动物。
        第二行，1号动物无崇拜，2号崇拜1,3号崇拜2,4号崇拜1
        输出： 4 2 1 1
* */
public class AnimalVote {
    public static void main(String[] args) {
        votes();
    }

    public static void votes(){
        Scanner in = new Scanner(System.in);
        //动物个数
        int n = in.nextInt();
        int admire [] = new int[n+1];
        for (int i = 1; i < admire.length; i++) {
            admire[i] = in.nextInt();
        }
        //记录每个动物的最高分数 0 ~ n。下标0 舍弃 1~n 动物的最高分
        int maxScore [] = new int[n+1];
        //计算第i动物的最高分 尽可能让这个号的动物多票数
        for (int i = 1; i <= n; i++) {
            //第j号动物 尽量投i
            for(int j = 1;j <= n;j++){
                if(j == i){
                    //自己不管咋样 都要投自己 才可能最高
                    maxScore[i]++;
                }else{
                    //j != i 时 想让j给i投票
                    //j号 看崇拜那个？
                    //j的明星
                    int fans = j;
                    int star = admire[fans];
                    while(star != 0){
                        if(star == i){
                            maxScore[i]++;
                            break;
                        }
                        fans = star;
                        star = admire[fans];
                    }
                }
            }
        }

        for (int i = 1; i < maxScore.length; i++) {
            System.out.println(maxScore[i]);
        }
    }
}
