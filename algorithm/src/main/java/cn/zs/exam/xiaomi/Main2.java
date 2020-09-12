package cn.zs.exam.xiaomi;

import java.util.Scanner;
/*
*   矩阵中的单词
** */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();
        char board [][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board,word));
    }
    static boolean exist(char board [][],String word){
        if (word.length() == 0)
            return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board,word,i,j,0))
                    return true;
            }
        }
        return false;
    }
   static boolean search(char board [][],String word,int i ,int j,int k){
        if (k >= word.length())
            return  true;
        if (i < 0 ||i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k))
            return false;
        board[i][j] += 256;
        boolean result = search(board,word,i-1,j,k+1)||search(board,word,i+1,j,k+1)
                || search(board,word,i,j-1,k+1) || search(board,word,i,j+1,k+1);
        board[i][j] -= 256;
        return result;
    }
}
