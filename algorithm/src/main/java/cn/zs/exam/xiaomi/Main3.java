package cn.zs.exam.xiaomi;

import java.util.Scanner;
/*
*   矩阵中的单词
* */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };
        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {
        if(word.length() == 0) return false;
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j] && backtrack(i, j, 0, word, isVisited, board)) return true;
            }
        }
        return false;
    }
    public static boolean backtrack(int i, int j, int idx, String word, boolean[][] isVisited, char[][] board) {
        if (idx == word.length()) return true;
        if (i >= board.length || i < 0 || j >= board[0].length ||
                j < 0 || board[i][j] != word.charAt(idx) || isVisited[i][j]) return false;
        isVisited[i][j] = true;
        if(backtrack(i+1,j,idx+1,word,isVisited,board) ||
                backtrack(i-1,j,idx+1,word,isVisited,board) ||
                backtrack(i,j+1,idx+1,word,isVisited,board) ||
                backtrack(i,j-1,idx+1,word,isVisited,board)) return true;
        isVisited[i][j] = false;
        return false;
    }
}

