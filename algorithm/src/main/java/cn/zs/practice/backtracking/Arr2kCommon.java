package cn.zs.practice.backtracking;
import java.util.*;
/*
*   给定一个数组 对其中的一个元素 +1或者-1 记为一次操作
*   规定每次只能操作一个元素，只能对最大的数字 或者最小的数字 进行操作
*   问最少操作多少次可以将 数字中的元素变为k个相等的
 * */
public class Arr2kCommon {
    static int k ;
    static int minCount =999;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         k = sc.nextInt();
        Integer a[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] =sc.nextInt();
        }
        Arrays.sort(a);
        if(!check(a)){
            helper(new ArrayList<Integer>(Arrays.asList(a)),0);
            System.out.println(minCount);

        }else {
            System.out.println(0);
        }
    }

    public static void helper(ArrayList<Integer> list, int count){
        Integer arr [] = new Integer[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        if(check(arr)){
            if(count < minCount){
                minCount = count;
            }
        }else if (count >minCount){
           return;
        }else {
            arr[0]++;
            helper(new ArrayList<Integer>(Arrays.asList(arr)),count+1);
            arr[0]--;
            arr[arr.length-1]++;
            helper(new ArrayList<Integer>(Arrays.asList(arr)),count+1);
            arr[arr.length-1]++;
        }
    }
    //如果有k个重复的 返回true
    public static boolean check(Integer [] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
                if(map.get(arr[i]) >= k){
                    return true;
                }
            }else{
                map.put(arr[i],1);
            }
        }
        return false;
    }
}
