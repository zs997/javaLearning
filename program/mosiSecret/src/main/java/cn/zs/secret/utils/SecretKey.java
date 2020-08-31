package cn.zs.secret.utils;
import java.util.HashMap;

public class SecretKey {
    HashMap<Character,String> nineKeyMap = new HashMap<Character, String>();
    private void  nineKeyMapInit(){
        //  'a' == 97
        char data = 'a';
        StringBuilder sb = new StringBuilder();
        for (char ch = '2';ch <= '9';ch++){
            for (int i = 0; i <3;i++){
                sb.append(data++);
            }
            if (ch == '7' || ch == '9'){
                sb.append(data++);
            }
            nineKeyMap.put(ch,sb.toString());
            sb.delete(0,sb.length());
        }
    }
    //解密
    HashMap<Character,Character> qwe2abc = new HashMap<Character, Character>();
    private  void qwe2abcInit(){
        qwe2abc.put('a','q');
        qwe2abc.put('b','w');
        qwe2abc.put('c','e');
        qwe2abc.put('d','r');
        qwe2abc.put('e','t');
        qwe2abc.put('f','y');
        qwe2abc.put('g','u');
        qwe2abc.put('h','i');
        qwe2abc.put('i','o');
        qwe2abc.put('j','p');
        qwe2abc.put('k','a');
        qwe2abc.put('l','s');
        qwe2abc.put('m','d');
        qwe2abc.put('n','f');
        qwe2abc.put('o','g');
        qwe2abc.put('p','h');
        qwe2abc.put('q','j');
        qwe2abc.put('r','k');
        qwe2abc.put('s','l');
        qwe2abc.put('t','z');
        qwe2abc.put('u','x');
        qwe2abc.put('v','c');
        qwe2abc.put('w','v');
        qwe2abc.put('x','b');
        qwe2abc.put('y','n');
        qwe2abc.put('z','m');
    }
    HashMap<String,Character> mosi2charMap = new HashMap<String, Character>();
    private  void mosi2charMapInit(){
        mosi2charMap.put(".----",'1');
        mosi2charMap.put("..---",'2');
        mosi2charMap.put("...--",'3');
        mosi2charMap.put("....-",'4');
        mosi2charMap.put(".....",'5');
        mosi2charMap.put("-....",'6');
        mosi2charMap.put("--...",'7');
        mosi2charMap.put("---..",'8');
        mosi2charMap.put("----.",'9');
        mosi2charMap.put("-----",'0');
        mosi2charMap.put(".-",'\'');
        mosi2charMap.put("-...",',');
        mosi2charMap.put("-.-.",':');
        mosi2charMap.put("-..",'-');
        mosi2charMap.put(".",'!');
        mosi2charMap.put("..-.",'(');
        mosi2charMap.put("--.",')');
        mosi2charMap.put("....",'?');
        mosi2charMap.put("..",'.');
        mosi2charMap.put(".---",';');
        mosi2charMap.put("-.-",' ');
    }
    public SecretKey(){
       nineKeyMapInit();
       qwe2abcInit();
        mosi2charMapInit();
    }
//    public static void main(String args[]){
//        Scanner sc = new Scanner(System.in);
//        String mosis = sc.nextLine();
//        SecretKey secretKey = new SecretKey();
//        secretKey.decode(mosis);
//    }
    /**  第五层解密
     * n是分成了几个栅栏
     * */

    /**
     * 原数据:you are a silly man!
     * 一层加密 栅栏:yuaeaslymno r  il a!
     * 二层加密 翻转:!a li  r onmylsaeauy
     * 三层加密:!k sh  d iyzfslkckgf
     * 四层加密拼音九键:!52 7442  31 4393943374535223524133
     * 五层摩斯码:. ..... ..--- -.- --... ....- ....- ..--- -.- -.- ...-- .---- -.- ....- ...-- ----. ...-- ----. ....- ...-- ...-- --... ....- ..... ...-- ..... ..--- ..--- ...-- ..... ..--- ....- .---- ...-- ...--
     * */
    private String fence2String(String data,int n){
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder(data);
        int length = data.length();
        //长栅栏的长度
        int longLen = length/n + 1;
        //短栅栏的长度
        int shortLen = longLen-1;
        int longNum = length%n;
        int shortNum = n-longNum;
        StringBuilder datas [] = new StringBuilder [n];
        int index = 0;
        for (int i = 0; i < longNum; i++) {
            datas[index++] = new StringBuilder(temp.substring(0,longLen));
            temp.delete(0,longLen);
        }
        for (int i = 0;i <shortNum;i++){
            datas[index++] = new StringBuilder(temp.substring(0,shortLen));
            temp.delete(0,shortLen);
        }
        for (int i = 0; i < datas[0].length(); i++) {
            for (int j = 0; j < datas.length; j++) {
                if (i < datas[j].length())
                  sb.append(datas[j].charAt(i));
            }
        }
        return sb.toString();
    }
    //第四层解密 翻转
    private String reverse(String data){
        return new StringBuilder(data).reverse().toString();
    }
    //第三层解密 qwe
    private String qwe2abc(String data){
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {

            char ch = data.charAt(i);
            if (qwe2abc.containsKey(ch)){
                Character word = qwe2abc.get(ch);
                sb.append(word);
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    //第二层解密
    //..... ..--- -.- -... ....- ..--- -.... ...-- -.... .---- ..... ..--- ..... ..--- .. .- -... ....- ...-- ..... ..---
    private String nineKeyNums2String(String data){
        if (data == null){
            return  null;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder(data);
       while (temp.length() != 0){
           //是数字的情况
           if(temp.charAt(0) >= '0' && temp.charAt(0) <= '9'){
               String pair = temp.substring(0,2);
               char c = nineKeyNum2char(pair);
               sb.append(c);
              temp.delete(0,2);
           }else {
               sb.append(temp.charAt(0));
                temp.delete(0,1);
           }
       }
        return  sb.toString();
    }
    private char nineKeyNum2char(String s){
        if (s== null || s.length() != 2 || s.charAt(0) =='1'){
            return 0;
        }
        char posi = s.charAt(0);
        if (nineKeyMap.containsKey(posi)){
            String s1 = nineKeyMap.get(posi);
            return s1.charAt(s.charAt(1)-1-'0');
        }
        return  0;
    }
    //第一层解密 摩斯码转成数字和标点
    private String mosis2String(String data){
        StringBuilder sb = new StringBuilder();
        String[] mosis = data.split(" ");
        for (String mosi:mosis){
            if (!mosi2charMap.containsKey(mosi)){
                return "";
            }
            sb.append(mosi2charMap.get(mosi));
        }
        return  sb.toString();
    }

    public String decode(String s){
        //System.out.println("摩斯码:"+s);
        String s1 = mosis2String(s);
       // System.out.println("一层摩斯解密:"+s1);
        String s2 = nineKeyNums2String(s1);
      //  System.out.println("二层拼音九键解密:"+s2);
        String s3 = qwe2abc(s2);
      //  System.out.println("三层qwe解密:"+s3);
        String s4 = reverse(s3);
      //  System.out.println("四层翻转解密:"+s4);
        String s5 = fence2String(s4, 2);
      //  System.out.println("结果栅栏解密:"+s5);
        return  s5;
    }

}
