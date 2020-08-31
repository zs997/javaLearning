package cn.zs.exam.wangyi;
import java.util.Scanner;
/*
现在有n个物品，每一个物品都有一个价值，现在想将这些物品分给两个人，要求这两个人每一个人分到的物品的价值总和相同（个数可以不同，总价值相同即可），剩下的物品就需要丢掉，现在想知道最少需要扔掉多少价值的物品才能满足要求分给两个人。

输入描述：

第一行输入一个整数T，代表有T组测试数据
对于每一组测试数据，一行输入一个整数n，代表物品的个数
接下来n个数，a[i] 代表每一个物品的价值

1 <= T <= 10
1 <= N <= 15

1 <= a[i] <= 100000

输出描述：

对于每一组测试数据，输出一个答案代表最少需要扔掉的价值

输入：

1
5
30 60 5 15 30

输出：

20
* */
public class DropMinValue {
    private  static int n,ans,sum;
    private  static int a[] = new int[20];
    //dfs参数的意思是 op对第op个货物进行选择 有三种选择 给A 给B 丢掉
    // X,Y分别是选择op之前 A B分别获取的价值
    /*
    *   也可以在回溯的基础上 加上动态规划的概念
    *
    *   状态可以表示为 遍历到第i个物品 及此时A，B分别得到的价值
    *   （i,A,B）->
    *
    * */
    private static void dfs(int op,int x,int y){
        if(op>=n){
            if(x==y)
                ans=Math.min(ans,sum-x-y);
            return;
        }
        dfs(op+1,x+a[op],y);
        dfs(op+1,x,y+a[op]);
        dfs(op+1,x,y);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int i,j;
        //T组数据
        while(T-- > 0){
            //n是n个物品
            n = sc.nextInt();
            sum=0;
            for(i=0;i<n;i++){
               a[i] = sc.nextInt();
                sum+=a[i];
            }
            ans=sum;
            dfs(0,0,0);
            System.out.println(ans);
        }
    }
}
