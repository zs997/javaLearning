package cn.zs.exam.tecent;
import cn.zs.commonStructure.Loc;

import java.util.ArrayList;
import java.util.Scanner;
/*
*       2020腾讯春招
* */
public class Tx {
    public static void main(String[] args) {
        tx3();
    }
    /*
        给定坐标 计算这些点中 两点距离中 最短的距离
    * */
    public static void calMinDis(){
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        //很多组数据
        for (int i = 0; i < times; i++) {
            int n = sc.nextInt();
            ArrayList<Loc> A = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                A.add(new Loc(sc.nextInt(),sc.nextInt()));
            }
            ArrayList<Loc> B = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                B.add(new Loc(sc.nextInt(),sc.nextInt()));
            }
            Double v = minDis(A, B);
            String s = v.toString();
            System.out.println(s.substring(0, 5));
        }
    }
    /*1
        4
        0 0
        0 1
        1 0
        1 1
        2 2
        2 3
        3 2
        3 3
    * */
    public static double minDis(ArrayList<Loc> A,ArrayList<Loc> B){
        double res = 9999.9;
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < B.size(); j++) {
                double distance = A.get(i).distance(B.get(j));
                if(res > distance){
                    res = distance;
                }
            }
        }
        return res;
    }

    public static void tx3(){
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        System.out.println(c);
        String string = sc.nextLine();
        System.out.println(string);
        // int n = 3;
        int a[] = {1,3,2};
        int b[] = {3,2,1};
        ArrayList<Poker> list = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            list.add(new Poker(a[i],b[i]));
        }
        int count = 0;
        for (int i = 0; i < list.size()-1; i++) {
            for (int j = 0; j < list.size()-1-i; j++) {
                if(list.get(i).Bigger(list.get(j))){
                    count++;
                    list.get(i).reverse();
                    list.get(j).reverse();
                    Poker temp = new Poker(list.get(i).up,list.get(i).down);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }
        System.out.println(count);
    }
    /*
    * 貌似是计算一个数在几层？
    * */
    public static void tx5(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int res = ancestor(sc.nextInt(),sc.nextInt());
            System.out.println(res);
        }
    }
    public static int ancestor(int no,int level){
        int onlevel = CalculLevels(no);
        if(level >= onlevel){
            return -1;
        }
        else{
            while (onlevel > level){
                no /=2;
                onlevel--;
            }
        }
        return no;
    }
    public static int CalculLevels(int n){
        int count = 0;
        int base = 1;
        int res = 0;
        while(res < n){
            res += base;
            base *= 2;
            count ++;
        }
        return count;
    }
}


class Poker{
    int up;
    int down;
    public Poker(int up,int down){
        this.up = up;
        this.down = down;
    }
    public boolean Bigger(Poker poker){
        return up > poker.up;

    }
    public void reverse(){
        int temp = up;
        up = down;
        down = temp;
    }

}

