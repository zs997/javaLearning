package cn.zs.exam.bilibili;

public class Main3 {
    public static void main(String[] args) {

    }
    public int GetFragment (String str) {
        // write code here
        int len = str.length();
        int count = 1;
        for (int i = 0; i < len-1;i++){
            if (str.charAt(i) != str.charAt(i+1)){
                count++;
            }
        }
        return len/count;
    }
}
