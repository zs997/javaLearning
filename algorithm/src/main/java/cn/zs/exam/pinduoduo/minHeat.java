package cn.zs.exam.pinduoduo;
import java.util.Scanner;
/**
 *    午饭有n套 晚饭有m套
 *    每个套餐都有热量,营养值
 *    中午晚饭 都可吃,可不吃
 *    但要保证获得的营养大于等于t
 *    返回最小能量
 *    背包问题？？不好套
 *    按照热量升序排序午餐和晚餐
 *    对于只判断一种的情况
 *    如只吃早餐 找到符合要求的  直接就可以了
 *    晚餐也是
 *
 *    而符合的情况
 *    只要在每种早餐的情况下  找到满足的晚餐 就可以 后续不需要遍历 后续晚餐的热量更大
 * */
public class minHeat {
    public static void main(String[] args) {
        System.out.println(minQ());
    }
    public static int minQ(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        Meal wufan [] = new Meal[n];
        Meal wanfan[] = new Meal[m];
        for (int i = 0; i < n; i++) {
            wufan[i] = new Meal(sc.nextInt(),sc.nextInt(),0);
        }
        for (int i = 0; i < m; i++) {
            wanfan[i]  = new Meal(sc.nextInt(),sc.nextInt(),1);
        }
        //可以不吃的情况
        if (t == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        //只吃中饭
        for (int i = 0; i < wufan.length; i++) {
            if (wufan[i].M >= t){
                min = Math.min(min,wufan[i].Q);
            }
        }
        //只吃中饭
        for (int i = 0; i < wanfan.length; i++){
            if (wanfan[i].M >= t){
                min = Math.min(min,wanfan[i].Q);
            }
        }
        //晚饭中饭配合
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (wufan[i].M+wanfan[j].M >= t){
                    min = Math.min(wufan[i].Q+wanfan[j].Q,min);
                }
            }
        }
        return min;
    }
}
class Meal{
    // 0 中餐
    // 1 晚饭
    int type;
    int Q;
    int M;
    Meal(){}
    Meal(int Q,int M,int type){
        this.M = M;
        this.Q = Q;
        this.type = type;
    }
}
