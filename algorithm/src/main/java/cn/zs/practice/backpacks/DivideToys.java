package cn.zs.practice.backpacks;
import java.util.HashSet;
import java.util.Scanner;

/*
*    一、有一堆玩具，N个。
*   每个玩具都有一个好玩的分数，记s_i。
#   要求将这堆玩具分给一对兄弟，
   让这对兄弟尽可能都觉得公平（即优化 min(abs(兄玩具好玩度求和-弟玩具好玩度求和))).
   就是划分数组成两部分，遇到划分问题就是背包问题
   此题当然可以使用回溯，每个物品都有选择给A 或者给B的机会
   Arr[] = {1,2,3,4,5,6}
**/
public class DivideToys {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
//        dfsDp(0,arr,0,0);
        backpackDp(arr);
       // System.out.println(minDiff);
    }
    static  int minDiff = 999;
    //方法1***********************************************************************************************************
    public static void dfs(int index,int arr[],int a,int b){
        if (index == arr.length){
                minDiff = Math.min(Math.abs(a-b),minDiff);
        }else {
            //给A
            dfs(index+1,arr,a+arr[index],b);
            //给B
            dfs(index+1,arr,a,b+arr[index]);
        }
    }
    //为了减少重复搜索 dfs可以添加备忘录 构成动态规划思想
    //画一颗决策树就可以想明白
    //如果 讨论到了 index 应该要分给哪一个了，在此之前如果探索过 a,b的值与之相同的  可以不再计算 算了也是一样的效果
    static HashSet<String> set = new HashSet<>();
    //方法1 改进************************************************************************************************
    public static void dfsDp(int index,int arr[],int a,int b){
        if (index == arr.length){
            minDiff = Math.min(Math.abs(a-b),minDiff);
        }else {
            int min = Math.min(a,b);
            int max = Math.max(a,b);
            String s = index+","+min+","+max;
            if (set.contains(s)){
                System.out.println("saved set1");
                return;
            }
            //给A
            dfsDp(index+1,arr,a+arr[index],b);
            //给B
            dfsDp(index+1,arr,a,b+arr[index]);
            set.add(s);
        }
    }
/*
*       A+B = sum
*       假设小的是A
*       A<= sum/2
*       B>= sum/2
*       那么 可以看做背包 选择一定的物品 使得最大化价值 但不能超过sum/2
* */
    //此时又可以回溯了 又可以回溯改进了
    private  static int sum =0;
    private static int maxA = 0;
    // 方法2 ******************************************************************************************************
    public static void backpackDfs(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        backpackDfsHelper(0,arr,0);
        int minB = sum - maxA;
        minDiff = minB -maxA;
//        System.out.println(minB-maxA);
    }
    public static void backpackDfsHelper(int index, int arr[],int value){
        if (index == arr.length){
            if (value<= sum/2){
                maxA = Math.max(maxA,value);
            }
        }else{
            //index 处不背
            backpackDfsHelper(index+1,arr,value);
            if(value+arr[index] <= sum/2){
                //index 处背
                backpackDfsHelper(index+1,arr,value+arr[index]);
            }
        }
    }

    // 方法2 改进***************************************************************************************
    public static void backpackDpDfs(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        backpackDfsDpHelper(0,arr,0);
        int minB = sum - maxA;
        //System.out.println(minB-maxA);
        minDiff = minB- maxA;
    }
    public static void backpackDfsDpHelper(int index, int arr[],int value){
        if (index == arr.length){
            if (value<= sum/2){
                maxA = Math.max(maxA,value);
            }
        }else{
            String s = index+"，"+value;
            if (set.contains(s)){
                System.out.println("call set");
                return;
            }
            //index 处不背
            backpackDfsDpHelper(index+1,arr,value);
            if(value+arr[index] <= sum/2){
                //index 处背
                backpackDfsDpHelper(index+1,arr,value+arr[index]);
            }
            set.add(s);
        }
    }

    //既然可以抽象成背包  那么dp也是可以了？
    // 求装入包中不超过sum/2 最大的价值
    //那么可以认为 每个物品的价值和重量都是一样的
    //包容量是sum/2，求最大价值，标准的背包
    // 方法3 背包dp
    private static int backpackDp(int arr[]){
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
        }
        backpackDpHelper(arr);
        int minB = sum - maxA;
        System.out.println(minB - maxA);
        minDiff = minB - maxA;
        return minB;

    }
    private static void  backpackDpHelper(int arr[]){
        int n = arr.length;
        int capacity = (int) Math.ceil(sum/2.0);
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
                int weight = arr[i-1];
                int value = arr[i-1];
                if ( weight < j){
                    //                  不装i      装i，
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight]+value);
                }else {
                    //装不下 就不装了
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
      //  System.out.println(dp[n][capacity]);
        maxA = dp[n][capacity];
       // return dp[n][capacity];
    }

}
