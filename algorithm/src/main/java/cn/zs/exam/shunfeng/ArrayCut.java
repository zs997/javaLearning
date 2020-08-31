package cn.zs.exam.shunfeng;

/*
*   将一数组k分割 每个小数组
*   计算cost = 小数组的元素之和 平方
*   每一种k分割，的总cost = 各数组的cost之和
*   问 ：最大的cost 以及在最大cost分割情况之下 最长的分割中最小的
*   （也就是每一种最大cost情况下 都会有最大的子数组，求出某一种cost下 这个最大数组 最小）
*          in: 6 3
                0 0 1 1 0 0
           out: 4 2
* */
public class ArrayCut {
    private static int max = Integer.MIN_VALUE;
    //每种所有分割方案最长之中的最短
    private static int minLen = Integer.MAX_VALUE;
    //每种分割方案的最长
    private static int maxLen = Integer.MIN_VALUE;
    //分割成三段
    private static int k =3;
    private static int [] data = {0,0,1,1,0,0};
    public static void main(String args[]){
        cut(1,-1,0,0);
        System.out.println(max);
        System.out.println(minLen);
    }
    public static void cut(int cutPoints,int currIndex,int currCost,int curLen){
        //分割了k段
        if (cutPoints == k) {
            int temp = 0;
            for(int i = currIndex+1;i<data.length;i++){
                temp += data[i];
            }
            int curLenTemp = data.length-currIndex-2;
            int LenMax = Math.max(curLen,curLenTemp);
            int res = currCost+temp*temp;
            if (res > max){
                max = res;
                maxLen = LenMax;
            }else if(res == max){
                minLen = Math.min(minLen,LenMax);
            }
        }else {
            int temp = 0;
            for(int i = currIndex+1;i< data.length-1;i++){
                //计算新的成本 从下标currIndex+1到i 都包含的
                temp += data[i];
                int curLenTemp = Math.max(curLen,i-currIndex);
                //i是插入点
                cut(cutPoints+1,i,currCost+temp*temp,curLenTemp);
            }
        }
    }


}

