package cn.zs.exam.xiaohongshu;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println();
       // HashMap
    }
    public static  void minTimes(){
        Scanner sc = new Scanner(System.in);
        int dis = sc.nextInt();
        int minLen = sc.nextInt();
        int maxLen = sc.nextInt();
        int danger = sc.nextInt();
        int zones [] = new int[danger];
        for (int i = 0; i < danger; i++) {
            zones[i] = sc.nextInt();
        }
        int dp[] = new int[dis+1];


        System.out.println(dp[dis]);

    }
    public static  int[] f3(int array[]){
        if (array == null || array.length == 0)
            return new int[]{-1,-1};
        int last = -1;
        int first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < max){
                last = i;

            }else {
                max = Math.max(max,array[i]);
            }
            if (array[len-1-i] > min){
                first = len-1-i;
            }else {
                min= Math.min(min,array[len -1-i]);
            }
        }
        return  new int[]{first,last};
    }
    public static int[] f2(int array[]){
       int N = array.length;
       int start = -1;
       int end = -1;
       int min = Integer.MAX_VALUE;
       int max= Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (array[i] >= max){
                max = array[i];
            }else {
                end = i;

            }
        }
        if(end == -1)
            return new int[]{-1,-1};
        for (int i = end;i >= 0;i--){
            if (array[i] <= min){
                min = array[i];
            }else {
                start = i;
            }
        }
        return  new int[]{start,end};


    }
    public static int[] f1(int nums[]){
        int res [] =new int[2];
        int[] newNums = new int[nums.length];
        System.arraycopy(nums,0,newNums,0,nums.length);
        Arrays.sort(newNums);

        int left = 0;
        while (left <= nums.length-1 && nums[left] == newNums[left])
            left++;
        int right = nums.length-1;
        while (right > left && nums[right] == newNums[right]){
            right--;
        }
        if (left == right && left == nums.length){
            res[0] = -1;
            res[1] = -1;
        }else {
            res[0] = left;
            res[1]= right;
        }
        return res;
    }
}
