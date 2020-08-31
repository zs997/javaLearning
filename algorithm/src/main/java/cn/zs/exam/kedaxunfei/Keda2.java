package cn.zs.exam.kedaxunfei;

import java.util.Scanner;

public class Keda2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        Integer m = Integer.valueOf(s);
        String data = scanner.nextLine();
        String[] split = data.split(",");
        int arr[] = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            Integer integer = Integer.valueOf(split[i]);
            arr[i] = integer;
        }
        quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length-1; i++) {
            System.out.print(arr[i]+",");
        }
        System.out.print(arr[arr.length-1]);
    }
    public  static void quickSort(int arr[],int leftIndex,int rightIndex){
        if(leftIndex >= rightIndex){
            return;
        }
        int left = leftIndex;
        int right = rightIndex;
        int key = arr[left];
        while (left < right){
            while (left<right && arr[right] >= key){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= key){
                left++;
            }
            arr[right]  = arr[left];
        }
        arr[left] = key;
        quickSort(arr,leftIndex,left-1);
        quickSort(arr,left+1,rightIndex);
    }
}
