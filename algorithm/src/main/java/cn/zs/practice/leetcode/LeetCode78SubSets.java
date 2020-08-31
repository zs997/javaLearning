package cn.zs.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78SubSets {
    public static void main(String[] args) {
        int [] s = {1,2,3};
        List<List<Integer>> res = new ArrayList<>();
        helper2(s,0,new ArrayList<Integer>(),res);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> integers = res.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(integers.get(j)+" ");
            }
            System.out.println();
        }
    }
    //方案1 针对坐标
    public static void helper(int [] s, int curIndex, ArrayList<Integer> cur, List<List<Integer>> res){
        res.add(new ArrayList<>(cur));
        for(int i = curIndex;i < s.length;i++){
            cur.add(s[i]);
            helper(s,i+1,cur,res);
            cur.remove(cur.size()-1);
        }
    }
    //方案2  每一个都有两种选择 针对元素
    private static void helper2(int[] s, int curIndex, ArrayList<Integer> cur, List<List<Integer>> res) {
        if(curIndex == s.length){
            res.add(new ArrayList<>(cur));
        }else{
            //CurIndex处的 s元素不加入集合内
            helper2(s,curIndex+1,cur,res);

            //curIndex 处 s元素加入集合内
            cur.add(s[curIndex]);
            helper2(s,curIndex+1,cur,res);
            cur.remove(cur.size()-1);
        }
    }

}
