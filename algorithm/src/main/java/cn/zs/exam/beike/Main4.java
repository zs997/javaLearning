package cn.zs.exam.beike;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 打怪的游戏
 *  *
 * .最少的初始能量值。
 * 一个区间【-n, n】，怪兽位于【-1，-n】以及【1， n】区间，
 * 勇士消灭怪兽只能从中间往两边消灭，杀死一个怪兽需要消耗ai能量，
 * 杀死后获得bi能量，当勇士的能量值为<= 0，即为牺牲。
 * 给定数组a，b表示消耗和补给的能量，
 * 求最小的初始 能量能够使得勇士消灭所有的怪物。
 * 输入n(2)
 *  表示从 英雄所处的位置 向左向右 各有n个怪
 *  每打一个怪 要损失对应血量（第一行），同时会有恢复值（第二行）
 *  每次打怪不能隔着打
 *  问打完全部的怪  所需最小血量
 *  n=2
 *  6 5  | 8 9
 *  1 20 | 1 0
in:   2
  6 5  8 9
   1 20 1 0

输出： 6
 * */
public class Main4 {
    public static void main(String[] args) {

    }
    //法二
    public static void mota(){
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> costL = new ArrayList<>();
        ArrayList<Integer> costR = new ArrayList<>();
        ArrayList<Integer> recoverL = new ArrayList<>();
        ArrayList<Integer> recoverR = new ArrayList<>();

        //costl
        for (int i = 0; i < n; i++) {
            costL.add(sc.nextInt());
        }
        Collections.reverse(costL);

        for (int i = 0; i < n; i++) {
            costR.add(sc.nextInt());
        }

        for (int i = 0; i < n; i++) {
            recoverL.add(sc.nextInt());
        }
        Collections.reverse(costL);

        for (int i = 0; i < n; i++) {
            recoverR.add(sc.nextInt());
        }
        int dp [][] = new int[n][n];
        dp[n-1][n-1] = 1;
        for (int i = n-2;i >=0;i--){
            for (int j = n-2;j >= 0;j--){
                dp[i][j] =Math.min(Math.max(costL.get(i+1)+1,costL.get(i+1)+dp[i+1][j]-recoverL.get(i+1)),
                        Math.max(costR.get(j+1)+1,costR.get(j+1)+dp[i][j+1]-recoverR.get(j+1)));
            }
        }
        System.out.println(dp[0][0]);
    }

    //法1
    public static void mota(int[] cost, int[] recover) {
        int left = cost.length / 2 - 1;
        int right = cost.length / 2;
        System.out.println(mota(cost, recover, left, right, 1, 1));
    }

    public static int mota(int[] cost, int[] recover, int left, int right, int hp, int min) {
        if (left < 0) {
            while (right < cost.length) {
                if (hp <= cost[right]) {
                    min += cost[right] + 1 - hp;
                    hp = 1 + recover[right++];
                }else hp = hp-cost[right]+recover[right++];
            }
            return min;
        }
        if (right >= cost.length) {
            while (left >= 0) {
                if (hp <= cost[left]) {
                    min += cost[left] + 1 - hp;
                    hp = 1 + recover[left--];
                }else hp = hp-cost[left]+recover[left--];
            }
            return min;
        }
        int leftmin = min;
        int rightmin = min;
        if (hp - cost[left] <= 0) {
            leftmin += cost[left] + 1 - hp;
            int newhp = 1 + recover[left];
            leftmin = mota(cost, recover, left-1, right, newhp, leftmin);
        }else {
            int newhp = hp-cost[left]+recover[left];
            leftmin = mota(cost, recover, left-1, right, newhp, leftmin);
        }
        if (hp - cost[right] <= 0) {
            rightmin += cost[right] + 1 - hp;
            int newhp = 1 + recover[right];
            rightmin = mota(cost, recover, left, right+1, newhp, rightmin);
        }else {
            int newhp = hp-cost[right]+recover[right];
            rightmin = mota(cost, recover, left, right+1, newhp, rightmin);
        }
        return Math.min(leftmin,rightmin);
    }

}
