package cn.zs.practice.leetcode;

import java.util.Arrays;
/*
*   1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1
* */
public class LeetCode31NextPermutation {
    public void nextPermutation(int[] num) {
        if(num == null || num.length == 0){return ;}

        int last = num.length - 2;
        while(last >=0 && num[last] >= num[last + 1]){
            last--;
        }
        if(last < 0){
            Arrays.sort(num);
            return;
        }
        int i = last + 1;
        while(i < num.length && num[i] > num[last]){
            i++;
        }
        int temp = num[last];
        num[last] = num[i-1];
        num[i-1] = temp;
        //swap(last,i-1);
        //sort(last+1,num.length -1);
        Arrays.sort(num,last + 1,num.length);
    }
}
