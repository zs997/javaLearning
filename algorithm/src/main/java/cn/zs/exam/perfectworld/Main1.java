package cn.zs.exam.perfectworld;

import java.util.Scanner;

/*
张三每天都去小王家偷桃子，但是张三是一个有原则的小偷，
他每次只偷一半加一个（例如为4，则偷2 + 1 一共三个），
假设小王第N天发现自己只剩下一颗桃子，那么小王原本有几颗桃子
  * */
public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _day;
        _day = Integer.parseInt(in.nextLine().trim());

        res = calNum(_day);
        System.out.println(String.valueOf(res));

    }
    static int calNum(int day) {
        int res = 1;
        for (int i = 0; i < day; i++) {
            res = res*2+2;
        }

        return res;
    }
}
