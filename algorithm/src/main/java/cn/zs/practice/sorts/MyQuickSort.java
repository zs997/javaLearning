package cn.zs.practice.sorts;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MyQuickSort {
	
	public static void QuickSort(int arr[]){
		QuickSort(arr,0,arr.length-1);
	}
	public static void QuickSort(int arr[],int left,int right){
		
		if(left >=right){
			return ;
		}
		int mid = partSort(arr, left, right);
		QuickSort(arr, left, mid-1);
		QuickSort(arr, mid+1, right);
		
	}
	
	public static int partSort(int arr[], int left,int right){
		
		int partition = left;
		
		int temp = arr[partition];
		
		while(left < right){
			
			while((left<right)&&(arr[right] >= temp)){
				right--;
			}
			
			while((left<right)&&arr[left] <= temp){
				left++;
			}
			
			swap(arr,left,right);
		}
		if(left != partition){
			swap(arr,left,partition);
		}
		
		return left;			
	} 	
	
	private static void swap (int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void quickSortNon(int [] arr, int start, int end){
		
		Stack<Map<String, Integer>> stack = new Stack<Map<String, Integer>>();
		Map<String, Integer> s = new HashMap<>();
		
		s.put("start", start);
		s.put("end", end);
		
		stack.push(s);
		Map <String,Integer> temp = null;
		while(!stack.isEmpty()){
			temp = stack.pop();
			int mid = partSort(arr, temp.get("start"), temp.get("end"));
			if(mid-1 > temp.get("start")){
				Map<String, Integer> sl = new HashMap<>();				
				sl.put("start", start);
				sl.put("end", mid-1);
				stack.push(sl);
				
			}
			
			if(mid+1 < temp.get("end")){
				Map<String, Integer> sr = new HashMap<>();				
				sr.put("start", mid+1);
				sr.put("end", end);
				stack.push(sr);
			}
			
		}
	}
	

	
	
}
