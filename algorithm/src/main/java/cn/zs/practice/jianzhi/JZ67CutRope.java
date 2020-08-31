package cn.zs.practice.jianzhi;

public class JZ67CutRope {
    public static int cutRope(int n) {
        // n<=3的情况，m>1必须要分段，例如：3必须分成1、2；1、1、1 ，n=3最大分段乘积是2,
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int[] dp = new int[n+1];
	        /*
	        下面3行是n>=4的情况，跟n<=3不同，4可以分很多段，比如分成1、3，
	        这里的3可以不需要再分了，因为3分段最大才2，不分就是3。记录最大的。
	         */
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        int res=0;//记录最大的
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <=i/2 ; j++) {
                res=Math.max(res,dp[j]*dp[i-j]);
            }
            dp[i]=res;
        }
        return dp[n];
    }
}
