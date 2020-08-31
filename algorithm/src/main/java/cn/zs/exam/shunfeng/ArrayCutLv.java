package cn.zs.exam.shunfeng;

import java.util.Scanner;

public class ArrayCutLv {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] num = new int[n + 1];
            int[] sum = new int[n + 1];
            //value[i][j]  前i分割成j块 最大费用
            int[][] value = new int[n + 1][k + 1];
            //对应的 最大分割
            int[][] arr = new int[n + 1][k + 1];
            value[0][0] = 0;
            sum[0] = 0;
            for (int i = 1; i <= n; i++) {
                num[i] = sc.nextInt();
                sum[i] = num[i] + sum[i - 1];
            }
            arr[0][0] = 0;
            //前i个分割成为1个
            for (int i = 1; i <= n; i++) {
                value[i][1] = sum[i] * sum[i];
                arr[i][1] = i;
            }
            //最外层计算分割成i1个
            for (int i1 = 2; i1 <= k; i1++) {
                //至少要有i1个
                for (int j = i1; j <= n; j++) {
                    // 前j个 分成i1 个
                    value[j][i1] = 0;
                    arr[j][i1] = Integer.MAX_VALUE;
                    //从i点分  为啥是i1-1起点？ 减小计算量 分割成2段 则从1开始 1单独拿下
                    // 前j个在计算分成4段时候 前三个分成1 2 3 已经计算过
                    for (int i = i1 - 1; i < j; i++) {
                        //不算入i坐标
                        int tmp = sum[j] - sum[i];
                        tmp = tmp * tmp;
                        //前i点分割成i1-1个数组
                        if ((value[i][i1 - 1] + tmp) > value[j][i1]) {
                            value[j][i1] = value[i][i1 - 1] + tmp;
                            arr[j][i1] = Math.max(arr[i][i1 - 1], j - i);
                        }
                        else if ((value[i][i1 - 1] + tmp) == value[j][i1]) {
                            arr[j][i1] = Math.min(arr[j][i1], Math.max(arr[i][i1 - 1], j - i));
                        }
                    }
                }
            }
            System.out.println(value[n][k] + " " + arr[n][k]);
        }
    }
}
