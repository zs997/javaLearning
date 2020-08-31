package cn.zs.practice.sorts;
import java.util.*;
public class Sorts {
    public static void main(String[] args) {
////        HashMap<String,Integer> map = new HashMap();
   //     Hashtable<String,Integer> map = new Hashtable<>();
       // map.put(null,1);
        Stack<Integer> stack = new Stack<>();
        int arr [] = {6,5,7,8,4,3,1};
        buckectSort(arr);
       // buckectSort
       // quickSort(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //1.选择排序
    public  static void selectSort(int [] arr){
        for(int i = 0;i < arr.length-1;i++){
            int minIndex = i;
            for(int j = i+1;j < arr.length;j++){
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    //2.插入排序
    public static void insertSort(int arr []){
        for(int i = 1; i < arr.length;i++){
            int temp = arr[i];
            int j = i-1;
            for(;j >= 0; j--){
                if(temp < arr[j]){
                    arr[j+1] =arr[j];
                }else{
                   break;
                }
            }
            arr[j+1] = temp;

        }
    }
    //3.冒泡排序
    public static void  bubbleSort(int arr[]){
        for(int i = 0;i <arr.length-1;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] =temp;
                }
            }
        }
    }
    //4.希尔排序
    public static void hearSort(int arr[]){
        int gap = arr.length/2;
        while(gap >= 1){
            //每一组
            for(int i = 0;i< gap;i++){
                //分别对每组中的元素，找到合适位置
                for(int j = i + gap;j < arr.length;j+= gap){
                    int temp = arr[j];
                    int k = j - gap;
                    for(;k >= 0;k -= gap){
                        if(arr[k] > temp){
                            arr[k+gap] = arr[k];
                        }else {
                            break;
                        }
                    }
                    arr[k+gap] = temp;
                }
            }
            gap/= 2;
        }
    }
    //5.归并排序
    public  static void mergeSort(int [] arr, int start,int end){
       if(start >= end){
           return;
       }
       int mid = start + (end-start)/2;
       mergeSort(arr,start,mid);
       mergeSort(arr,mid+1,end);
       mergeSortHelp(arr,start,mid,end);
    }

    private static void mergeSortHelp(int[] arr, int start, int mid, int end) {
        int temp [] = new int[end-start+1];

        int p1 = start;
        int p2 = mid+1;
        int p3 = 0;
        while (p1 <= mid && p2 <= end){
            if (arr[p1] < arr[p2]){
                temp[p3++] = arr[p1++];
            }else {
                temp[p3++] = arr[p2++];
            }
        }
        while (p1 <= mid){
            temp[p3++] = arr[p1++];
        }
        while (p2 <= end){
            temp[p3++] = arr[p2++];
        }

        for(int i = 0; i <temp.length;i++){
            arr[start++] = temp[i];
        }
    }
    //6.快速排序
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
    //7.堆排序 没学会
    public static void heapSort(int arr[]){
        int n = arr.length;
        //构建大顶堆
        for (int i = (n - 2) / 2; i >= 0; i--) {
            downAdjust(arr, i, n - 1);
        }
        //进行堆排序
        for (int i = n - 1; i >= 1; i--) {
            // 把堆顶元素与最后一个元素交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            // 把打乱的堆进行调整，恢复堆的特性
            //从某一坐标开始
            downAdjust(arr, 0, i - 1);
        }
    }
    //下沉操作
    public static void downAdjust(int[] arr, int parent, int n) {
        //临时保存要下沉的元素
        int temp = arr[parent];
        //定位左孩子节点的位置
        int child = 2 * parent + 1;
        //开始下沉
        while (child <= n) {
            // 如果右孩子节点比左孩子大，则定位到右孩子
            if(child + 1 <= n && arr[child] < arr[child + 1])
                child++;
            // 如果孩子节点小于或等于父节点，则下沉结束
            if (arr[child] <= temp ) break;
            // 父节点进行下沉
            arr[parent] = arr[child];
            parent = child;
            child = 2 * parent + 1;
        }
        arr[parent] = temp;
    }

    //8.计数排序
    public static void countSort(int arr []){
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        int d = max- min +1;
        int bucket [] = new int [d];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] -min]++;
        }
        int k = 0;
        for (int i = 0; i < bucket.length; i++) {
            int count = bucket[i];
            for (int j = 0; j < count; j++) {
                arr[k++] = i+min;
            }
        }



    }

    //9.桶排序
    public static void buckectSort(int arr []){
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
            if (max < arr[i])
                max = arr[i];
        }
        int num = (max - min)/5+1;
        ArrayList<ArrayList<Integer>> buckect = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            buckect.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.length; i++) {
            int index = (arr[i] - min) / 5;
            buckect.get(index).add(arr[i]);
        }
        for (int i = 0; i < buckect.size(); i++) {
            Collections.sort(buckect.get(i));
        }
        int k =0;
        for (int i = 0; i < buckect.size(); i++) {
            for (int j :  buckect.get(i)) {
                arr[k++] = j;
            }
        }
    }

    //10.基数排序
    public static void baseSort(int arr []){
        if(arr == null || arr.length < 2) return ;

        int n = arr.length;
        int max = arr[0];
        // 找出最大值
        for (int i = 1; i < n; i++) {
            if(max < arr[i]) max = arr[i];
        }
        // 计算最大值是几位数
        int num = 1;
        while (max / 10 > 0) {
            num++;
            max = max / 10;
        }
        // 创建10个桶
        ArrayList<LinkedList<Integer>> bucketList = new ArrayList<>(10);
        //初始化桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new LinkedList<Integer>());
        }
        // 进行每一趟的排序，从个位数开始排 一直到最大数的最高位
        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < n; j++) {
                // 获取每个数最后第 i 位是数组
                int radio = (arr[j] / (int)Math.pow(10,i-1)) % 10;
                //放进对应的桶里
                bucketList.get(radio).add(arr[j]);
            }
            //合并放回原数组
            int k = 0;
            for (int j = 0; j < 10; j++) {
                for (Integer t : bucketList.get(j)) {
                    arr[k++] = t;
                }
                //取出来合并了之后把桶清光数据
                bucketList.get(j).clear();
            }
        }
        return ;
    }
}
