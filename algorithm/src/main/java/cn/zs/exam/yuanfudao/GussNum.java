package cn.zs.exam.yuanfudao;
import java.util.Scanner;

public class GussNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

    }
    public static void guss(int n,int k ){
        int i = 1;
        int j = n;
    //    int mid = (i+j)/2;
        int sum =0;
        while (i < j){
            int mid = (i+j)/2;
            if (k <= 0){
                sum += mid;
            }
            i = mid +1;
            k--;
        }
    }
}
