package cn.zs.exam.sougou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
//        ArrayList<>
        Collections.sort(list);
    }
    public int getHouses(int t,int [] xa){
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < xa.length; i++) {
            map.put(xa[i],xa[i+1]);
        }
        Object[] objects = map.keySet().toArray();
        int res = 0;
        for (int i = 0; i < objects.length - 1; i++) {
            double left = map.get(objects[i])*1.0/2 + (int) objects[i];
        //    double right = (int) Obj    ect[i+1]-map.get(Object[i+1])
        }
        return -1;
    }
}
