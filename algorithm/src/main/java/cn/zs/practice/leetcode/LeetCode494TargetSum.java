package cn.zs.practice.leetcode;

import java.util.HashMap;
/*
*   计算 num[] 中 每个数字前面可以放+号 可以放- 号 问一共有多少方案使得
*   总和是target
* */
public class LeetCode494TargetSum {
    public static void main(String[] args) {
        int num[] = {1,1,1,1,1};
        System.out.println(findTargetSumWays2(num,3)) ;
        System.out.println(findTargetSumWays1(num,3));
    }
      static int result = 0;

    /* 主函数 */
    static int findTargetSumWays1(int[] nums, int target) {
        if (nums.length == 0) return 0;
        backtrack(nums, 0, target);
        return result;
    }

    /* 回溯算法模板 */
    static void  backtrack(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
            if (rest == 0) {
                // 说明恰好凑出 target
                result++;
            }
            return;
        }
        // 给 nums[i] 选择 - 号

        // 穷举 nums[i + 1]
        backtrack(nums, i + 1, rest-nums[i]);
        // 撤销选择


        // 给 nums[i] 选择 + 号

        // 穷举 nums[i + 1]
        backtrack(nums, i + 1, rest+nums[i]);
        // 撤销选择

    }
    static int findTargetSumWays2(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return dp(nums, 0, target);
    }
    // 备忘录
    //这其实是dp的本质
    public static HashMap<String, Integer> memo = new HashMap<>();
    //这个dp表示 从i坐标开始到最后 rest剩余 有几种方案
    public static int dp(int[] nums, int i, int rest) {
        // base case
        if (i == nums.length) {
            if (rest == 0) return 1;
            return 0;
        }
        // 把它俩转成字符串才能作为哈希表的键
        String key = i + "," + rest;
        // 避免重复计算
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        // 还是穷举
        int result = dp(nums, i + 1, rest - nums[i]) + dp(nums, i + 1, rest + nums[i]);
        // 记入备忘录
        //System.out.println(key+" "+rest);
        memo.put(key, result);
        return result;
    }
    /*
            sum(A) - sum(B) = target
            sum(A) = target + sum(B)
            sum(A) + sum(A) = target + sum(B) + sum(A)
            2 * sum(A) = target + sum(nums)
            综上，可以推出 sum(A) = (target + sum(nums)) / 2，
            也就是把原问题转化成：nums 中存在几个子集 A，
            使得 A 中元素的和为 (target + sum(nums)) / 2
    * */
   static int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;
        // 这两种情况，不可能存在合法的子集划分
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        return subsets(nums, (sum + target) / 2);
    }
    /* 计算 nums 中有几个子集的和为 sum */
   static int subsets(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        // base case
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i-1]) {
                    // 两种选择的结果之和
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-nums[i-1]];
                } else {
                    // 背包的空间不足，只能选择不装物品 i
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
