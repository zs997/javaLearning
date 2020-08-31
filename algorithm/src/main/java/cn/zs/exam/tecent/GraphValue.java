package cn.zs.exam.tecent;
import java.util.Scanner;
/**
 *      腾讯秋招
 *      图中的两个点，如果有相同的临边集合，那么每一对这样的组合对图价值+1
 *      问一个图 价值是多少
 *      测试数据
 *      第一行 6 6个点
 *      5 5个边
 *      剩下的行 表示点之间的
 *    in
6 5
1 3
2 3
3 5
4 5
5 6
      out
       2


 4 3
 1 2
 2 3
 2 4
 out
 3
 *
 *
 *
 *
 * */
public class GraphValue {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        //点数
        //int n = 4;
       int n = sc.nextInt();
        //边数
     //   int m = 3;
        int m = sc.nextInt();
        //
        boolean [][] graph = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int j = sc.nextInt();
            int k = sc.nextInt();
            graph[j][k] = true;
            graph[k][j] = true;
        }

        //每一个点的集合
        String sets [] = new String[n+1];

        for (int i = 1; i <= n ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                if (i == j)
                    continue;
                if (graph[i][j]){
                    sb.append(j+",");
                }
            }
            sets[i] = sb.toString();
        }
        int value = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = i+1; j <= n ; j++) {
                if ((!sets[i].equals(""))&& (sets[i].equals(sets[j]))){
                    value++;
                }
            }
        }
        System.out.println(value);

    }
}
