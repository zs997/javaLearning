package cn.zs.practice.leetcode;

public class LeetCode55JumpGame {
    public static void main(String[] args) {
        int a[] ={0,1};
        canJump(a);
    }
    public static boolean canJump (int[] A) {
        // write code here
        int maxReach = 0;
        int i = 0;
        for(;i < A.length && i <= maxReach;i++){
            maxReach = Math.max(maxReach,i+A[i]);
        }
        if(i < A.length-1){
            return false;
        }
        return true;
    }
}
