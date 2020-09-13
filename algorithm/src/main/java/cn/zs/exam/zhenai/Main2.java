package cn.zs.exam.zhenai;

public class Main2 {
    public int saveZhenaiCoin (int[] grid) {
        // write code here
        int dp [] = new int[grid.length];
        dp[0] = grid[0];
        dp[1] =grid[1];
        for (int i = 2;i <grid.length;i++){
            dp[i] = Math.min(dp[i-1],dp[i-2])+grid[i];
        }
        return dp[dp.length-1];
    }
}
