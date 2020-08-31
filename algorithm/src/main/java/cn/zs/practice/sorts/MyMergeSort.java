package cn.zs.practice.sorts;



public class MyMergeSort {
	public static void MergeSort(int arr[], int start, int end){
		
		
		if(start == end){
			return ;
		}
	
		int  mid = (start+end)/2;
		MergeSort(arr, start, mid);
		MergeSort(arr, mid+1, end);	
		Merge(arr,start,mid,end);	
	}

	public static void Merge(int[] arr, int start, int mid, int end) {
		int i = start;
		int j = mid + 1;
		int k = 0;
		int [] temp = new int [arr.length] ;
		for(k = start;k <= end;k++){
			temp[k] = arr[k];
		}
		k = start;
		while((i <= mid)  && (j <= end)){
			if(temp[i] < temp[j]){
				arr[k++] = temp[i++];
				
			}else{
				arr[k++] = temp[j++];
			}
		}
		
		while(i <= mid){
			arr[k++] = temp[i++];
		}
		
		while(j <= end){
			arr[k++] = temp[j++];
		}
		
	}
}
