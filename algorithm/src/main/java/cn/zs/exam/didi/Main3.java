package cn.zs.exam.didi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 *   100~1000
 *   abc为100~1000范围的数字
 *   acc+abc = num
 * */
public class Main3 {
    static List<List<Integer>>res = new ArrayList<List<Integer>>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        ArrayList<Integer>list = new ArrayList<>();
        int[] visit = new int[10];
        heler(visit,list,target);
        System.out.println(res.size()/2);
        for(int i=0;i<res.size();i++){
            System.out.print(res.get(i).get(0));
            System.out.print(res.get(i).get(1));
            System.out.print(res.get(i).get(2));
            System.out.print(" ");
            if(i>0&&i%2==1){
                System.out.println();
            }
        }
    }

    public static void heler(int[]visit,ArrayList<Integer>list,int target){
        if(list.size()==3){
            if(isOk(list,target)&&!res.contains(list)){
                res.add(new ArrayList<>(list));
                ArrayList<Integer>list2 = new ArrayList<Integer>();
                list2.add(list.get(0));
                list2.add(list.get(2));
                list2.add(list.get(2));
                res.add(list2);
            }
        }
        for(int i=0;i<10;i++){
            if(visit[i]==1){
                continue;
            }
            visit[i] = 1;
            list.add(i);
            heler(visit,list,target);
            list.remove(list.size()-1);
            visit[i] = 0;
        }
    }

    public static boolean isOk(ArrayList<Integer> list, int target){
        int a = list.get(0);
        int b = list.get(1);
        int c = list.get(2);
        if(a==0){
            return false;
        }
        int s1 = 100*a+10*b+c;
        int s2 = 100*a+10*c+c;
        if(s1+s2==target){
            return true;
        }
        return false;
    }

}