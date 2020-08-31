package cn.zs.exam.shunfeng;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayCutZhou {
    public static ArrayList<ArrayList<int[]>> result = new ArrayList<>();
    private static  int value [] ;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int car = scanner.nextInt();
        value = new int[count];
        for(int i = 0; i < count; i++) {
            value[i] = scanner.nextInt();
        }

        ArrayList<int[]> list = new ArrayList<int[]>();
        cF(car,0, list);

        System.out.println("count=" + result.size());
        int maxValue = 0;
        int minCount = 1;
        //每一种分割方案
        for (ArrayList<int[]> res : result) {
            int tempValue = 0;
            int tempCount = 0;
            //分割的数据 也就是每个车的
            for (int[] ints : res) {
                int temp = 0;
                for(int i = ints[0]; i <= ints[1]; i++) {
                    //System.out.print(value[i] + " ");
                    temp += value[i];
                }
                temp *= temp;
                //每个车的费用 循环之后 就是总费用
                tempValue += temp;
                //找出最长的分割
                tempCount = Math.max(tempCount, ints[1] - ints[0] + 1);
            }
            //到这里 某一分割对应一种 费用   装货最多的车 就是最大分割 也有了
            if(tempValue > maxValue) {
                maxValue = tempValue;
                minCount = tempCount;
            }else if(tempValue == maxValue && tempCount < minCount) {
                minCount = tempCount;
            }
            //System.out.println("------------------");
        }
        System.out.println("maxValue=" + maxValue);
        System.out.println("minCount=" + minCount);
    }

    public static void cF(int car,  int s, ArrayList<int[]> list) {
        if(car == 1) {
            list.add(new int[]{s, value.length - 1});
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
        }else {
           for(int i = s; i < value.length - car + 1; i++) {
                list.add(new int[]{s, i});
                cF(car - 1, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }

}


