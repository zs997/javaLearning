package cn.hsq.jd;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class node{
    int x,y,t;
}
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int T = Integer.parseInt(s);
        for (int i = 0; i < T; i++) {
            String s1 = scanner.nextLine();
            String[] s2 = s1.split(" ");

            int n = Integer.parseInt(s2[0]);
            int m = Integer.parseInt(s2[1]);
            char [][] map = new char[n][m];
            for (int i1 = 0; i1 < n; i1++) {
                String s3 = scanner.nextLine();
                for (int i2 = 0; i2 < s3.length(); i2++) {
                    map[i1][i2] = s3.charAt(i2);
                }
            }
            int res = findgirl(map);
            if (res == -1){
                System.out.println("NO");
            }else {
                System.out.println("YES");
            }

        }



    }
    public static int findgirl(char[][] maps) {
        node start = new node();
        node end = new node();
        Queue<node> queue=new LinkedList<>();
        Boolean[][] visited=new Boolean[maps.length][maps[0].length];
        for (int i = 0;i < maps.length;i++){
            for (int j = 0;j < maps[i].length;j++){
                visited[i][j] = true;
                if (maps[i][j] == 'S'){
                    start.x = i;
                    start.y = j;
                    start.t = 0;
                }
                if (maps[i][j] == 'E'){
                    end.x = i;
                    end.y = j;
                    end.t = 0;
                }
            }
        }
        queue.add(start);
        node v2;
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        visited[start.x][start.y]=false;
        while (queue.size()!=0){
            v2=queue.poll();

            if (v2.x == end.x && v2.y == end.y){
                return v2.t;
            }

            for (int i = 0; i < 4 ; i++) {
                int x1 = v2.x + dir[i][0];
                int y1 = v2.y + dir[i][1];
                if (x1 < maps.length && x1 >= 0 && y1 < maps[0].length && y1 >= 0 && visited[x1][y1] && maps[x1][y1]!='#'){
                    node temp = new node();
                    temp.x = x1;
                    temp.y = y1;
                    temp.t = v2.t + 1;
                    visited[temp.x][temp.y]=false;
                    queue.add(temp);
                }

            }
        }
        return -1;
    }
}
