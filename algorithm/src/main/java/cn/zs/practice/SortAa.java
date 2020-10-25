package cn.zs.practice;

import java.util.Arrays;
import java.util.Comparator;

public class SortAa {
    public static void main(String args[]){
        String data = "sfcanSDFISHIRFdsfismgocmxsopwZSDAbcasAB";
       // Character [] chars = data.toCharArray();
        Character [] chars = new Character[data.length()];
        for (int i = 0; i < data.length(); i++) {
            chars[i] = data.charAt(i);
        }
        sort(chars);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        System.out.println(sb);
    }
    public static void sort( Character [] chars){
        Arrays.sort(chars, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {

                if (o1 >= 97 && o1 <= 122 && o2 >= 97 && o2 <= 122){
                    //都是小写
                    return o1-o2;
                }else if(o1 >= 65 && o1 <= 90 && o2 >= 65 && o2 <= 90){
                    //都是大写
                    return o1-o2;
                }else {
                    //找出大写的 转小写
                    if(o1 >=65 && o1 <= 90){
                       //o1大写
                        char temp = (char)(o1 + 32);
                        if (temp == o2){
                            return -1;
                        }else {
                            return temp - o2;
                        }
                    }else {
                        //o2大写
                        char temp = (char)(o2+32);
                        if (o1 == temp){
                            return 1;
                        }else {
                            return o1 - temp;
                        }
                    }
                }
            }
        });
    }

}
