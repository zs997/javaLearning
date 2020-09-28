package cn.zhushuai.plw;

public class Main1 {
    public static void main(String args[]){
        int res [] = new int [19];
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;
        for (int i = 3; i < res.length; i++) {
            res[i] = res[i-1]+res[i-2];
        }
        System.out.println(res[18]);

    }
}
