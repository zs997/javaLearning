package cn.hsq.jd;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description  给你一个地图，其中‘S’表示起点，'T'表示终点。‘#’代表墙壁表示无法通过,
 * '.’表示路可以花一分钟通过。请你求出从起点到终点需要花费的最短时间。如果无法到达终点请输出-1。
 * 样例
 * input:map=[['S','.'],['#','T']]
 * output:t=2
 * @Author huanshunqi
 * @Date 2020/9/17 20:02
 * @Version 1.0
 **/
class node{
    int x,y,t;
}
public class Solution {

    /**
     * @param maps:
     * @return: nothing
     */
    public int theMazeIV(char[][] maps) {
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
                if (maps[i][j] == 'T'){
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
