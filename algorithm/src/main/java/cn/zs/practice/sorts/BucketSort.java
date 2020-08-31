package cn.zs.practice.sorts;

public class BucketSort {
	
	public static void main(String[] args) {
		int arr[] = {12,2,2,3,12,6,6,7,18};
		int max = 18;
		bucketSort(arr, max);
	}
	
	public static void bucketSort(int arr[],int max){
		
		int bucket [] = new int [max+1];
		
		for(int i = 0; i < arr.length; i ++){
			
			bucket[arr[i]] ++;
		}
		
		for(int i = 0; i < bucket.length; i ++){			
			while(bucket[i] > 0){
				System.out.print(i+" ");
				bucket[i]--;
			}
		}
	}
}
