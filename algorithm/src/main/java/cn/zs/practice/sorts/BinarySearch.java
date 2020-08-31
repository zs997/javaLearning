package cn.zs.practice.sorts;

public class BinarySearch {
	public static int binarySearch(int arr[],int target){
		int low = 0;
		int high = arr.length-1;
		int mid = 0;
		while(low<=high){
			 mid = (low+high)/2;
			if(arr[mid] == target){
				return mid;
			}else if(arr[mid]>target){
				high = mid-1;
			}else{
				low = mid +1;
			}
		}				
		return -1;
	}
	
	
	public static int binarySearchRec(int arr[],int left,int right,int target){
		
		if(left>right){
			return -1;
		}
		
		int mid = (left + right)/2;
		if(arr[mid] == target){
			return mid;
		}else if(arr[mid] > target){
			return binarySearchRec(arr,left,mid-1,target);
		}else{
			return binarySearchRec(arr,mid+1,right,target);
		}
		

	}
}
