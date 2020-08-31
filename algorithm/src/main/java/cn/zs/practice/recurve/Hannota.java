package cn.zs.practice.recurve;

public class Hannota {
	
	public static void main(String[] args) {
		move(3,'a','b','c');
	}
	
	public static void move(int n, char a, char b, char c){
		if(n == 1){
			System.out.println("move "+a+" to "+c);
			
		}else{
			move(n-1,a,c,b);
			System.out.println("move "+a+" to "+c);
			move(n-1,b,a,c);
		}
		
	}
}
