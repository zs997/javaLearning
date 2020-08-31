package cn.zs.practice.dp;

public class PowerGenerationUnitAssignment1 {
    public static void main(String[] args) {
        //0不要，代表k = 1 2 3 4
        int dp [][] = new int [5][];
        //dpp[i].length 代表前i机组 一共最多可以多少负荷
        dp[1] = new int [4];
        dp[2] = new int [4+5];
        dp[3] = new int[4+5+4];
        dp[4]= new int [4+5+4+4];


        int data [][] = {{0,30,34,38},{0,31,34,37,40},{0,29,35,38},{0,28,35,37}};
        //初始化 第一列
        for(int i = 0;i < dp[1].length;i++){
            dp[1][i] = data[0][i];
        }
        //从前二组 开始考虑
        for(int i = 2;i <= 4; i++){
            //前i组 共分配j个
            for(int j = 0; j <dp[i].length;j++){
                //m是分到第二组的负荷 最小是1 最大不能超过前两个总负荷
                for(int m = 0;m <= j;m++){
                    //data[i][m]表示给第i组 m个产生的流量
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-m]+data[i][m]);
                }
            }
        }

    }
}
