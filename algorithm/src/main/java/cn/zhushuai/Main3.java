package cn.zhushuai;
public class Main3 {
    public static void main(String[] args) {
        int arr [] = {10,2,5,5,6,8,40,6,8,7};
        int m = 3;
       // quickSort(arr,0,arr.length-1);
       initHeap(arr);
       for (int i = arr.length-1;i >= 0;i--){
           int temp = arr[0];
           arr[0] = arr[i];
           arr[i]  = temp;
           justify(arr,0,i);
       }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

    }
    public static void initHeap(int arr[]){
        for (int i = arr.length-1;i >= 0;i--){
            justify(arr,i,arr.length);
        }
    }
    public static void justify(int arr[],int i,int len){
        int left = i*2+1;
        int right = i*2+2;
        int minIndex = i;
        if (left < len && arr[minIndex] > arr[left]){
            minIndex = left;
        }
        if (right < len && arr[minIndex] > arr[right]){
            minIndex = right;
        }
        if (minIndex != i){
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            justify(arr,minIndex,len);
        }


    }
    public static int [] topms(int arr[],int m){
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

}
