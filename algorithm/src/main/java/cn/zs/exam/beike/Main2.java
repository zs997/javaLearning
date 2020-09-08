package cn.zs.exam.beike;

import java.util.Scanner;
/*构造一个字符串
  每一次添加一个字符 或者
  将前面的字符全部复制一遍（只能操作一次）
  问 最小的操作次数
  6
  abcdef

  6

*/
public class Main2 {
    public static void main(String[] args) {
        times();
    }
    public static  void times(){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String data = scanner.nextLine();
        int len = data.length();
        int count = 0;
        while (len >0 ){
            if (len%2 ==0 && data.substring(0,len/2).equals(data.substring(len/2,len))){
                System.out.println(count+len/2+1);
                return;
            }else {
                count++;
                len--;
            }
        }
        System.out.println(data.length());
    }
}
