package cn.zs.exam.shopee;

import java.util.ArrayList;

import java.util.Scanner;
/*
*   合并瓜子。一个数组对应位置元素表示该堆瓜子数目。
*   每次合并俩个数字。合并两个数的cost是，两个位置的数字和。
*   合并最终到1个数，问最小成本
* */
public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        int [] data = {1,3,5,2};
        int minScore = main1.getMinScore(data);
        System.out.println(minScore);

    }
    public int getMinScoreDp(int [] gz){
        Scanner sc = new Scanner(System.in);
        String res = sc.nextLine();
        res = res.substring(1,res.length()-1);
        String[] tmp = res.split(",");
        int[] num = new int[tmp.length+1];
        for(int i=1;i<=tmp.length;i++) {
            num[i] = Integer.parseInt(tmp[i-1]);
        }
        int n = tmp.length;
        //dp[i][j] 表示 数组中 第i个，到第j个数字，合并的最小成本
        int[][] dp = new int[n+1][n+1];
        int[] sum = new int[n+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        sum[0] = 0;
        for(int i=1;i<=n;i++){
            dp[i][i] = 0;
            sum[i] = num[i]+sum[i-1] ;
        }

        for(int len=1;len<n;len++){
            for(int i=1;i+len<=n;i++){
                int j = i+len;
                for(int k=i;k<j;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i][k]+dp[k+1][j]+sum[j]-sum[i-1]);
                }
            }
        }
        System.out.println(dp[1][n]);
        return dp[1][n];
    }
    public int getMinScore (int[] gz) {
        // write code here
        ArrayList<Integer> data = new ArrayList<>();
        for (int i = 0; i < gz.length; i++) {
            data.add(gz[i]);
        }
        getMinScoreHelper(data,0);

        return  minCost;
    }
    int minCost = Integer.MAX_VALUE;
    public void getMinScoreHelper(ArrayList<Integer> data,int curCost){
        if (data.size() == 1){
            if (curCost < minCost)
                minCost = curCost;
        }else {
           // Collections.sort(data);
            Integer remove = data.remove(data.size() - 1);
            //合并到i位置
            for (int i = 0; i < data.size(); i++) {
                int oldData = data.get(i);
                int temp = curCost + data.get(i)+remove;
                if (temp >= minCost)
                    continue;
                int newData = data.get(i) + remove;
                data.set(i,newData);
                getMinScoreHelper(data,temp);
                data.set(i,oldData);
            }
        }
    }
}
