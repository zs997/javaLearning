package cn.zs.exam.pinduoduo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
*     3 4
       0 1 0 0
       1 0 1 1
       0 1 0 0

       5
* */
public class YeMan2 {
    static int idx = 2;
    static int cnt = 0;
    static int max = 0;
    static int[] pos = new int[]{0,1,0,-1,0};
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char data [][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int nextInt = scanner.nextInt();
               // char i1 = (char)nextInt + '0';
                String s = Integer.toString(nextInt);
                data[i][j] = s.charAt(0);
            }
        }
     //   char [][] grid = {{'0','1','0','0'},{'1','0','1','1'},{'0','1','0','0'}};
        System.out.println(numIslands(data));

    }
    public static int numIslands(char[][] grid) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0,count = 0,x,y;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    infect(grid, i, j);
                    //记录每一类 分别有多少个
                    map.put(idx,cnt);
                    max = Math.max(max,cnt);
                    ++idx;
                    cnt = 0;
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                count = 0;
                sum = 0;
                //记录四周的类别
                set.clear();
                //穷举可以放置棋子的地方 他的四周 看看分别属于哪一类
                if(grid[i][j] == '0'){
                    for(int k=0;k<4;k++){
                        x = i + pos[k]; y = j + pos[k+1];
                        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0'||set.contains(grid[x][y]-'0'))
                            continue;
                        set.add(grid[x][y]-'0');
                        //周围不同的数目
                        count++;
                        sum += map.getOrDefault(grid[x][y]-'0',0);
                    }
                }
                //如果还有其他的队伍 可以将其他的任意一个 放置过来 总和加1
                //否则 只是将周边其中一个队伍拿一个过来 不能 加1
                if(map.size()>count)
                    ++sum;
                max = Math.max(max,sum);
            }
        }
        return max;
    }
    //感染函数
    public static void infect(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return;
        }
        ++cnt;
        //将不同的团队 改成不一样的编号
        grid[i][j] = (char) (idx+'0');
        for(int k=0;k<4;k++)
            infect(grid, i + pos[k], j + pos[k+1]);
    }

}
