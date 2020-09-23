package cn.zhushuai;

public class Mian15 {
    public static void main(String args[]){
        int i = 0;
        inc(i);
        i = i++;
        System.out.println(i);
        System.out.println(i);
    }

    static void inc(int i){
        i++;
    }
}
