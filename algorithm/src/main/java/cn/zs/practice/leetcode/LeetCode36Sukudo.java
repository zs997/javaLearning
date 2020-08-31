package cn.zs.practice.leetcode;

public class LeetCode36Sukudo {

    public static void main(String[] args) {
        char in [][] = new char[9][9];
    }

    public static boolean isValidSudoku(char[][] board) {

        if(board == null || board.length != 9 || board[0].length != 9){return false;}

        //判断所有行
        for(int row = 0; row < 9; row ++){
            //对于某一行 要有一个判断用的数组
            boolean visited [] = new boolean[9];
            for(int i = 0;i < 9;i++){
                if(board[row][i] != '.'){
                    int temp = board[row][i] - '1';
                    if(visited[temp] == false){
                        visited[temp] = true;
                    }else{
                        return false;
                    }
                }
            }
        }

        //判断所有列
        for(int col = 0; col < 9; col ++){
            //对于某一列 要有一个判断用的数组
            boolean visited [] = new boolean[9];
            for(int i = 0;i < 9;i++){
                if(board[i][col] != '.'){
                    int temp = board[i][col] - '1';
                    if(visited[temp] == false){
                        visited[temp] = true;
                    }else{
                        return false;
                    }
                }
            }
        }

        //判断矩阵
        int range [] = {0,3,6};
        for(int rowOff :range){
            for(int colOff :range){
                boolean visited [] = new boolean[9];
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        int temp = board[rowOff + i][colOff + j] - '1';
                        if(visited[temp] == false){
                            visited[temp] = true;
                        }else{
                            return false;
                        }
                    }
                }
            }
        }

        return true;

    }
}
