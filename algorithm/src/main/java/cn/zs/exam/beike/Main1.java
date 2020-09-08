package cn.zs.exam.beike;

import java.util.Scanner;

/*
* 输入两个人左右手是剪刀（J）石头(S)还是布(B)
* 输出前者 出左手还是右手 胜率高 亦或是 一样高
* （前者必须要压过后者 才算可  平手算输）
* 1表示测试数据组数
* 1
*  S J J B
*  same
* */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = Integer.parseInt(s);

        for (int i = 0; i < n; i++) {
            panduan(scanner.nextLine());
        }
    }
    public static void panduan(String data){
        String[] s = data.split(" ");
        int countLeft = 0;
        int countRight = 0;
        if (AwinB(s[0],s[2]))
            countLeft++;
        if (AwinB(s[0],s[3]))
            countLeft++;
        if (AwinB(s[1],s[2]))
            countRight++;
        if (AwinB(s[1],s[3]))
            countRight++;
        if (countLeft > countRight){
            System.out.println("left");
        }else if (countLeft < countRight){
            System.out.println("right");
        }else {
            System.out.println("same");
        }
            

    }
    public static boolean AwinB(String a,String b){
        if (a.equals("J") && b.equals("B"))
            return true;
        if (a.equals("B") && b.equals("S"))
            return true;
        if (a.equals("S") && b.equals("J"))
            return true;
        return false;
    }
}
