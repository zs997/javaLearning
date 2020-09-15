package cn.zhushuai;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main3 {
    public static void main(String[] args) {
      int data[][] = {
              {1,2,3,4,5},
              {2,6,8,9,10},
              {2,4,6,7}
      };
        int[] merge = merge(data);
        for (int i = 0; i < merge.length; i++) {
            System.out.print(merge[i]+" ");
        }
    }
    //合并data 分别是有序的
    public static int [] merge(int [][] data){
        if (data == null || data.length ==0)
            return null;
        int[] helper = helper(data, 0, data.length-1);
        return helper;
    }
    private static int [] helper(int data [][] ,int start,int end){
        if (start >= end)
            return data[start];
        if (start + 1 == end)
            return merge2arrs(data[start],data[end]);
        int mid = (start+end)/2;
        int[] helper = helper(data, start, mid);
        int[] helper1 = helper(data, mid + 1, end);
        int[] ints = merge2arrs(helper, helper1);
        return ints;
    }
    private static int [] merge2arrs(int [] a,int b[]){
        int [] res = new int[a.length+b.length];
        int i = 0;
        int j = 0;
        int k =0;
        while (i < a.length && j < b.length){
            if (a[i] < b[j]){
                res[k++] = a[i++];
            }else {
                res[k++] = b[j++];
            }
        }
        while (i < a.length){
            res[k++] = a[i++];
        }
        while (j < b.length){
            res[k++] = b[j++];
        }
        return  res;
    }

    public static int [] topm1(int arr[],int m){
        int res[] = new int[m];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        for (int i = 0; i < m; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
    public  static int [] topm2(int arr[],int m){
        int res[] = new int[m];
        initHeap(arr);
        int len = arr.length;
        for (int i = 0; i < m; i++) {
            int temp = arr[0];
            arr[0] = arr[len-1-i];
            arr[len-1-i] = temp;
            res[i] = temp;
            justify(arr,0,len-i);
        }
        return res;
    }

    public static int [] topm3(int arr[],int m){
        int res [] = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0;j < arr.length-1-i;j++){
                if (arr[j] < arr[j+1]){
                   int temp = arr[j];
                   arr[j] = arr[j+1];
                   arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            res[i] = arr[arr.length-1-i];
        }
        return res;
    }

    public static void quickSort(int arr[],int start,int end){
        if (start >= end){
            return;
        }
        int left = start;
        int right = end;
        int temp = arr[left];
        while (left < right){
            while (left < right &&arr[right] >= temp){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp){
                left++;
            }
            arr[right] = arr[left];

        }
        arr[left] = temp;
        quickSort(arr,start,left-1);
        quickSort(arr,left+1,end);

    }

    public static void heapSort(int arr[]){
        initHeap(arr);
        int len = arr.length;
        for (int i = len - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] =  arr[i];
            arr[i] = temp;
            len--;
            justify(arr, 0, len);
        }
    }
    public static void initHeap(int arr[]){
        for(int i = arr.length-1;i >= 0;i--){
            justify(arr,i,arr.length);
        }
    }
    public static void justify(int arr[],int i,int len){
        int minIndex = i;
        int lchirld = 2*i+1;
        int rchirld = 2*i+2;
        if (lchirld < len && arr[lchirld] < arr[minIndex]){
            minIndex = lchirld;
        }
        if (rchirld < len && arr[rchirld] < arr[minIndex]){
            minIndex = rchirld;
        }
        if (minIndex != i){
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            justify(arr,minIndex,len);
        }
    }

}
