package cn.zs.exam.bilibili;
/**
 * 顺时针打印矩阵
 */


import java.util.ArrayList;
////[[1, 2, 3, 4], [5, 6, 7, 8], [9,10,11,12] ]
public class Main4 {
    public static void main(String[] args) {
        int [][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[] ints = printMatrix(matrix);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+" ");
        }

    }
    public static int[] printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int rows = 0;
        int rowe = matrix.length - 1;
        int cols = 0;
        int cole = matrix[0].length - 1;
        while (rows <= rowe && cols <= cole) {
            for (int i = cols; i <= cole; i++) {
                res.add(matrix[rows][i]);
            }
            for (int i = rows + 1; i <= rowe; i++) {
                res.add(matrix[i][cole]);
            }
            for (int i = cole - 1; i >= cols && rows < rowe; i--) {
                res.add(matrix[rowe][i]);
            }
            for (int i = rowe - 1; i > rows && cols < cole; i--) {
                res.add(matrix[i][cols]);
            }
            rows++;
            rowe--;
            cols++;
            cole--;
        }
        int[] num = new int[res.size()];
        int i = 0;
        for(int w : res){
            num[i++] = w;
        }
        return num;
    }
}
