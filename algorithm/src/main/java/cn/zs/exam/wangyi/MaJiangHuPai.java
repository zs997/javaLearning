package cn.zs.exam.wangyi;
import java.util.HashSet;
import java.util.Scanner;
/*      4
 *      1T 4T 7T 2B 5B 8B 9W
 *      1T 2T 3T 4T 5T 6T 7T
 *      1B 2W 3T 4B 5W 6T 8W
 *      2B 8B 5B 2B 6T 7T 4W
 *
 *      out:
 *      YES
 *      NO
 *      YES
 *      NO
 * */
public class MaJiangHuPai {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        Pai pai = new Pai(s);
        System.out.println(pai.yesOrNo());
        for (int j = 1; j < n; j++) {
            String ss = sc.nextLine();
            pai.refresh(ss);
            System.out.println(pai.yesOrNo());
        }

    //       data= new String[]{"1T","4T","7T","2B","5B","8B","9W"};
    //       data= new String[]{"1T","2T","3T","4T","5T","6T","7T"};
    //       data= new String[]{"1B","2W","3T","4B","5W","6T","8W"};
    //       data= new String[]{"2B","8B","5B","2B","6T","7T","4W"};

    }

}
class Pai{
    //条 饼 万 0 1 2
    boolean data[][] = new  boolean [3][10];
    boolean rightData = true;

    private Pai(){

    }
    Pai(String [] source){

        // T 条 对应 data[0]
        // B 饼 对应 data[1]
        // W 万 对应 data[2]
        for (int i = 0; i < source.length; i++) {
            String s = source[i];
            char c = s.charAt(0);
            if (s.charAt(1) == 'T'){
                data[0][(int)(c-'0')] = true;
            }else if(s.charAt(1) == 'B'){
                data[1][(int)(c-'0')] = true;
            }else if(s.charAt(1) == 'W'){
                data[2][(int)(c-'0')] = true;
            }else {
                rightData = false;
            }
        }
    }
    Pai(String ss){
        this(ss.split(" "));
    }
    public String yesOrNo(){
        return check()?"YES":"NO";
    }
    public void refresh(String ss){
        String[] source = ss.split(" ");

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = false;
            }
        }
        // T 条 对应 data[0]
        // B 饼 对应 data[1]
        // W 万 对应 data[2]
        for (int i = 0; i < source.length; i++) {
            String s = source[i];
            char c = s.charAt(0);
            if (s.charAt(1) == 'T'){
                data[0][(int)(c-'0')] = true;
            }else if(s.charAt(1) == 'B'){
                data[1][(int)(c-'0')] = true;
            }else if(s.charAt(1) == 'W'){
                data[2][(int)(c-'0')] = true;
            }else {
                rightData = false;
            }
        }

    }
    public   boolean check(){
        return check1() && rightData;
    }
    public boolean check1(){
        //首先不能有重牌
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 1; j < data[i].length; j++) {
                if (data[i][j]){
                    count++;
                }
            }
        }
        if (count != 7){
            return false;
        }
        //保存三种排的起点
        HashSet<Integer> starts = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            int start = 1;
            boolean foundStart = false;
            for (int j = 1; j < data[i].length; j++) {
                // 1 ~ 9 表示 1 ~ 9 万
                //找到每一种排的第一种排
                if (foundStart){
                    //不是 间隔3的情况下 不可能 表示 不是 1 4 7 这样的情况  false
                    if ((j != start + 3 )&& (j != start +6)){
                        if (data[i][j]){
                            return false;
                        }
                    }
                }else {
                    if (data[i][j]){
                        //找了起头的数字
                        foundStart = true;
                        start = j;
                        if(starts.isEmpty() || !starts.contains(j)){
                            starts.add(j);
                            if(j-6 >= 1){
                                starts.add(j-6);
                            }
                            if (j - 3 >= 1){
                                starts.add(j-3);
                            }
                            if (j+3 <= 9){
                                starts.add(j+3);
                            }
                            if (j+6 <= 9){
                                starts.add(j+6);
                            }
                        }else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}