package cn.zs.exam.shopee;

import java.util.ArrayList;
/*
*   给定一字符串，最少补充几个字符
*   可以产生循环节
*   KMP
* */
public class Main2 {
    public static void main(String[] args) {
     //   System.out.println(getMinLen("abcabca"));
        System.out.println(getMinLen1("abcabca"));
    }
    //不太行
    public static int getMinLen (String str) {
        // write code here
        ArrayList<Character> list = new ArrayList<>();
        int i = 0;
        for (; i < str.length(); i++) {
            if (list.isEmpty() || list.get(0) != str.charAt(i)){
                list.add(str.charAt(i));
            }else {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < list.size(); j++) {
                    sb.append(list.get(j));
                }
                String s = sb.toString();
                int length = s.length();
                if (i+length > str.length()){
                    break;

                }else {
                    if (s.equals(str.substring(i,i+length)))
                        i += length;
                    else
                        list.add(str.charAt(i));
                }

            }

        }
        int i1 = list.size() - (str.length() - i);
        return i1;

    }

    /**
     * KMP算法
     * 计算t的最小长度
     * @param str string字符串 输入的字符串
     * @return int整型
     */
    static int [] nex = new int[110000];
    static char[] a ;
    static   int la;
    public static int getMinLen1 (String str) {
        // write code here
        a = str.toCharArray();
        la = str.length();
        int x = -1,y=0;
        nex[0] = -1;

        while(y<la){
            while(x!=-1&&a[x]!=a[y])
            {
                x = nex[x];
            }
            nex[++y] = ++x;
        }
        if(nex[la]>0&&la%(la-nex[la])==0){
            return 0;
        }else{
            return la-nex[la]-la%(la-nex[la]);
        }
    }
}
