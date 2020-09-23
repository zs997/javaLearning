package cn.kh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        List<String> res = new ArrayList<>();
        for(int k=0;k<T;k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[n][m];
            int startx = 0,starty = 0,endx = 0,endy = 0;
            for (int i = 0; i < n; i++) {
                String tmp = sc.nextLine();
                for (int j = 0; j < m; j++) {
                    map[i][j] = tmp.charAt(j);
                    if(map[i][j]=='S'){
                        startx = i;
                        starty = j;
                    }
                    if(map[i][j]=='E'){
                        endx = i;
                        endy = j;
                    }
                }
            }
            if(dfs(map,startx,starty,endx,endy)){
                res.add("YES");
            }else{
                res.add("NO");
            }
        }
        for(String q : res){
            System.out.println(q);
        }
    }

    public static boolean dfs(char[][] map,int i,int j,int endx,int endy){
        if(i==endx&&j==endy) {
            return true;
        }
        if(i<0||i>=map.length||j<0||j>=map[0].length||map[i][j]=='#'||map[i][j]=='2'){
           return false;
        }
        //标记此位置已经走过
        char c = map[i][j];
        map[i][j] = '2';
        if(dfs(map,i+1,j,endx,endy)) return true;
        if(dfs(map,i-1,j,endx,endy)) return true;
        if(dfs(map,i,j-1,endx,endy)) return true;
        if(dfs(map,i,j+1,endx,endy)) return true;
        map[i][j] = c;
        return false;
    }
}
