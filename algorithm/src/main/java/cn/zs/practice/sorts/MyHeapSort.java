package cn.zs.practice.sorts;

public class MyHeapSort {
	
	
	
	public static void heapSort(int arr[]){
		buildHeap(arr);
		for(int i = arr.length-1;i>0;i--){
			swap(arr, i, 0);
			heapify(arr, 0, i);
		}
	}
	
	public static void buildHeap(int arr[]){
		
		for(int i = (int) Math.floor(arr.length/2.0);i>=0;i--){
			
			heapify(arr, i, arr.length);
		}
	}
	
	public static void heapify(int arr[],int i,int len){
		
		int left = i*2+1;
		int right = i*2+2;
		int maxIndex = i;
		if(left<len&&arr[maxIndex]<arr[left]){
			maxIndex = left;
		}
		if(right<len&&arr[maxIndex]<arr[right]){
			maxIndex = right;
		}		
		if(maxIndex != i){
			swap(arr,maxIndex,i);
			heapify(arr, maxIndex, len);
		}		
		
		
	}
	
	
	public static void swap(int arr[],int i,int j){		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
}
