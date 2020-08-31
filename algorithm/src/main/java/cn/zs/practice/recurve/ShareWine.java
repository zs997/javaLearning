package cn.zs.practice.recurve;
public class ShareWine {
	public static int a = 12;
	public static int b = 8;
	public static int c = 5;
	public static int target = 6;
	public static int data[] = {12,0,0};

	public static void main(String[] args) {

		daojiu_non();
	}

	public static void daojiu_non(){
		int a_s = data[0];
		int b_s = data[1];
		int c_s = data[2];
		while(!(data[0] == target || data[1] == target || data[2] == target)){
			A_to_B();
			B_to_C();
			C_to_A();
			if(data[0] == a_s && data[1] == b_s && data[2] == c_s){
				System.out.println("no sulution");
				return ;
			}
		}
	}

	public static void A_to_B(){
		//最大的瓶子只能往中等的瓶子倒；（若中等的瓶子为空）
		if(data[1] == 0 && data[0] != 0){
			System.out.println("********* a to b *********");
			System.out.println("a = "+data[0]+" b = "+data[1]+" c= "+data[2]);
			//aa -> bb 没有倒满
			if(data[1] + data[0] <= b){
				System.out.println(data[0]);
				data[1] = data[1]+data[0];
				data[0] = 0;
			}else{

				System.out.println(b-data[1]);
				data[0] = data[0] - (b-data[1]);
				data[1] = b;
			}
		}
	}
	public static void B_to_C(){
		//中等的瓶子只能往最小的瓶子倒；（若最小的瓶子不满）
		if(data[2] < c && data[1] != 0){
			System.out.println("***********b to c***********");
			System.out.println("a = "+data[0]+" b = "+data[1]+" c= "+data[2]);
			//bb -> cc 没有倒满
			if(data[2] + data[1] <= c){
				System.out.println(data[1]);
				data[2] = data[2] + data[1];
				data[1] = 0;
			}else{
				//bb -> cc 倒满
				System.out.println(c-data[2]);
				data[1] = data[1] - (c - data[2]);
				data[2] = c;
			}
		}
	}
	public static void C_to_A(){
		//最小的瓶子只能往最大的瓶子倒；（若最小的瓶子已满）
		if(data[2] == c && data[0] != a){
			System.out.println("***********c to a***********");
			System.out.println("a = "+data[0]+" b = "+data[1]+" c= "+data[2]);
			//cc -> aa 没有倒满
			if(data[0] + data[2] <= a){
				System.out.println(data[2]);
				data[0] = data[0] + data[2];
				data[2] = 0;
			}else{
				//cc -> aa 倒满
				System.out.println(a-data[0]);
				data[2] = data[2] - (a - data[0]);
				data[0] = a;
			}
		}
	}

	public static void daojiu(int aa, int bb, int cc){
		System.out.println("aa="+aa+" bb="+bb+" cc="+cc);
		if(aa == target||bb == target||cc == target){
			return ;
		}
		//最大的瓶子只能往中等的瓶子倒；（若中等的瓶子为空）
		if(bb == 0 && aa != 0){
			//aa -> bb 没有倒满
			if(bb+aa <= b){
				daojiu(0,bb+aa,cc);
			}else{
				//aa -> bb 倒满
				daojiu(aa-(b-bb), b, cc);
			}
		}

		//中等的瓶子只能往最小的瓶子倒；（若最小的瓶子不满）
		if(cc < c && bb != 0){
			//bb -> cc 没有倒满
			if(cc + bb <= c){
				daojiu(aa,0,cc+bb);
			}else{
				//bb -> cc 倒满
				daojiu(aa, bb-(c-cc), c);
			}
		}

		//最小的瓶子只能往最大的瓶子倒；（若最小的瓶子已满）
		if(cc == c && aa != a){
			//cc -> aa 没有倒满
			if(aa + cc <= a){
				daojiu(aa+cc,bb,0);
			}else{
				//cc -> aa 倒满
				daojiu(a, bb, c-(a-aa));
			}
		}


	}

}
