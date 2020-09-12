package cn.zs.practice;

import java.util.concurrent.ConcurrentHashMap;

public class Sports {
	
	public static void Schedule(int [][] table ,int n){
		if(n == 1){
			table[0][0] = 1;
		}else{
			int m = n/2;
			Schedule(table, m);
			for(int i = 0; i < m; i++){
				for(int j = m; j < n; j++){
					table[i][j] = table[i][j-m] + m;
				}
			}
			
			for(int i = m; i < n; i++){
				for(int j = 0; j < m; j++){
					table[i][j] = table[i-m][j] + m;					
				}
			}
			
			for(int i = m; i < n; i++){
				for(int j = m; j < n; j++){
					table[i][j] = table[i-m][j-m];
				}
			}
			
			
		}
		
	}
	
	public static void ScheduleNon(int [][] table){
		int len = table.length;
		int n = len;
		int k = 0;
		while(n != 1){
			n  = n >> 1;
			k++;
		}
		//ConcurrentHashMap
		table[0][0] = 1;
		int m = 1;
		n = 2;
		
		
		for(int times = 0; times < k; times++){
			
			for(int i = 0; i < m; i++){
				for(int j = m; j < n; j++){
					table[i][j] = table[i][j-m] + m;
				}
			}
			
			for(int i = m; i < n; i++){
				for(int j = 0; j < m; j++){
					table[i][j] = table[i-m][j] + m;					
				}
			}
			
			for(int i = m; i < n; i++){
				for(int j = m; j < n; j++){
					table[i][j] = table[i-m][j-m];
				}
			}
			
			m *= 2;
			n *=2;
		}
		
	}
	public static void print(int [][] table){
		for(int i = 0; i < table.length; i++){
			for(int j = 0; j < table[i].length; j++){
				System.out.print(table[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
//		int n = 8;
//		System.out.println(n>>1);
		int [][] table = new int [8][8];
//		Schedule(table, 8);
		ScheduleNon(table);
		print(table);
		
	}
	
}
