package cn.zs.secret.utils;

import java.util.HashMap;

public class SecretLock {
    HashMap<Character,Integer> nineKeyMap = new HashMap<Character, Integer>();
    private void  nineKeyMapInit(){
        int base = 21;
        int delta = 0;
        for(char ch = 'a'; ch <= 'z';ch++){
            nineKeyMap.put(ch,base + delta);
            delta++;
            if (delta ==3){
                if (!(base/10 == 7 || base/10 == 9)){
                        base += 10;
                        delta = 0;
                }
            }
            if (delta == 4){
                base += 10;
                delta = 0;
            }
        }
    }
    //加密
    HashMap<Character,Character> abc2qweMap = new HashMap<Character, Character>();
    private void abc2qweMapInit(){
        abc2qweMap.put('q','a');
        abc2qweMap.put('w','b');
        abc2qweMap.put('e','c');
        abc2qweMap.put('r','d');
        abc2qweMap.put('t','e');
        abc2qweMap.put('y','f');
        abc2qweMap.put('u','g');
        abc2qweMap.put('i','h');
        abc2qweMap.put('o','i');
        abc2qweMap.put('p','j');
        abc2qweMap.put('a','k');
        abc2qweMap.put('s','l');
        abc2qweMap.put('d','m');
        abc2qweMap.put('f','n');
        abc2qweMap.put('g','o');
        abc2qweMap.put('h','p');
        abc2qweMap.put('j','q');
        abc2qweMap.put('k','r');
        abc2qweMap.put('l','s');
        abc2qweMap.put('z','t');
        abc2qweMap.put('x','u');
        abc2qweMap.put('c','v');
        abc2qweMap.put('v','w');
        abc2qweMap.put('b','x');
        abc2qweMap.put('n','y');
        abc2qweMap.put('m','z');
    }
    HashMap<Character,String> num2mosiMap = new HashMap<Character, String>();
    private void num2mosiMapInit(){
        num2mosiMap.put('1',".----");
        num2mosiMap.put('2',"..---");
        num2mosiMap.put('3',"...--");
        num2mosiMap.put('4',"....-");
        num2mosiMap.put('5',".....");
        num2mosiMap.put('6',"-....");
        num2mosiMap.put('7',"--...");
        num2mosiMap.put('8',"---..");
        num2mosiMap.put('9',"----.");
        num2mosiMap.put('0',"-----");
        num2mosiMap.put('\'',".-");
        num2mosiMap.put(',',"-...");
        num2mosiMap.put(':',"-.-.");
        num2mosiMap.put('-',"-..");
        num2mosiMap.put('!',".");
        num2mosiMap.put('(',"..-.");
        num2mosiMap.put(')',"--.");
        num2mosiMap.put('?',"....");
        num2mosiMap.put('.',"..");
        num2mosiMap.put(';',".---");
        num2mosiMap.put(' ',"-.-");
    }
   public SecretLock(){
        nineKeyMapInit();
        abc2qweMapInit();
        num2mosiMapInit();
    }
    //第一层加密 栅栏
    private String string2fence(String data,int n){
        StringBuilder res = new StringBuilder();
        //n个栅栏
        StringBuilder [] datas = new StringBuilder[n];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = new StringBuilder();
        }
        int posi = 0;
        for (int i = 0; i < data.length(); i++) {
            if (posi == n){
                posi = 0;
            }
            datas[posi].append(data.charAt(i));
            posi++;
        }
        for (int i = 0; i < datas.length; i++) {
            res.append(datas[i]);
        }
        return res.toString();
    }
    //第二层加密 翻转
    private String reverse(String data){
        return new StringBuilder(data).reverse().toString();
    }
    //第三层加密 qwe加密
    private String abc2qwe(String data){
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if(abc2qweMap.containsKey(ch)){
                Character word = abc2qweMap.get(ch);
                sb.append(word);
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    //第四层 拼音九键换算成数字
    private String nineKeyString2Nums(String data){
     StringBuilder res =new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char c = data.charAt(i);
            if (nineKeyMap.containsKey(c)){
                Integer integer = nineKeyMap.get(c);
                res.append(integer);
            }else {
                res.append(c);
            }
        }
        return  res.toString();
    }
    //第五层 数字转换成摩斯码
    /*为了引入标点符号
    1. 上标点 ' ascii55  以此类推 对应摩斯码 a ".-"
    2. 逗号 ， b "-..."
    3. 冒号 ： c "-.-."
    4. 减号 -  d "-.."
    5.叹号 ！  e "."
    6. 括号 （ f "..-."
    7.括号 ）  g "--."
    8.问号？   h "...."
    9.句号 .   i ".."
    10 分号 ;  j ".---"
    11 空格    k "-.-"
    * */
    private String nums2mosis(String data){
       StringBuilder res = new StringBuilder();
        for (int i = 0; i < data.length();i++) {
            char c = data.charAt(i);
           if (!num2mosiMap.containsKey(c)){
              return  "遇到了非法字符!"+(c-0);
            }else {
               res.append(num2mosiMap.get(c)+" ");
           }

        }
        return  res.deleteCharAt(res.length()-1).toString();
    }
    //加密
    public String encode(String data){
     //   System.out.println("原数据:"+ data);
        String s1 = string2fence(data, 2);
      //  System.out.println("一层加密 栅栏:"+s1);
        String s2 = reverse(s1);
     //   System.out.println("二层加密 翻转:"+s2);
        String s3 = abc2qwe(s2);
     //   System.out.println("三层加密:"+s3);
        String s4 = nineKeyString2Nums(s3);
      //  System.out.println("四层加密拼音九键:"+s4);
        String s5 = nums2mosis(s4);
     //   System.out.println("五层摩斯码:"+s5);
        return s5;
    }
//    public static void main(String args[]){
//            SecretLock secretLock = new SecretLock();
//            secretLock.encode("fuckyou");
//    }
}
