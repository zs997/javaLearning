package cn.zs.exam.pinduoduo;
import java.util.ArrayList;
/*
拼多多20200901笔试题
全是0 1 的矩阵
1上下左右连起来的 视为一个整体
对于一个矩阵 最多点形成的整体
的点数 记为最大士兵数
求 一个初始矩阵
交换任意1对 1和0
使得士兵数最大
求最大的数目
暴力法了
不好使

* */
import java.util.Scanner;
/*
      in: 3 4
       0 1 0 0
       1 0 1 1
       0 1 0 0
      out: 5

      int : 4 4
       1 0 1 1
       1 1 0 1
       0 0 0 0
       1 1 1 1
      out: 8
* */
public class YeMan {
    static  int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int data [][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                data[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == 1){
                    swap(data,i,j);
                }
            }
        }
        System.out.println(max);
    }
    public static void swap(int data[][],int x,int y){
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                //可以交换
                if (data[i][j] == 0){
                    data[i][j] = 1;
                    data[x][y]  = 0;
                    int temp = maxSolders(data);
                    max = Math.max(temp,max);
                    data[i][j] = 0;
                    data[x][y]  = 1;
                }
            }
        }
    }
    public static int maxSolders(int data[][]){
        int max = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 1){
                    //从这一点广度搜索
                    boolean visited [][] = new boolean[data.length][data[0].length];
                   // visited[i][j] = true;
                    int count = 0;
                    ArrayList<Point> queue = new ArrayList<>();
                    queue.add(new Point(i,j));
                    visited[i][j] = true;
                    while (!queue.isEmpty()){
                        Point remove = queue.remove(0);
                        //访问的坐标
                        int x = remove.x;
                        int y = remove.y;
                        //visited[x][y] = true;
                        count++;
                        //上
                        if (x-1 >= 0 && !visited[x-1][y] && data[x-1][y] == 1){
                            visited[x-1][y] = true;
                            queue.add(new Point(x-1,y));
                        }
                        //下
                        if (x+1 < data.length && !visited[x+1][y] && data[x+1][y] == 1){
                            visited[x+1][y] = true;
                            queue.add(new Point(x+1,y));
                        }
                        //左
                        if (y-1 >= 0 && !visited[x][y-1] && data[x][y-1] == 1){
                            visited[x][y-1] = true;
                            queue.add(new Point(x,y-1));
                        }
                        if (y+1 < data[0].length && !visited[x][y+1] && data[x][y+1] == 1){
                            visited[x][y+1] = true;
                            queue.add(new Point(x,y+1));
                        }

                    }
                    max = Math.max(max,count);
                }
            }
        }
        return max;
    }

}
class Point{
    int x;
    int y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }

}
