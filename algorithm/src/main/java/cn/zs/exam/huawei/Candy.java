package cn.zs.exam.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/*
    6
    2 2
    2 1
    3 2
    5 2
    3 1
    7 2
* */
public class Candy {
    public static void main(String[] args) {
        Scanner scanner  = new Scanner(System.in);
        ArrayList<Child> reds = new ArrayList<>();
        ArrayList<Child> blues = new ArrayList<>();
        
        int nums = scanner.nextInt();
        for (int i = 1; i <= nums; i++) {
            int num = scanner.nextInt();
            int color = scanner.nextInt();
            if (color == 1){
                reds.add(new Child(i,num));
            }else {
                blues.add(new Child(i,num));
            }
        }
        Collections.sort(reds, new Comparator<Child>() {
            @Override
            public int compare(Child o1, Child o2) {
                if (o1.num != o2.num){
                    return o2.num - o1.num;
                }
                return o1.no - o2.no;
            }
        });
        Collections.sort(blues, new Comparator<Child>() {
            @Override
            public int compare(Child o1, Child o2) {
                if (o1.num != o2.num){
                    return o2.num - o1.num;
                }
                return o1.no - o2.no;
            }
        });
        if (reds.size() < 3 && blues.size() >=3){
            Child c1 = blues.get(0);
            Child c2 = blues.get(1);
            Child c3 = blues.get(2);
            System.out.println(c3.no+" "+c2.no+" "+c1.no);
            System.out.println(2);
            System.out.println(c1.num+c2.num+c3.num);
            return;
        }else if (blues.size() < 3 && reds.size() >= 3){
            Child c1 = reds.get(0);
            Child c2 = reds.get(1);
            Child c3 = reds.get(2);
            System.out.println(c3.no+" "+c2.no+" "+c1.no);
            System.out.println(1);
            System.out.println(c1.num+c2.num+c3.num);
            return;
        }else if (blues.size() >= 3 && reds.size() >= 3){
            Child cb1 = blues.get(0);
            Child cb2 = blues.get(1);
            Child cb3 = blues.get(2);
            int numBlue = cb1.num+cb2.num+cb3.num;
            Child cr1 = reds.get(0);
            Child cr2 = reds.get(1);
            Child cr3 = reds.get(2);
            int numRed = cr1.num+cr2.num+cr3.num;
            if (numBlue > numRed){
                System.out.println(cb3.no+" "+cb2.no+" "+cb1.no);
                System.out.println(2);
                System.out.println(cb1.num+cb2.num+cb3.num);
            }else {
                System.out.println(cr3.no+" "+cr2.no+" "+cr1.no);
                System.out.println(1);
                System.out.println(cr1.num+cr2.num+cr3.num);
            }
        }else {
            System.out.println("null");
        }

    }
}
class Child{
    int no;
    int num;
  //  Child(){}
    Child(int no,int num){
        this.no = no;
        this.num = num;
    }
}