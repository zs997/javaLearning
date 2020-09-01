package cn.zs.practice.leetcode;
/**
 * c0 = 1
 * Cn+1 =  求和( Ci*Cn-i) {i = 0 ~ n }
 *
 */

public class LeetCode96UniqueBinarySearchTrees {
    public static void main(String[] args) {

    }
    public int numTrees (int n) {
        // write code here
        //从1到n可以构建多少个二叉排序树？
        int dp [] = new int[n+1];
        //dp[0]表示没有元素的时候 作为乘法因子
        dp[0] = 1;
        //dp[1] = 1 表示只有一个节点 只能生成一个树
        dp[1] = 1;
        //外层循环 计算 i个点的结果，dp[i]
        for (int i = 2; i <= n; i++) {
           int m = i-1;
            for (int j = 0; j <= m; j++) {
                dp[i] += dp[j]*dp[m-j];
            }
        }
        return dp[n];
    }
}
