package cn.zs.exam.pinduoduo;
import java.util.Scanner;
/*
    6*6的格子地
    输入一个矩阵matrix[][]表示
    matrix[i][j] == '#' 表示是空地 可以种植
    matrix[i][j] == '#' 表示有建筑物 不能种植
    给6种植物 要求每个植物不能与之上下左右一样
    问 一共的种植方案？
* */
public class GrowVegetables {
    private static int count = 0;
    public static void main(String[] args) {
        char [][] matrix = new  char[6][6];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i++) {
            matrix[i] = sc.nextLine().replace(" ","").toCharArray();
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        helper(matrix,0);
        System.out.println(count);


    }
    public static void helper(char [][] matrix,int no){
        if (no == 36){
            count++;
        }else {
            int i = no/6;
            int j = no%6;
            if (matrix[i][j] == '#'){
                //尝试放入0~5
                for (char ch = '0'; ch < '6'; ch++) {
                    if(isOk(matrix,i,j,ch)){
                        matrix[i][j] = ch;
                        helper(matrix,no+1);
                        matrix[i][j] = '#';
                    }
                }
            }else {
                helper(matrix,no+1);
            }

        }
    }

    public static boolean isOk(char [][] matrix,int i,int j,char ch){
        //* 障碍物 #可填 填写 1 2 3 4 5 6 对应的字符
        if (i < 0 || i > 5 || j < 0|| j > 5|| matrix[i][j] != '#'){
            return false;
        }
        if(i == 0){
            if (j == 0){
                return true;
            }
            return matrix[i][j-1] != ch;
        }
        if (j == 0){
            return matrix[i-1][j] != ch;
        }

        return (matrix[i-1][j] != ch) && matrix[i][j-1] != ch;
    }
}
/*
*
 # * * * * *
 * * * * * *
 * * * * * *
 * * * * * *
 * * * * * *
 * * * * * #
 36
 * */

/*
*
# # * * * *
# # * * * *
* * * * * *
* * * * * *
* * * * * *
* * * * * *
630
* */