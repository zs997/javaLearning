package cn.zs.exam.wangyi;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 网易2020 考试
 *给定长度为m的序列T，求一个长度为n且字典序列最小的排列，并且要求序列T为所求排列的子序列。题目保证这样的排序一定存在。
 * 就是说 n是排列的所有元素 1 2 3 ~~ n 这些元素的组合构成了所有排列
 * 然后给定一个残缺的排列
 * 比如 n= 5
 * 排列 324
 * 这时候要插入1 5
 * 使得形成的排列字典序最小
 * */
public class Pailie {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean used [] = new boolean[n+1];
        int m = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int num = sc.nextInt();
            list.add(num);
            used[num] = true;
        }
        int index = 0;
        //插入数据
        for (int i = 1; i <= n; i++) {
            if (!used[i]){
                while (index < list.size() && list.get(index) < i){
                    index++;
                }
                list.add(index,i);
            }
        }
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.print(list.get(list.size()-1));
    }

}
