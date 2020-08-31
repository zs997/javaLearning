package cn.zs.practice.leetcode;

public class LeetCode6ZigZagConversion {

	public static void main(String[] args) {
		  System.out.println(convert("PAYPALISHIRING", 3));
	}
	public static String convert(String s, int nRows) {

        if(s == null || s.equals("")){
            return "";
        }
        char[] arr = s.toCharArray();
        StringBuilder res = new StringBuilder();
        StringBuilder [] sb = new StringBuilder[nRows];
        for(int i = 0; i <sb.length; i++){
            sb[i] = new StringBuilder();
        }
        boolean dir = true;
        int j = 0;
        for(int i = 0; i < arr.length; i++){
            sb[j].append(arr[i]);
            if(dir){
                j++;
            }else{
                j--;
            }

            if(j == -1){
                dir = true;
                j = 1;

            }else if(j == nRows){
                dir = false;
                j = nRows - 2;

            }
        }
        for(StringBuilder ss : sb){
            res.append(ss);
        }
        return res.toString();
    }
}

