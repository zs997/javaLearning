package cn.zs.exam.qihu360;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //人数
        int n = sc.nextInt();
        //打卡记录
        int m = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int no = sc.nextInt();
            int state = sc.nextInt();
            Node node = new Node(no,state);
            list.add(node);
            set.add(no);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i =1; i <= n; i++) {
            if (set.contains(i)){

            }else {
                res.add(i);
            }
        }
        for (int i = 0; i < res.size()-1; i++) {
            System.out.print(res.get(i)+" ");
        }
        System.out.println(res.get(res.size()-1));
    }
}
class Node{
    //工号
    int no;
    //上班还是下班
    int state;

    public Node(int no, int state) {
        this.no = no;
        this.state = state;
    }
}