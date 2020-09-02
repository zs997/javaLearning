package cn.zs.practice.shopee;

import sun.applet.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main1 {
    public static void main(String[] args) {
        Main1 main1 = new Main1();
        int [] data = {1,3,5,2};
        int minScore = main1.getMinScore(data);
        System.out.println(minScore);

    }
    public int getMinScoreDp(int [] gz){
        if (gz == null ||gz.length <= 1 )
            return 0;
       if (gz.length ==2)
           return gz[0]+gz[1];
        int dp [] = new int[gz.length];
        dp[0] = 0;
        dp[1] = gz[0]+gz[1];
        for (int i = 2; i < gz.length; i++) {
            //dp[i] = Math.min(dp[i-1]+gz[i],)
        }
        return -1;
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
