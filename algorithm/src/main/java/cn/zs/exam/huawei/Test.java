package cn.zs.exam.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        ArrayList<Child> res = new ArrayList<>();
        Child c1 = new Child(1, 25);
        Child c2 = new Child(2, 22);
        Child c3 = new Child(3, 56);
        Child c4 = new Child(4, 56);
        res.add(c1);
        res.add(c2);
        res.add(c3);
        res.add(c4);
        Collections.sort(res, new Comparator<Child>() {
            @Override
            public int compare(Child o1, Child o2) {
                if (o1.num != o2.num){
                    return o2.num - o1.num;
                }
                return o1.no - o2.no;
            }
        });
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i).no+" "+res.get(i).num);
        }

    }
}
