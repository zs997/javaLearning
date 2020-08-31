package cn.zs.basic.reload;

public class Reload {
    public static void main(String[] args) {
        Human man = new Man();
        Human women = new Women();
        say(man);
        say(women);
          ssss(man);
       ssss(women);
    }
    //重载的时候按 引用匹配
    // 多态是 父类引用指向子类 调用父类方法 其实走的子类
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