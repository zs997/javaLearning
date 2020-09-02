package cn.zs.exam.huawei;

import java.util.ArrayList;
import java.util.Scanner;
/*
4,5
SSHHH
SSHHH
HHSHH
HHHSS
* */
public class Lakes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int m =Integer.valueOf(split[0]);
        int n =Integer.valueOf(split[1]);
        char data [][] = new char[m][n];
        for (int i = 0; i < data.length; i++) {
            String s1 = sc.nextLine();
            String trim = s1.trim();
            for (int j = 0; j < trim.length(); j++) {
                data[i][j] = trim.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 'S'){
                    //将与S联通的换成A
                    infect(data,i,j);
                    count++;
                }
            }
        }
        System.out.println(count);

//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data[i].length; j++) {
//                System.out.print(data[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    public static void infect(char data[][],int i,int j){
        int n = data[0].length;
        ArrayList<Point> queue = new ArrayList<>();
        queue.add(new Point(i,j));
        data[i][j] = 'A';
        while (!queue.isEmpty()){
            Point remove = queue.remove(0);
            int x = remove.x;
            int y = remove.y;
            if (x-1 >= 0 && data[x-1][y] == 'S'){
                queue.add(new Point(x-1,y));
                data[x-1][y] = 'A';
            }
            if (x+1 < data.length && data[x+1][y] == 'S'){
                queue.add(new Point(x+1,y));
                data[x+1][y] = 'A';
            }
            if (y-1 >= 0 && data[x][y-1] == 'S'){
                queue.add(new Point(x,y-1));
                data[x][y-1] = 'A';
            }
            if (y+1 < data[0].length && data[x][y+1] == 'S'){
                queue.add(new Point(x,y+1));
                data[x][y+1] = 'A';
            }
        }

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
