package cn.zs.exam.city58;
/**
 *  500内找加上a或b都为完全平方数的数
 * */
public class Main2 {
    public static void main(String[] args) {

    }
    public int question(int a ,int b){
        for (int i = 0; i < 500; i++) {
            int a1 = i+a;
            int b1 = b+i;
            if (sqrt(a1) && sqrt(b1))
                return i;
        }
        return -1;
    }
    private static boolean sqrt(int n){
        int temp = (int) Math.sqrt(n);
        return  temp*temp ==n;
    }
}
