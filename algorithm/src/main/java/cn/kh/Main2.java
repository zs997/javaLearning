package cn.kh;

import java.util.Scanner;

public  class Main2 {
    public static long minTime = Long.MAX_VALUE;
    public static int[][] direction = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            char[][] array = new char[n][n];
            for (int i = 0 ; i < n ; i ++){
                String str = sc.next();
                for (int j = 0 ; j < n ; j ++){
                    array[i][j] = str.charAt(j);
                }
            }
            deepSearch(array,0,0,0,k);
            if (minTime == Long.MAX_VALUE){
                System.out.println("No solution");
            }else{
                System.out.println(minTime);
            }
        }
    }

    /**
     * 表示X星人此时到达row,column所花费时间
     */
    public static void deepSearch(char[][] map,int row,int column,int time,int k){
        if (row == map.length - 1&& column == map[0].length - 1){
            minTime = Math.min(minTime,time);
            return;
        }
        //标记此位置已经走过
        char c = map[row][column];
        map[row][column] = '2';
        for (int i = 0 ; i < direction.length ; i ++){
            int newRow = row + direction[i][0];
            int newColumn = column + direction[i][1];
            if (newRow < 0 || newRow >= map.length || newColumn < 0 || newColumn >= map[0].length ||map[newRow][newColumn] == '1' || map[newRow][newColumn] == '2'){
                continue;
            }
            if (map[newRow][newColumn] == '#'){
                deepSearch(map,newRow,newColumn,time + k + 1,k);
            }else{
                deepSearch(map,newRow,newColumn,time + 1,k);
            }
        }
        map[row][column] = c;
    }
}