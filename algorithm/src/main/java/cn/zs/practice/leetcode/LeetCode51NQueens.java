package cn.zs.practice.leetcode;
public class LeetCode51NQueens {
    public static int queen_num = 8;  //皇后数量
    public static int [] location = new int [queen_num]; //location[i] 表示第i行的 皇后 应属于哪一列？ 0~7 表示8个皇后
    public static int count = 0;
    public static void main(String[] args) {
//		backtrack(0);
//		System.out.println(count);
        backtrack(0);
        System.out.println(count);
    }

    /**
     * 非递归实现把皇后寻找
     * */
    public static void backTrack_non(){
        //0~num-1 存放皇后位置
        int [] location = new int [queen_num];
        int k = 0;
        int count = 0;
        while(k >= 0){

            while((location[k] <= queen_num - 1)&&(!check(location,k))){
                location[k]++;
            }

            if(location[k] <= queen_num-1){
                //找到了合适位置
                if(k == queen_num-1){
                    //输出一组解
                    count ++;
                    for(int i = 1; i < location.length; i++){
                        System.out.print(location[i]+" ");
                    }
                    System.out.println();
                    System.out.println("*********");
                    k--;
                    location[k]++;
                }else{
                    location[++k] = 0;
                }
            }else{
                k--;
                if(k >= 0){
                    location[k]++;
                }

            }

        }
        System.out.println(count);

    }

    //判断皇后k的位置是否合理
    public static boolean check(int [] arr,int k){
        if(k == 0){
            //第0个皇后 任意位置都可以
            return true ;
        }else{
            for(int i = 0; i < k; i++){
                if((arr[i] == arr[k]) || (Math.abs(arr[i] - arr[k]) == (k - i))){
                    return false;
                }
            }
        }
        return true;
    }


    /**为前n个找到合理位置？
     * */
    public static void backtrack(int n){
        if(n >= queen_num){
            //找到了一组解
            count ++;
            for(int i = 0; i < location.length; i++){
                System.out.print(location[i]+" ");
            }
            System.out.println();
            System.out.println("*********");


        }else{
            //穷举第n个皇后的位置
            for(int i = 0; i < queen_num; i++){
                //在此处赋值很有道理
                location[n] = i;
                if(isOk(location, n)){
//					location[n] = i;
                    backtrack(n+1);
                }
            }

        }

    }

    /** function： 判断某一个皇后 位置是否合理
     * 假设前面的皇后都符合位置约束
     * 只需判断 第n个皇后 的出现  和之前的产生了冲突
     *
     * true 表示位置合理
     * */
    public static boolean isOk(int loca[],int n){
        //第一个皇后随便放
        if(n == 0){
            return true ;
        }

        if(n >= queen_num){
            return false ;
        }

        if(loca[n] >= queen_num){
            return false ;
        }

        for(int i = 0; i < n; i++){
            //斜对角不能行  相同不能行
            if((loca[i]==loca[n])||Math.abs(loca[i]-loca[n]) == Math.abs(i-n)){
                return false;
            }
        }
        return true;
    }
}
