package cn.zs.practice.sorts;

public class MyheerSort {
	
	public static void heerSort(int arr[]){
		
		
		for(int gap =arr.length/2;gap>0;gap/=2){
			
			for(int i = gap;i<arr.length;i++){
				GroupInsertI(arr, gap, i);
			}		
		}
		
	}
	
	public static void GroupInsertI(int arr[],int gap,int i){
		int j = 0;
		int temp = arr[i];
		for(j=i-gap;(j >= 0)&&(arr[j]>temp);j-=gap){
			arr[j+gap] = arr[j];
		}
		arr[j+gap] = temp;
	}
	
//	public static void swap(int arr[],int i,int j){
//		int temp = arr[i];
//		arr[i] = arr[j];
//		arr[j] = temp;
// 	}
}
