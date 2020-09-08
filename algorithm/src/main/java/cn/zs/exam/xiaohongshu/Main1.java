package cn.zs.exam.xiaohongshu;
//arr都是自然数  求出不在arr中的最小正整数
public class Main1 {
    static int findMin(int[][] arr) {
        boolean hs[] = new boolean[arr.length*arr[0].length+1];
        for(int i = 0; i <arr.length;i++){
            for(int j = 0; j < arr[0].length;j++){
                int num = arr[i][j];
                if(num < hs.length){
                    hs[num] = true;
                }
            }
        }
        for(int i = 1;i < hs.length;i++){
            if(!hs[i]){
                return i;
            }
        }
        return hs.length-1;

    }
}
