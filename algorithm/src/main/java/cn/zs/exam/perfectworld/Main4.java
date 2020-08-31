package cn.zs.exam.perfectworld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
小明最近遇到一个问题，已知一个正整数数组 array，
如果该数组每对相邻元素之和是一个完全平方数，则称这一数组为完美数组。
计算array 的完美数组排列的数目。
两个排列 array 1 和 array 2 不同的充要条件是存在某个索引 i，
使得 array 1[i] != array 2[i]。
示例 1：
输入：[1,17,8]
输出：2
解释：
[1,8,17] 和 [17,8,1] 都是有效的排列。
示例 2：
输入：[2,2,2]
输出：1
* */
public class Main4 {
   static HashMap<Integer,Integer> count;
    static  HashMap<Integer,ArrayList<Integer>> graph;
    private static boolean isPerfect(int x, int y) {
        int r = (int)Math.sqrt(x + y);
        return r * r == x + y;
    }

    public static int dfs(int x, int todo) {
        count.put(x, count.get(x) - 1);
        int ans = 1;
        if (todo != 0) {
            ans = 0;
            for (int y: graph.get(x)) {
                if (count.get(y) != 0) {
                    ans += dfs(y, todo - 1);
                }
            }
        }
        count.put(x, count.get(x) + 1);
        return ans;
    }

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int perfectArrayNum(int[] A) {
        int N = A.length;
        count = new HashMap();
        graph = new HashMap();

        // count.get(v) : 数组 A 中值为 v 的节点数量
        for (int x: A) {
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        // graph.get(v) : 在 A 中的值 w 满足 v + w 是完全平方数
        //                (ie., "vw" is an edge)
        for (int x: count.keySet()) {
            graph.put(x, new ArrayList());
        }

        for (int x: count.keySet())
            for (int y: count.keySet()) {
                if (isPerfect(x, y)) {
                    graph.get(x).add(y);
                }
            }

        // 增加从 x 开始的可行路径数量
        int ans = 0;
        for (int x: count.keySet())
            ans += dfs(x, N - 1);
        return ans;

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _array_size = 0;
        _array_size = Integer.parseInt(in.nextLine().trim());
        int[] _array = new int[_array_size];
        int _array_item;
        for(int _array_i = 0; _array_i < _array_size; _array_i++) {
            _array_item = Integer.parseInt(in.nextLine().trim());
            _array[_array_i] = _array_item;
        }

        res = perfectArrayNum(_array);
        System.out.println(String.valueOf(res));

    }
}

