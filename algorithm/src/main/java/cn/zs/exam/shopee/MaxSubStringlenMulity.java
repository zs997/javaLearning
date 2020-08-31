package cn.zs.exam.shopee;
/*      字母表中前n个字母组成的字符串
*       adcbadcbedbadedcbacbcadbc 的两个子串
*       如果s1 s2中没有公共的字母 可以参与计算（s1（s2）本身可以有重复）
*       求s1.len *s2.len 最大值
*
* */
public class MaxSubStringlenMulity {
    public static void main(String args[]){
        int res = max("adcbadcbedbadedcbacbcadbc");
        System.out.println(res);
    }
    private static int max(String s){
        if (s== null || s.length() ==0){
            return -1;
        }
        int max = 0;
        int len = s.length();
        //第一个子串的起点  i
        for (int i = 0; i < len-1; i++) {
            //第一个子串的终点
            for(int j  = i + 1;j < len-1;j++){
                    String s1 = s.substring(i,j);
                    //第二子串的起点
                    for (int k = j;k < len;k++){
                        String temp = s.substring(k, k + 1);
                        if (contains(s1,temp)){
                            continue;
                        }
                        //第二子串的终点
                        for (int m = k+1;m<len;m++){
                           String s2 =s.substring(k,m);
                            if (contains(s1,s2))
                                continue;
                            max = Math.max(max,s1.length()*s2.length());
                        }
                    }
            }
        }
        return max;
    }
    //s1中有s2的字母  有则返回true
    private static boolean contains(String s1, String s2) {
        boolean words [] = new boolean[128];
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            words[c]  =true;
        }
        for (int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if (words[c]){
                return true;
            }
        }
        return false;
    }
}
