package cn.zs.basic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class Reload {
    public static void main(String[] args) {
        Human man = new Man();
        Human women = new Women();
        say(man);
        say(women);
        ssss(man);
        ssss(women);
        Integer integer =new Integer(1);
        integer = 1;
        Class<Integer> integerClass = Integer.class;

    }
    public static void ssss(Human human){
        human.sss();
    }
    public static void say(Human human){
        System.out.println("human");
    }
    public static void say(Man man){
        System.out.println("man");
    }
    public static void say(Women women){
        System.out.println("women");
    }
}
class Human{
    public void  sss(){
        System.out.println("sss human");
        //AtomicStampedReference
    }
}
class Man extends  Human{
    public void  sss(){
        System.out.println("sss Man");
    }
}
class Women extends Human{
    public void  sss(){
        System.out.println("sss woman");
    }
}