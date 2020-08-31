package cn.zs.practice.sorts;
import java.util.ArrayList;

public class MyBaseSort {

	public static void BaseSort(int arr[]){



		int max = 0;
		for(int i:arr){
			if(i>max){
				max = i;
			}
		}

		int times = 0;
		while(max != 0){
			max/=10;
			times ++;
		}

		ArrayList<ArrayList<Integer>> queue = new ArrayList<ArrayList<Integer>>();
		//初始化容器
		for(int i =0;i<10;i++){
			//放入0~9 10个桶
			ArrayList<Integer> x = new ArrayList<Integer>();
			queue.add(x);

		}

		for(int time = 0;time < times;time++){

			ArrayList<Integer> x = null;
			//往桶里放数据
			for(int i = 0;i<arr.length;i++){

				int data = arr[i];
				int weight = (data/(int)Math.pow(10, time))%10;

				x = queue.get(weight);
				x.add(data);
				queue.set(weight, x);
			}

			int index = 0;
			for(int i = 0;i<10;i++){
				x = queue.get(i);
				while(!x.isEmpty()){
					arr[index] = x.remove(0);
					index++;
				}
			}

		}




	}

}


