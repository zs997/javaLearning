package cn.zs.practice.xunhuanjie;

import java.util.ArrayList;
import java.util.Vector;

/*
*  求11/13 小数的循环节长度
*  n相当于每次除以m 之后的余数  一直维持着余数
*  除的过程中 如果整除了  余数为0  则没有循环节
*  除的过程中 如果目前的余数在之前出现过  就会有循环节
* */
public class XunHuanJie {
    public static void main(String args[]){
        System.out.println(calCircleLength(11,13));
    }
    /**
     * @param n 被除数
     * @param m 除数
     * @return 小数结果的最小循环节长度
     * **/
    public  static int calCircleLength(int n,int m){
        //相当于第一位小数
         n = n%m;
        ArrayList<Integer> temp = new ArrayList<>();
        for (;;){
            temp.add(n);
            n *= 10;
            //接下来的每一位小数
            n = n % m;
            if (n == 0)
                return 0;
            if(temp.contains(n))
                return  temp.size()-temp.lastIndexOf(n);
        }
    }
}
