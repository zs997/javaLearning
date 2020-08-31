package cn.zs.practice.backpacks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 *      0 1 背包
 *      输入背包的容量v和物品的数量n；接下来n 行每行输入两个数字,
 *      第一个是物品质量，第二个是物品价值； *
 *      输出背包容纳物品的最大价值。
 *      测试数据：
         (1)
         in
         100 5
         77 92
         22 22
         29 87
         50 46
         99 90
         out
         133
         (2)
         in
         200 8
         79 83
         58 14
         86 54
         11 79
         28 72
         62 52
         15 48
         68 62
         out
         334
         (3)
         in
         300 10
         95 89
         75 59
         23 19
         73 43
         50 100
         22 72
         6 44
         57 16
         89 7
         98 64
         out
         388
 * */
public class BackPack {
    public static void main(String[] args) {
      // maxValueDp();
      //  maxValueBacktrapingImprove();
      //  System.out.println(max);
        maxValueBacktrapingImprove2();
    }
    //方案1  回溯法 适当剪枝
    public static void maxValueBacktraping(){
        Scanner sc = new Scanner(System.in);
        //背包容量
        int capacity = sc.nextInt();
        //物品个数
        int n = sc.nextInt();
        int data [][] = new int[n][2];
        //data[i][0] 质量
        //data[i][1] 价值
        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }
        System.out.println(System.currentTimeMillis());
        maxValueBacktrapingHelper(data,capacity,0,0);
        System.out.println(max);
        System.out.println(System.currentTimeMillis());
    }
    public static  int max = 0;
    //表示选择到index时候 capacity还剩余多少
    public static void maxValueBacktrapingHelper(int data[][],int capacity,int index,int curMax){
        if (index == data.length){
            max = Math.max(curMax,max);
        }else {
            //坐标为i的货物不装入
            maxValueBacktrapingHelper(data,capacity,index+1,curMax);
            //坐标为i的货物装入
            if (data[index][0] < capacity){
                maxValueBacktrapingHelper(data,capacity - data[index][0],index+1,curMax+data[index][1]);
            }
        }
    }

    //方案2 使用备忘录
    public static void maxValueBacktrapingImprove(){
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int n = sc.nextInt();
        int data [][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }
        System.out.println("start time:"+System.currentTimeMillis());
        System.out.println(maxValueBacktrapingImproveHelper(data,capacity,0));
        System.out.println("end time:"+System.currentTimeMillis());
    }
    static HashMap<String,Integer> map = new HashMap<>();
    private static int maxValueBacktrapingImproveHelper(int[][] data, int capacity, int index) {
        if (index == data.length){
            return 0;
        }else {
            String s = index+","+capacity;
            if (map.containsKey(s)){
                System.out.println("call map:"+s);
                return map.get(s);
            }
            //坐标为index的货物不装入  函数的状态表示 用capacity容量 讨论装不装 index坐标(包含)的物品 所能达到的最大价值
            int result1 = maxValueBacktrapingImproveHelper(data, capacity, index + 1);
            int next = index+1;
            String s1 = next+","+capacity;
            //放入状态 那么 map中 s对应的是 index+1的货物 还剩capacity时候，最大的价值量
            map.put(s1,result1);
            //坐标为index的货物装入
            int result2 = 0;
            if (data[index][0] < capacity){
                int rest = capacity - data[index][0];
                result2 = maxValueBacktrapingImproveHelper(data, rest, index + 1);
                String s2 = next+","+rest;
                map.put(s2,result2);
            }
            return data[index][0] < capacity? (result1 > result2 + data[index][1] ? result1:result2+data[index][1]):result1;


        }
    }
    //方案2 改进
    public  static void maxValueBacktrapingImprove2(){
        Scanner sc = new Scanner(System.in);
        int capacity = sc.nextInt();
        int n = sc.nextInt();
        int data [][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }
        System.out.println("start time:"+System.currentTimeMillis());
        maxValueBacktrapingImproveHelper2(data,capacity,0,0);
        System.out.println(max);
        System.out.println("end time:"+System.currentTimeMillis());
    }
    private static HashSet<String> set = new HashSet<>();
    private static void maxValueBacktrapingImproveHelper2(int data[][],int capacity,int index,int curMax){
        if (index == data.length){
            max = Math.max(curMax,max);
        }else {
            String s = index+","+capacity+","+curMax;
            if (set.contains(s)){
                System.out.println("call set:"+s);
                return;
            }
            //坐标为i的货物不装入
            maxValueBacktrapingHelper(data,capacity,index+1,curMax);
            //坐标为i的货物装入
            if (data[index][0] < capacity){
                maxValueBacktrapingHelper(data,capacity - data[index][0],index+1,curMax+data[index][1]);
            }
            set.add(s);
        }
    }
    //方案3 dp
    public static int maxValueDp(){
        Scanner sc = new Scanner(System.in);
        //背包容量
        int capacity = sc.nextInt();
        //物品个数
        int n = sc.nextInt();
        int data [][] = new int[n][2];
        //data[i][0] 质量
        //data[i][1] 价值
        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }
        //dp[i][j] 第1~n个的物品 容量是j的最大价值
        int dp [][] = new int [n+1][capacity+1];
        //啥样的物品 没有包 都是0
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] =0;
        }
        //没有物品 包多大 价值都是0
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        //求第i件货  参数是 data[i-1][]
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                // data[i][0] 质量
                // data[i][1] 价值
                int weight = data[i-1][0];
                int value = data[i-1][1];
                if ( weight < j){
                    //                  不装i      装i，
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight]+value);
                }else {
                    //装不下 就不装了
                    dp[i][j] = dp[i-1][j];
                }
             }
         }
        System.out.println(dp[n][capacity]);
        return dp[n][capacity];
    }

    //方案3 改进  dp可以优化？改成一维的
    public  static int maxValueDpImprove(){
        Scanner sc = new Scanner(System.in);
        //背包容量
        int capacity = sc.nextInt();
        //物品个数
        int n = sc.nextInt();
        int data [][] = new int[n][2];
        //data[i][0] 质量
        //data[i][1] 价值
        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextInt();
            data[i][1] = sc.nextInt();
        }
        int [] dp = new int[capacity+1];
        for(int i=0;i<n;i++)
        {
            for(int v= capacity;v>=data[i][0];v--)
            {
                //充分利用 上一个i的数据 更新 由大及小
                //              不放i         放i
                dp[v] = Math.max(dp[v], dp[v-data[i][0]]+data[i][1]);
            }
        }
        System.out.println(dp[capacity]);
        return dp[capacity];
    }
}
