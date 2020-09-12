package cn.zs.exam.pinduoduo;

import java.util.Scanner;

/**
 * 题意：普通的01背包，但是现在体积可能为负数。
 * 思路：一眼题，因为体积为负数，表示我们的体积会变大，
 * 这种情况，我们把它变为相反数即可--------表示我一开始就装进去，
 * 那么在跑背包的时候如果选择了它的相反数这个物体，代表把它移除。
 * （而这个时候所有的物体都是正他体积，跑01背包就行。）
 * 注：如果你不会01背包的话，那么你在学习的时候得注意，第二个for倒序遍历，
 * 这样防止重复更新答案。或者用二维的dp。
 * */
public class BackPack {
    static int maxn=410;
    //物品占据空间
    static int c[] = new int[maxn];
    //物品的价值
    static int v[] = new int[maxn];
    static int ans;
    static int dp[] = new int[40010];
    public static void main(String[] args) {
        int N,M;
        Scanner sc = new Scanner(System.in);
        //N个物品
         N = sc.nextInt();
         //M背包初始容量
         M = sc.nextInt();

        for(int i=1;i<=N;i++){
           c[i] = sc.nextInt();
           v[i] = sc.nextInt();
            if(c[i]<=0){   //负的物体取反
                //初始价值
                ans+=v[i];
                M-=c[i];
                //如果背上它，容量增大（-10价值），价值减小
                //不背 容量减小 价值增大
                //背此包 和不背正常的包一样  那么初始化时候 先背上
                c[i]=-c[i];
                v[i]=-v[i];
            }
        }
        for(int i=1;i<=N;i++)  //01背包
            for(int j=M;j>=c[i];j--)
                dp[j]=Math.max(dp[j],dp[j-c[i]]+v[i]);

        for(int i=0;i<=M;i++) {
            dp[M]=Math.max(dp[M],dp[i]);
        }

        System.out.println(ans+dp[M]);

    }
}
