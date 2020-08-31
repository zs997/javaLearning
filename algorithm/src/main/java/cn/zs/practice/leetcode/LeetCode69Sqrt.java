package cn.zs.practice.leetcode;

public class LeetCode69Sqrt {
    public static int sqrt(int x) {
        if(x <= 0){
            return 0;
        }
        int res = 1;
        int delta = 3;
        int index = 1;
        while(true){
            if(res == x){
                return index;
            }
            if(res > x){
                break;
            }
            res += delta;
            delta += 2;
            index ++;
        }
        return index - 1;
    }
}
