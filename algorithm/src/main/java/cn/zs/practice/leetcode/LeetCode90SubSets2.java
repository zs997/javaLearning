package cn.zs.practice.leetcode;
import java.util.*;
public class LeetCode90SubSets2 {
    public static void main(String[] args) {
        LeetCode90SubSets2 leecode = new LeetCode90SubSets2();
        int [] s = {1,2,2};
       // ArrayList<ArrayList<Integer>> subsets = leecode.subsets(s);
        ArrayList<ArrayList<Integer>> subsets = leecode.subsets(s);
        for (int i = 0; i < subsets.size(); i++) {
            ArrayList<Integer> list = subsets.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print(list.get(j));
            }
            System.out.println();
        }
    }
    public  ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Arrays.sort(S);
        helperDupli(S,0,true,new ArrayList<>(),res);
        return  res;
    }

    private void helperDupli(int[] s, int curIndex,boolean taken, ArrayList<Integer> cur, ArrayList<ArrayList<Integer>> res) {
        if(curIndex == s.length){
            res.add(new ArrayList<>(cur));
        }else{

            //CurIndex处的 s元素不加入集合内
            helperDupli(s,curIndex+1,false,cur,res);
            //taken 为true表示上一个curIndex处元素，加入了。此时，此处若是重复元素，他有加入的机会。不是重复的元素更有机会
            //taken false 表示上一个curIndex处元素，不加入。此时，此处若是重复元素，不能加入。即两个条件都不满足。。
            //若不是重复元素 可以加入
            //回溯剪枝而已
            if(taken ||s[curIndex-1]  != s[curIndex]){
                //curIndex 处 s元素加入集合内
                cur.add(s[curIndex]);
                helperDupli(s,curIndex+1,true,cur,res);
                cur.remove(cur.size()-1);
            }
        }
    }





}

