package cn.zhushuai;
import java.util.ArrayList;
import java.util.Collections;
public class Main2 {
    public static void main(String[] args) {
        System.out.println(fun(0b1011001));
    }
    public static int fun(int n){
        ArrayList<Integer> data = new ArrayList<>();
        while (n > 0){
            data.add(n&1);
            n= n>>1;
        }
        Collections.reverse(data);
        int slow = 0;
        int fast = 1;
        int max = 0;
        while (fast < data.size()){
            fast = slow+1;
            while (fast < data.size()){
                if (data.get(fast) == 1){
                    max = Math.max(max,fast-slow);
                    slow = fast;
                    fast++;
                    break;
                }else {
                    fast++;
                }
            }
        }
        return  max;
    }
}
