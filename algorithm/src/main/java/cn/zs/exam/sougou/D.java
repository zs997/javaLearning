package cn.zs.exam.sougou;

import java.util.Arrays;
import java.util.Scanner;
/*
20200905 搜狗
* */
public class D {
    public static void p3() {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split(",");
        int[] nums = new int[3];
        nums[0] = Integer.parseInt(split[0]);
        nums[1] = Integer.parseInt(split[1]);
        nums[2] = Integer.parseInt(split[2]);
        Arrays.sort(nums);
        int min = nums[0];
        for (int i = 0; i < 3; i++) {
            nums[i] -= min;
        }
        int res = min;
        res += p3f(nums);
        System.out.println(res);
    }

    private static long p3f(int[] nums) {
        if (nums[2] == 0) return 0;
        else if (nums[1] == 0) {
            return nums[2] / 5;
        } else {
            if (nums[2] >= 3 * nums[2]) {
                return nums[1] + (nums[2] - 3 * nums[1]) / 5;
            } else {
                int res = 0;
                while (nums[2] < 3 * nums[1]) {
                    if (nums[1] >= 2) {
                        nums[1] -= 2;
                        nums[2] -= 2;
                        res++;
                    } else return res;
                }
                return res + nums[1] + (nums[2] - 3 * nums[1]) / 5;
            }
        }
    }

}
