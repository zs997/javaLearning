package cn.zs.exam.shopee;
/*
*
* */
public class Main3 {
    public static void main(String[] args) {
        int expect = expect(2);
        System.out.println(expect);
        double pow = Math.pow(2, 3);
        System.out.println(pow);
    }
    public  static int expect (int n) {

        // write code here
       // double v = (n - 1) * Math.pow(2, 1 - n) + Math.pow(2, 1 - 2 * n);
        double v = (n - 1 + Math.pow(2, -n)) * Math.pow(2, 1 - n);
        int ceil = (int) Math.floor(v);
        return ceil;
    }
}
