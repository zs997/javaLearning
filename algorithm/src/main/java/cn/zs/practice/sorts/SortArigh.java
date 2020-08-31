package cn.zs.practice.sorts;

public class SortArigh {
	public static void main(String[] args) {
		int arr [] = {10,5,3,6,44,555,66,775,88,99,99,44,125,236};
//		int arr [] = {46,33,22,11};
		print(arr);
//		MyHeapSort.heapSort(arr);
//		MyheerSort.heerSort(arr);
//		selectSort(arr);
//		selectSortModi(arr);
//		bubleSort(arr);
//		insertSort(arr);
//		binaryInsertSort(arr);

//		HeapSort.heapSort(arr);
//		maxHeapSort(arr);
//		shellSort(arr);
//		MyQuickSort.QuickSort(arr);
//		MyQuickSort.quickSortNon(arr,0,arr.length-1);
		MyMergeSort.MergeSort(arr, 0, arr.length-1);
//		MyMergeSort.Merge(arr, 0, (arr.length-1)/2, arr.length-1);
//		MyBaseSort.BaseSort(arr);
//		System.out.println("++"+BinarySearch.binarySearchRec(arr, 0, arr.length-1, -10));
		print(arr);
	}
	public static void print(int arr[]){
		System.out.println("***************");
		for(int i:arr){
			System.out.println(i);
		}
	}

	//最大堆排序
	public static void maxHeapSort(int arr[]){

		buildMaxHeap(arr);
		for(int i = arr.length-1;i > 0;i--){
			swap(arr,0,i);
			heapify(arr,0,i);

		}

	}
	public static void buildMaxHeap(int arr[]){

		for (int i = (int)Math.floor(arr.length / 2) - 1; i >= 0; i--) {
			heapify(arr, i, arr.length);
		}
	}

	//i 及之后 将数组存储的树 构成最大堆
	//需要假设i 之后的子树都是按最大堆排列
	private static void heapify(int[] arr, int i, int len) {
		//如果i结点是最大堆顶 执行一次函数不会有操作
		//arr[0] 堆顶  左子树 0*2+1  右子树 0*2+2
		int left = i*2+1;
		int right = i*2+2;
		int maxIndex = i; //先认为最大的为堆顶
		if(left < len && arr[maxIndex]<arr[left]){
			maxIndex = left;
		}
		if(right < len && arr[maxIndex]<arr[right]){
			maxIndex = right;
		}
		if(maxIndex != i){
			//最大元素不在堆顶 需要调整 否则不需要动  i及之后的子树 都已经构成最大堆
			swap(arr,maxIndex,i); //交换堆顶 但可能引起maxindex处 不再是最大堆
			heapify(arr,maxIndex,len);
		}

	}

	private static void swap(int arr[],int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	//希尔排序
	public static void shellSort(int arr[]){

		for(int gap = arr.length/2;gap>0;gap/=2){
			for(int i =gap;i<arr.length;i++){
				GroupInsertI(arr,gap,i);
			}
		}

	}

	private static void GroupInsertI(int arr[],int gap,int i){
		int temp = arr[i];
		int j = 0;
		for(j = i-gap;j>=0&&(arr[j]>temp);j-=gap){
			arr[j+gap] = arr[j];
		}
		arr[j+gap] = temp;
	}



	//二分插入排序
	public static void binaryInsertSort(int arr[]){

		int temp = 0;
		for(int i = 1;i<arr.length;i++){
			temp = arr[i];

			int left = 0;
			int right = i-1;
			int mid = 0;

			while(left<=right){

				mid = (left+right)/2;
				if(arr[mid] >temp){
					right = mid-1; //第一个大循环i=1 左边大于右边 left=0 right = -1
				}else{
					left = mid+1; //第一个大循环i=1 左边小于右边  left=1 right = -1
				}
			}  //left 表示要插入元素的下标位置

			int j = i-1;
			for(;j>=left;j--){
				arr[j+1] = arr[j];
			}

			arr[left] = temp;

//			for(;j>=0;j--){
//
//				if(arr[j]>temp){
//
//					arr[j+1] = arr[j];
//
//				}else{
//					break;
//				}
//			}

//			arr[j+1] = temp;

		}
	}


	//直接插入排序
	public static void insertSort(int arr[]){

		int temp = 0;
		for(int i = 1;i<arr.length;i++){
			temp = arr[i];
			int j = i-1;
			for(;j>=0;j--){

				if(arr[j]>temp){

					arr[j+1] = arr[j];

				}else{
					break;
				}
			}

			arr[j+1] = temp;

		}
	}

	//选择排序
	public static void selectSort(int arr []){

		for(int i = 0;i<arr.length;i++){
			int index = i;
			for(int j = i;j<arr.length;j++){
				if(arr[j]<arr[index]){
					index = j;
				}
			}
			int temp =arr[index];
			arr[index] = arr[i];
			arr[i] = temp;
		}
	}

	public static void selectSortModi(int arr[]){
		int temp = 0;
		int min = 0;
		for(int i = 0;i<arr.length;i++){
			min = arr[i];
			for(int j = i;j<arr.length;j++){
				if(arr[j]<min){
					min = arr[j];
					temp  = arr[i];
					arr[i] = min;
					arr[j] = temp;
				}
			}


		}
	}

	public static void bubleSort(int arr []){
		for(int i=0;i<arr.length-1;i++){
			for(int j = 0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
