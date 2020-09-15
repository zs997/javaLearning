package cn.zhushuai;

import java.util.ArrayList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

    }
    public static int fun(int data[][]){
        int dis[][]=  new int[data.length][data[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j] == 1 || data[i][j] == 2
                ||data[i][j] == 3 || data[i][j] == 4){
                    search(data,dis,i,j);
                }
            }
        }
        return 1;
    }
    private static void search(int [][] data,int dis[][],int i,int j){
        dis[i][j] = 0;
        ArrayList<Point> queue =  new ArrayList<>();
        queue.add(new Point(i,j));
        int count  = 1;
        int distance = 0;
        while (!queue.isEmpty()){
            Point remove = queue.remove(0);
            count--;

            int x = remove.x;
            int y = remove.y;
            dis[x][y] += distance;
            if (count == 0){
                distance++;
            }
            if (x-1 >= 0 && data[x-1][y] == 0){
                queue.add(new Point(x-1,y));
                count++;
            }
            if (y-1 >= 0 && data[x][y-1] == 0){
                queue.add(new Point(x,y-1));
                count++;
            }
            if (x+1 < data.length && data[x+1][y] ==0){
                queue.add(new Point(x+1,y));
            }
            if (y+1 <data[0].length && data[x][y+1] == 0){
                queue.add(new Point(x,y+1));
            }
        }
    }
}
class  Point{
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
    int x;
    int y;
    int dis;
}