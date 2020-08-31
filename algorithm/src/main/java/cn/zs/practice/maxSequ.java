package cn.zs.practice;
public class maxSequ {
	public static char [] A = "android".toCharArray();
	public static char [] B = "random".toCharArray();

	public static void main(String[] args) {

		System.out.println(doDp());
		System.out.println(maxLen(A,A.length-1 , B, B.length-1));


	}
	/**
	 * @param char [] a
	 * @param int i  指示a 的最后一下标
	 * @param char [] b
	 * @param int j 指示b 的最后一下标
	 * */
	public static int maxLen(char [] a, int i, char [] b, int j){
		if(i == 0 || j ==0){
			return 0;
		}else if(a[i] == a[j]){
			return maxLen(a, i-1, b, j-1)+1;
		}else{
			return Math.max(maxLen(a, i-1, b, j), maxLen(a, i, b, j-1));
		}
	}

	public static int doDp(){
		int lenA = A.length;
		int lenB = B.length;
		int dp [][] = new int [lenA][lenB];

		//构建第一行 边界值
		for(int i = 0; i < A.length; i++){
			if(A[i] == B[0]){
				dp[i][0] = 1;
				for(int j = i+1;j < A.length; j++){
					dp[j][0] = 1;
				}
				break;
			}
		}
		//构建第一列的边界值
		for(int i = 0; i < B.length; i++){
			if(A[0] == B[i]){
				dp[0][i] = 1;
				for(int j = i+1;j < B.length; j++){
					dp[0][j] = 1;
				}
				break;
			}
		}

		//开始填充矩阵 向多了拓展
		// 0 -> 0~B.len
		// A.len ~ 0 -> 0
		//从（1，1） 开始
		for(int i = 1; i<A.length; i++){
			for(int j = 1; j<B.length;j++){
				if(A[i] == B[j]){
					dp[i][j] = dp[i-1][j-1]+1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}

		for(int i = 0; i < dp.length ;i++){
			for(int j = 0; j<dp[i].length; j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}


		return dp[A.length-1][B.length-1];
	}
}
