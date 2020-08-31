package cn.zs.practice.backtracking;

import java.util.Scanner;
/*
           a[1] = 3;
           a[2] = 6;
           a[3] = 4;
           a[4] = 3;
           a[5] = 4;
           a[6] = 5;
           a[7] = 6;
    a[i] = j 数组表示城市 i 可以到城市 j有传送门 ，但是需要代价A
    可以花 代价A+B 从i到达j-1
    也可以花 代价A+C 从i到达j+1
    问从1到达n 最小的代价
 *
* */
public class CityVisit {
    public static int minCost = 9999;
    public static int N = 7;
    public static int A = 1;
    public static  int B = 1;
    public static int C =1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        A = sc.nextInt();
        B = sc.nextInt();
        C = sc.nextInt();
            //a[0] 不用
        int a [] = new int[N+1];
        for (int i = 1; i < a.length; i++) {
            a[i] = sc.nextInt();
        }
        //3 6 4 3 4 5 6
//            a[1] = 3;
//            a[2] = 6;
//            a[3] = 4;
//            a[4] = 3;
//            a[5] = 4;
//            a[6] = 5;
//            a[7] = 6;
        boolean visited [] = new boolean[N+1];
          helper(a,visited,1,0);
        System.out.println(minCost);
    }
    //index表示访问过几个城市 to表示去哪个城市 visited表示访问了几个 cost 表示成本
    public static void helper(int a[],boolean visited[],int to,int cost){
        if(to == N){
            if(cost < minCost){
                minCost = cost;
            }
            return;
        }else{
            //这一步去to城市 之前不能去过
            if(visited[to] || cost > minCost){
                return;
            }
            visited[to] = true;
            //直接过去
            helper(a,visited,a[to],cost+A);
            if(a[to] < N){
                helper(a,visited,a[to]+1,cost+C+A);
            }
            if(a[to] >1){
                helper(a,visited,a[to]-1,cost+B+A);
            }
            visited[to] = false;

        }
    }
}
