package cn.zs.exam.beike;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
/*
*   涂颜色。给n个栅栏涂颜色，共有m种颜色可选，且每个颜色后边不能紧跟ci。。。等k种颜色，求方案的种类；
*
* */
public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int count = Integer.parseInt(s);
        int n, m ,k;
        while (count --> 0){
            String[] split = scanner.nextLine().split(" ");
             n = Integer.parseInt(split[0]);
             m = Integer.parseInt(split[1]);
             k = Integer.parseInt(split[2]);
            HashMap<Integer, HashSet> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                split = scanner.nextLine().split(" ");
                for (int j = 0; j < split.length; j++) {
                    int id = Integer.parseInt(split[j]) - 1;
                    if (!map.containsKey(id)){
                        HashSet<Object> set = new HashSet<>();
                        set.add(i);
                        map.put(id,set);
                    }else map.get(id).add(i);
                }
            }
            long[][] dp = new long[n][m];
            for (int i = 0; i < m; i++) {
                dp[0][i] = 1;
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    HashSet set = map.get(j);
                    for (int l = 0; l < m; l++) {
                        if (set == null || !set.contains(l))
                            dp[i][j] += dp[i-1][l];
                    }
                    if (dp[i][j] >= 1000000007)
                        dp[i][j] = dp[i][j]%1000000007;
                }
            }
            long res = 0;
            for (int i = 0; i < m; i++) {
                res+=dp[n-1][i];
            }
            if (res >= 1000000007) res = res%1000000007;
            System.out.println(res);
        }
    }
}
