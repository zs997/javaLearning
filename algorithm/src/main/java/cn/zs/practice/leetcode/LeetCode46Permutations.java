package cn.zs.practice.leetcode;
import java.util.ArrayList;
import java.util.List;

public class LeetCode46Permutations {
    public static void main(String[] args) {
       // permutation2(new char[]{'1','3','8'},0);
        permutation3();
    }
    public ArrayList<ArrayList<Integer>> permutation1(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList();
        if(num == null || num.length == 0 ){return res;}

        boolean visited [] = new boolean[num.length];
        helper1(num,visited,new ArrayList<Integer>(),res);
        return res;
    }
    public  void helper1(int [] num, boolean [] visited, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> res){
        if(curList.size() == num.length){
            res.add(new ArrayList<Integer>(curList));
            return;
        }else{
            for(int i = 0; i < num.length; i++){
                if(!visited[i]){
                    visited[i] = true;
                    curList.add(num[i]);
                    helper1(num,visited,curList,res);
                    curList.remove(curList.size()-1);
                    visited[i] = false;
                }
            }
        }
    }
    //交换法
    public static void permutation2(char[] arr, int decision) {
        // 有效性判断
        if (arr == null || decision < 0 || decision > arr.length)
            return;
        //  如果现在要确定的位置已经超出了数组下标，说明现在已经生成了一种排列
        if (decision == arr.length) {
            System.out.println(new String(arr));
            return;
        }
        //每一个数字都可以放到decision位置
        //再考虑decision+1位置
        //  现在要确定的位置的元素可以是数组中从当前位置开始往后的任意元素
        for (int i = decision; i < arr.length; i++) {
            // 将选取的元素放入当前要确定的位置中
            {
                char t = arr[decision];
                arr[decision] = arr[i];
                arr[i] = t;
            }
            // 确定后继续确定下一个位置
            permutation2(arr, decision + 1);
            // 回溯
            {
                char t = arr[decision];
                arr[decision] = arr[i];
                arr[i] = t;
            }
        }
    }
    public static void permutation3(){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int nums [] = new int[]{1,2,3};
        back(nums,new ArrayList<Integer>(),res);
        for (int i = 0; i < res.size(); i++) {
            List<Integer> integers = res.get(i);
            for (int j = 0; j < integers.size(); j++) {
                System.out.print(integers.get(j)+" ");
            }
            System.out.println();
        }
    }
    public static void back(int[] nums,List<Integer>list, List<List<Integer>> res){
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for(int i=0;i<nums.length;i++){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
                back(nums,list,res);
                list.remove(list.size()-1);
            }
        }
    }

}