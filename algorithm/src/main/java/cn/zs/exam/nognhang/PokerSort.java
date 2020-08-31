package cn.zs.exam.nognhang;

import java.util.Arrays;

public class PokerSort {
    public static void main(String args[]){
            String [] data = {"s1","s3","s9","s4","h1","p3","p2","q5","q4","q9","k2","k1"};
        String[] poker = new PokerSort().getPoker(data);
        for (String s : poker) {
            System.out.println(s);
        }
    }
  public  String [] getPoker(String [] cards){
      String[] convert = convert(cards);
      Arrays.sort(convert);
      String[] res = reverse(convert);
      return  res;
  }
  private String [] reverse(String [] cards){
      String [] res = new String[cards.length];
      int i = 0;
      for ( i = 0; i < cards.length; i++) {
          String card = cards[i];
          StringBuilder sb = new StringBuilder(card);
          char c = sb.charAt(0);
          if (c == 'a'){
              sb.setCharAt(0,'k');
          }else if (c=='b'){
              sb.setCharAt(0,'s');
          }else if (c =='c'){
              sb.setCharAt(0,'h');
          }else if (c == 'd'){
              sb.setCharAt(0,'p');
          }else if (c == 'e'){
              sb.setCharAt(0,'q');
          }else {
              sb.setCharAt(0,'z');
          }
          res[i] = sb.toString();
      }
      return res;
  }
  private String []  convert(String [] cards){
        String [] res = new String[cards.length];
        int i = 0;
      for ( i = 0; i < cards.length; i++) {
          String card = cards[i];
          StringBuilder sb = new StringBuilder(card);
          char c = sb.charAt(0);
          if (c == 'k'){
              sb.setCharAt(0,'a');
          }else if (c=='s'){
              sb.setCharAt(0,'b');
          }else if (c =='h'){
              sb.setCharAt(0,'c');
          }else if (c == 'p'){
              sb.setCharAt(0,'d');
          }else if (c == 'q'){
              sb.setCharAt(0,'e');
          }else {
              sb.setCharAt(0,'z');
          }
          res[i] = sb.toString();
      }
        return res;
    }
}
