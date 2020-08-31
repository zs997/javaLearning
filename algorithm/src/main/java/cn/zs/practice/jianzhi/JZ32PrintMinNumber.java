package cn.zs.practice.jianzhi;

import java.util.*;

public class JZ32PrintMinNumber {
    public String printMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        String S = "";
        for(int i : numbers){
            list.add(i);
        }
        Collections.sort(list,new Comparator<Integer>(){
            public int compare(Integer str1,Integer str2){
                String s1=str1+""+str2;
                String s2=str2+""+str1;
                return s1.compareTo(s2);
            }
        });
        for(int i : list){
            S += i;
        }
        return S;
    }
}
