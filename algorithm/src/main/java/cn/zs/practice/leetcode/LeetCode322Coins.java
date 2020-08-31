package cn.zs.practice.leetcode;

import javax.crypto.interfaces.PBEKey;
import javax.swing.text.MutableAttributeSet;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LeetCode322Coins {
    public static void main(String[] args) {
        // coins 1 2 5   amount 11  out 3
        int coins [] ={1,2,5};
        int amount = 11;
        int i = coinChangeDfs(coins, amount);
        System.out.println(i);
    }
    private static int minCoins = Integer.MAX_VALUE;
    public static int coinChangeDfs(int [] coins,int amount){

        Arrays.sort(coins);
       /* int i = 0;
        int j = coins.length-1;
        int temp = 0;
        while (i < j){
           temp =  coins[i];
           coins[i] = coins[j];
           coins[j] = temp;
           i++;
           j--;
        }*/
        coinChangeDfsHelper(coins,amount,coins.length-1,0);
        return minCoins;
    }
    public static void coinChangeDfsHelper(int [] coins,int amount,int i,int count){
        if(amount==0){
            minCoins= Math.min(minCoins, count);
            return;
        }
        if(i==-1) return;
        //考虑i 从货币大到小 使用0~k个
        for(int k=amount/coins[i]; k>=0 && k+count < minCoins;k--){
            coinChangeDfsHelper(coins, amount-k*coins[i], i-1, count+k);
        }
    }
    public static int coinChange(int [] coins,int amount){
        //dp 表示凑成dp[i]最小的硬币数
        // dp[i] = min{dp[i-coins[j]]}+1
        int [] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount];
    }
}
