package cn.zs.practice;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Kmax {
    static void topk( int arr[] ,int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = queue.poll();
            System.out.println(poll);
        }
    }
    static void topk1(int arr[],int k){
            build(arr);
        for (int i = 0; i < k; i++) {
            int temp = arr[0];
            arr[0] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
            justify(arr,0,arr.length-2-i);
        }
        for (int i = 0; i < k; i++) {
            System.out.println(arr[arr.length-1-i]);
        }

    }
    static void build(int arr[]){
        for (int i = arr.length-1; i >= 0 ; i--) {
            justify(arr,i,arr.length-1);
        }
    }
    static void justify(int arr[],int k,int end){
        int minIndex = k;
        int lchild = 2*k+1;
        int rchild = 2*k+2;
        if (lchild <= end && arr[lchild] < arr[minIndex]){
            minIndex = lchild;
        }
        if (rchild <= end && arr[rchild] < arr[minIndex]){
            minIndex = rchild;
        }
        if (minIndex != k){
            int temp = arr[minIndex];
            arr[minIndex] = arr[k];
            arr[k] = temp;
            justify(arr,minIndex,end);
        }
    }

    static void findKMax(int[] arr, int left, int right, int k) {
        int temp = partition(arr, left, right);
        if (temp == k - 1) {
            System.out.println(arr[temp]);
        } else if (temp > k - 1) {
            findKMax(arr, left, temp - 1, k);
        } else {
            findKMax(arr, temp + 1, right, k - temp);
        }
    }
    static int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (temp >= arr[right] && left < right)
                --right;
            arr[left] = arr[right];
            while (temp <= arr[left] && left < right)
                ++left;
            arr[right] = arr[left];
        }
        arr[right] = temp;
        return right;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{12, 23, 2, 3, 2, 432, 43, 534, 5, 345, 3453, 53, 43};
//        findKMax(arr,0,arr.length - 1,2);
        //topk(arr,3);
    }
}