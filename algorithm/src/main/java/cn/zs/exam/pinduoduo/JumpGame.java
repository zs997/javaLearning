package cn.zs.exam.pinduoduo;

import java.util.Scanner;
/*
*    2020拼多多
*    飞行棋
*    datas[i] 表示每一步走的距离
*    k表示距离终点的距离
*    如果走了某一步 可能会超过终点 那么要舍弃
*    如果经历了这些过程
*    可以正好到终点 输出paradox
*    否则输出 还剩多少 舍弃了多少
* */
public class JumpGame {
    public static void main(String[] args) {
        flyChess();
    }
    public static void flyChess(){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int datas [] = new int[n];
        for (int i = 0; i < n; i++) {
            datas[i] = sc.nextInt();
        }
        int back = 0;
        int rest = k;
        for (int i = 0; i < datas.length; i++) {
            if (rest - datas[i] == 0){
                System.out.println("paradox");
                return;
            }else  if(rest - datas[i] < 0){
                back++;
            }else {
                rest -= datas[i];
            }
        }
        System.out.println(rest+" "+back);
    }
}
