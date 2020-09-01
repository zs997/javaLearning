package cn.zs.basic.grammer;

public class Main2 {
    static class F{
        int x = 1;
        public F(){
            System.out.println("f");
        }
        public F(String s){
            System.out.println("f:"+s);
        }
    }
    static class C extends  F{
        int x = 2;
        public C(){
            System.out.println("s");
        }
        public C(String s){
            System.out.println("s "+s);
        }
    }
    public static void main(String args[]){
         F hell = new C("hell");
         //变量不走多态
        System.out.println(hell.x);
    }
}
