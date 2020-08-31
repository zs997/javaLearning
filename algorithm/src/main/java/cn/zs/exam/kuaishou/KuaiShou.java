package cn.zs.exam.kuaishou;

import java.util.*;
/**
 *      2020 快手春招
 * */

public class KuaiShou {

    public static void main(String[] args) {
        //char pos [][] = {{'-','+','+','-','-'},{'+','-','+','-','+'},{'+','+','+','-','-'}};
        //kuaishou4(pos);
//        int[] a= {8,9,7};
//        int [] b={5,8,3};
//        kuaishou3(a,b);
//        int[] ints = new int[2];
//        for (int i = 0; i < ints.length; i++) {
//            System.out.println(ints[i]);
//        }
//        System.out.println(ints);
//       int [] res =  kuaishou2(279,3);
//        System.out.println(res.length);
//        for (int i = 0; i < res.length; i++) {
//            System.out.println(res[i]);
//        }
        kuaishou2(279,3);
    }
    /*
    *       1、匹配括号
            给定一字符串，只有’(’,’)’,’+’,’-’,’*’,’/’,数字0~9组成。
            实现统计：匹配的正反括号数目，剩余正反括号数目。
            如（1+2+3+4+/）((())-+((//*)
            返回 4,2,0
            4：表示匹配的括号对数是4
            2：表示剩余的左括号数是2
            0：表示剩余的右括号数是0
    * */
    public static void kuaishou1(){
        //(1+2+3+4+/)((())-+((//*)
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char [] sArr = s.toCharArray();
        //记录匹配数
        int couple = 0;
        //剩余左括号
        int left = 0;
        //剩余右括号
        int right = 0;
        Stack<Character> stack = new Stack<>();
        //遍历字符串
        for (int i = 0; i < sArr.length; i++) {
            //找出（
            if(sArr[i] == '('){
                //入栈
                stack.push(sArr[i]);
            }else if(sArr[i] == ')'){
                //不为空可以匹配
                if(!stack.empty()){
                    stack.pop();
                    couple++;
                }else{
                    //没有匹配的 剩余右括号增加
                    right++;
                }
            }

        }
        //剩余的肯定是左括号
        while(!stack.empty()){
            left++;
            stack.pop();
        }

        System.out.print(couple+" ");
        System.out.print(left+" ");
        System.out.println(right);
    }
    /*
    *
    *       2、完美数
            给定 正整数 R，N。如果 R = N ^ m1+N^m2+…
            mi不是重复的数字就可以 。
            如
            1、3^ 2 + 3^ 3 + 3^5 =279
            279是3的完美数。
            输出2 3 5
            2、2^ 0 = 1
            1是2的完美数。
            输出 1
            3、3+3 ^2+3 ^2= 19
            19不是3的完美数
            1 2 2（2重复）
            输出 []
    * */
    public static int [] kuaishou2(int R,int N){
        int cur = R;
        ArrayList<Integer> list = new ArrayList<>();
        while(cur > 0){
            int res[] = findMax(cur,N);
            int m = res[0];
            int multi = res[1];
            list.add(m);
            cur -= multi;
        }
        int size = list.size();
        int res [] = new int[size];
        //先看看有没重复的
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i) == list.get(i+1)){
                return res;
            }
        }
        //到这就没重复的了 翻位置
        for (int i = 0; i < size; i++) {
            res[size-1-i] = list.get(i);
        }

        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        return res;
    }
    private static int [] findMax(int cur, int n) {
        // n^m 小于等于cur，而且是最接近时 的m
        int res [] = new int [2];
        int multi = 1;
        int times = 0;
        while(multi <= cur){
            multi *= n;
            times++;
        }
        // res[0] 最高次幂
        //res[1] 对应次幂值
        res[0] = times-1;
        res[1] = multi/n;
        return res;
    }



     //总不满意度
    static int unsatisify = Integer.MAX_VALUE;
    //最优顺序
    static int res [] = null;
    /*
    *       有编号为i = 1,2,3~n的人在位置j = 1,2,3 ~ n排队。
    *       每个人都希望尽快完事。所以每个人在某一个位置
    *       有一个计算公式表示其不满意度： ai*(j-1)+bi*(n-j) ，
    *       其中，j表示他处在第j个位置，一共n个位置。
    *       ai，bi是每个人自己特有的，会以数组的形式表示，如a=[8,9,7]，b=[5,8,3]。
    *       这表示1号顾客a1=8，b1=5，如果他排在第一位置，不满意度为8*（1-1）+5*（3-1）。
    *       但是卖东西的老板希望所有顾客不满意度加和最低。请给出最优方案。
            如：给定 a =[8,9,7]，b=[5,8,3]
            输出 总不满意度37，顺序2,0,1
    * */
    public static void kuaishou3(int [] a,int [] b){
        // a= {8,9,7}
        //b={5,8,3}
        //排除非正常输入 略

        res = new int [a.length];

       helper(a,b,new int[a.length],0,new boolean[a.length]);

//        helperImprove(a,b,new int[a.length],0,new boolean[a.length],0);
        System.out.println(unsatisify);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");
        }

    }
    // seq：当前顺序 cur：到哪了 visited：是否使用过
    public static void helper(int a[],int b[],int seq [] ,int cur,boolean [] visited){
        //次序好了
        if(cur == a.length){
            //计算总不满意度
            int curValue = calculAll(a, b, seq);
            if(curValue < unsatisify){
                unsatisify = curValue;
                for (int i = 0; i < seq.length; i++) {
                    //seq装的是 从0开始的顾客编号 要加1
                    res[i] = seq[i] + 1;
                }
            }
        }else{
            //游标cur处 选择合适顾客
            for (int i = 0; i < visited.length; i++) {
                if(!visited[i]){
                    //没有参与排队
                    visited[i] = true;
                    seq[cur] = i;
                    helper(a,b,seq,cur+1,visited);
                    visited[i] = false;
                }
            }

        }
    }
    //计算某一个顺序的总不满意度    三个数组维度相同 seq数组下标表示位置j=0~ n-1(实际上位置要加1，j+1)
    // 下标j对应的元素，seq[j] 属于（0~n-1）是在该位置的顾客编号，实际上的顾客编号要加1
    //ai*(j-1)+bi*(n-j)
    public static int calculAll(int a[], int [] b,int [] seq){
        int sum = 0;
        for(int j = 0;j < seq.length;j++){
            //j位置 就是第j+1位置
            // no是顾客编号 0~n-1
            int no = seq[j];
            int ai = a[no];
            int bi = b[no];
            //j+1是从1开始的位置
            sum += ai*((j+1)-1) + bi*(seq.length-(j+1));
        }
        return sum;
    }


    // seq：当前顺序 cur：到哪了 visited：是否使用过
    public static void helperImprove(int a[],int b[],int seq [] ,int curIndex,boolean [] visited,int curResult){
        //次序好了
        if(curIndex == a.length){
            //计算总不满意度

            if(curResult < unsatisify){
                unsatisify = curResult;
                for (int i = 0; i < seq.length; i++) {
                    //seq装的是 从0开始的顾客编号 要加1
                    res[i] = seq[i] + 1;
                }
            }
        }else{
            //游标cur处 选择合适顾客
            for (int i = 0; i < visited.length; i++) {
                if(!visited[i]){
                    int delta = calculOne(a, b, curIndex, i);
                    if(curResult + delta < unsatisify){
                        //没有参与排队
                        visited[i] = true;
                        seq[curIndex] = i;
                        helperImprove(a,b,seq,curIndex+1,visited,curResult + delta);
                        visited[i] = false;
                    }

                }
            }

        }
    }

    public static int calculOne(int a[], int [] b,int pos,int consumer){

            int ai = a[consumer];
            int bi = b[consumer];
            //j+1是从1开始的位置
           int sum = ai*((pos+1)-1) + bi*(a.length-(pos+1));

        return sum;
    }
    /*
    *
        给定一二维数组 char pos[m][n]，表示公司的m*n个工位，有的工位有电源，
        对应数组元素是’+’，有的没有电源，对应元素是’-’。现在想安排员工到有电源得位置。
        由于疫情影响，每个员工前后左右紧挨着的工位都不能有其他员工。
        请问最多一共可以安排多少员工？
        给定数组 如：[-,+,+,-,-],[+,-,+,-,+],[+,+,+,-,-]
        输出 5
    * */
    public static  void kuaishou4(char pos[][]){
        // char pos [][] = {{'-','+','+','-','-'},{'+','-','+','-','+'},{'+','+','+','-','-'}};
        //if() 去除特殊值
        int m = pos.length;
        int n = pos[0].length;
        //默认全false
        boolean gongwei [][] = new boolean[m][n];
        if(pos[0][0] == '+'){
            gongwei[0][0] = true;
        }
        for(int i = 1;i < m;i++){
            //i行0列 如果有电源 而且 上一行0列没有安排员工
            if(pos[i][0] == '+' && !gongwei[i-1][0]){
                gongwei[i][0] = true;
            }
        }

        for(int i = 1;i < n;i++){
            //0行i列 如果有电源 而且 同行上一列没有安排员工
            if(pos[0][i] == '+' && !gongwei[0][i-1]){
                gongwei[0][i] = true;
            }
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j<n;j++){
                if(pos[i][j] =='+' && !gongwei[i-1][j] && !gongwei[i][j-1]){
                    gongwei[i][j] = true;
                }
            }
        }
        int sum = 0;
        for(int i = 0;i<gongwei.length;i++){
            for(int j=0;j<gongwei[0].length;j++){
                if(gongwei[i][j]){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }


}