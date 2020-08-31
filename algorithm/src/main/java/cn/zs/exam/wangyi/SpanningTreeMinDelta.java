package cn.zs.exam.wangyi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/*
* 求解一个生成树使得该树中的最大边权值和最小边权值之差最小
* */
public class SpanningTreeMinDelta {
    private static final int maxn = 110;
    private static int father[] = new  int[maxn];
    private static Edge e [] = new Edge[maxn*maxn];
    //n是点数目 m是边个数
    private static int n,m;
    //并查集
    private  static int find(int x){
        if( x == father[x]){
            return x;
        }
        father[x] = find(father[x]);
        return father[x];
    }
    //以上是用kruscal算法来解决问题的基本模板.....
    /**
     *
     * 求生成树中最大边权值和最小边权值之差最小的:
     * 枚举每一条边,将其作为下界,向右寻找一个上界...
     * 使得生成树的最大边权值-最小边权值的差最小
     *
     */
    private static int kruscal(int start){//使用kruscal算法来生成最小生成树并计算带权路径和
        int i;
     //   int sum = 0;//用sum来记录最小s生成树的边权和
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int count = 0;

        for( i = 1 ; i < maxn ; ++i){
            father[i] = i;
        }

        for( i = start ; i <= m ; ++i){//枚举有序边集中的每一条边
            int fx = find(e[i].begin);
            int fy = find(e[i].end);

            if(fx != fy){//若第k条边的两个端点i,j 分别属于两颗不同的子树
                father[fx] = fy;//则将节点i所在的子树并入节点j所在的子树中
             //   sum += e[i].weight;
                //求解每种生成树的(max - min)值
                count++;
                if(e[i].weight > max){
                    max = e[i].weight;
                }
                if(e[i].weight < min){
                    min = e[i].weight;
                }
            }
        }
        if(count != n-1){//不是生成树
            return -1;
        }
        return max - min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m =sc.nextInt();
        int i,j;
        for(i = 1 ; i <= m ; ++i){
           e[i] = new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        //边权小的放在前面
        //kruscal算法要求边有序..特别需要注意的是排序的起点和终点
        Arrays.sort(e, 1,m,new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        int slim = Integer.MAX_VALUE;
        //从某一点出发构造,生成树！！！不知道为啥  计算slim  选出最小的
        slim = Math.min(slim,kruscal(1));
        if(slim != -1){
            for(i = 2 ; i <= m ; ++i){
                int temp = kruscal(i);

                if(temp >= 0){
                    slim = Math.min(slim,temp);
                }
            }
        }

        System.out.println(slim);

    }
    static class Edge{
        int begin;
        int end;
        int weight;
        Edge(){
        }
        Edge(int begin,int end,int weight){
            this.begin = begin;
            this.end = end;
            this.weight= weight;
        }
    }

}
