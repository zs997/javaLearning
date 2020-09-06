package cn.zs.exam.bilibili;

public class Main1 {
    public static int longestOnes(int[] A, int K) {
        int left = 0, right = 0;
        int max = 0;
        int zero = 0;
        while (right != A.length) {
            if (A[right++] == 0) {
                zero++;
            }
            //判定条件，0的个数大于K
            while (zero > K) {
                if (A[left++] == 0) {
                    --zero;
                }
            }
            int count = right - left;
            max = max > count ? max : count;
        }
        return max;
    }
}
