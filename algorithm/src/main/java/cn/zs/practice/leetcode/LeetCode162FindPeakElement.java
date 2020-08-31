package cn.zs.practice.leetcode;

import jdk.nashorn.internal.ir.ReturnNode;

import java.util.ArrayList;
/*      找出数组的局部峰值 索引 其中一个就行
 *       nums = [1,2,1,3,5,6,4]
 * */
public class LeetCode162FindPeakElement {
    public static void main(String[] args) {
        int nums[] = {1,2,1,3,5,6,4};
       // int peak = findPeak(nums);
        int peakRecurve = findPeakRecurve(nums, 0, nums.length - 1);
        System.out.println(peakRecurve);
        // System.out.println(peak+" "+nums[peak]);
    }
    public static  int findPeakRecurve(int nums[],int i,int j){
        if (i >= j){
            return -1;
        }
        int mid = (i+j)/2;
        if (nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
            return mid;
        }else if (nums[mid-1] < nums[mid]){
            return findPeakRecurve(nums,i,mid);
        }else{
            return findPeakRecurve(nums,mid,j);
        }

    }
    public static int findPeak(int nums[]){
        int i = 0;
        int j = nums.length-1;
        while (i <= j){
            int mid = (i+j)/2;
            if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid-1] > nums[mid]){
                j = mid;
            }else {
                i = mid;
            }
        }
        return -1;
    }
}
