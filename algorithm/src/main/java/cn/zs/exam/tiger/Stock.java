package cn.zs.exam.tiger;
import java.util.ArrayList;
public class Stock {
     int [] stocks ;
     int m;
     ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> combinationSum (int[] prices, int m) {
        // write code here
        stocks = prices;
        this.m = m;
        helper(0,0,new ArrayList<>());
        return res;
    }
    public  void helper(int index,int curValue,ArrayList<Integer> curList){
        if (index == stocks.length){
            if (curValue == m){
               res.add(new ArrayList<>(curList));
            }
        }else {
            //不加入
            helper(index+1,curValue,curList);
            //加入
            curList.add(stocks[index]);
            helper(index+1,curValue+stocks[index],curList);
            curList.remove(curList.size()-1);
        }
    }
}
