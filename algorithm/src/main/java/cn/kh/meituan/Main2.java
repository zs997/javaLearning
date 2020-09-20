package cn.kh.meituan;

import java.util.Scanner;

public class Main2 {
    public static int[][] direction = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            char[][] map = new char[n][m];
            int beginRow = 0,beginColumn = 0;
            for (int i = 0 ; i < n ; i ++){
                String str = sc.next();
                for (int j = 0 ; j < m ; j ++){
                    map[i][j] = str.charAt(j);
                    if (map[i][j] == 'S'){
                        beginRow = i;
                        beginColumn = j;
                    }
                }
            }
            String paths = sc.next();
            int score = 0;
            for (int i = 0 ; i < paths.length() ; i ++){
                char path = paths.charAt(i);
                switch (path){
                    case 'W':
                        int newRow = beginRow + direction[0][0];
                        int newColumn = beginColumn + direction[0][1];
                        if (newRow < 0 || newRow >= n || newColumn < 0 || newColumn >= m || map[newRow][newColumn] == '#'){
                            break;
                        }
                        beginRow = newRow;
                        beginColumn = newColumn;
                        if (map[beginRow][beginColumn] == 'O'){
                            score += p;
                        }
                        if (map[beginRow][beginColumn] == 'X'){
                            score -= q;
                            map[beginRow][beginColumn] = '+';
                        }
                        break;
                    case 'S':
                        newRow = beginRow + direction[1][0];
                        newColumn = beginColumn + direction[1][1];
                        if (newRow < 0 || newRow >= n || newColumn < 0 || newColumn >= m || map[newRow][newColumn] == '#'){
                            break;
                        }
                        beginRow = newRow;
                        beginColumn = newColumn;
                        if (map[beginRow][beginColumn] == 'O'){
                            score += p;
                        }
                        if (map[beginRow][beginColumn] == 'X'){
                            score -= q;
                            map[beginRow][beginColumn] = '+';
                        }
                        break;
                    case 'A':
                        newRow = beginRow + direction[2][0];
                        newColumn = beginColumn + direction[2][1];
                        if (newRow < 0 || newRow >= n || newColumn < 0 || newColumn >= m || map[newRow][newColumn] == '#'){
                            break;
                        }
                        beginRow = newRow;
                        beginColumn = newColumn;
                        if (map[beginRow][beginColumn] == 'O'){
                            score += p;
                        }
                        if (map[beginRow][beginColumn] == 'X'){
                            score -= q;
                            map[beginRow][beginColumn] = '+';
                        }
                        break;
                    case 'D':
                        newRow = beginRow + direction[3][0];
                        newColumn = beginColumn + direction[3][1];
                        if (newRow < 0 || newRow >= n || newColumn < 0 || newColumn >= m || map[newRow][newColumn] == '#'){
                            break;
                        }
                        beginRow = newRow;
                        beginColumn = newColumn;
                        if (map[beginRow][beginColumn] == 'O'){
                            score += p;
                        }
                        if (map[beginRow][beginColumn] == 'X'){
                            score -= q;
                            map[beginRow][beginColumn] = '+';
                        }
                        break;
                    default:
                }
            }
            System.out.println(score);
        }
    }

}

