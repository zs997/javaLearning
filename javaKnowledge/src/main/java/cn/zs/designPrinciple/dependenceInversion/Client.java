package cn.zs.designPrinciple.dependenceInversion;
/*
*       依赖倒置原则
*       具体类之间不依赖，他们都继承了抽象类
*
*
*       XiaoMing类的read方法只与文学经典LiteraryClassic类是强依赖，紧耦合关系，
*       小明同学竟然阅读不了小说类。这与现实明显的是不符合的，代码设计的是有问题的。那么问题在那里呢？
我们看小明类，此类是一个高层模块，并且是一个细节实现类，此类依赖的是一个文学经典LiteraryClassic类，
而文学经典LiteraryClassic类也是一个细节实现类。
这是不是就与我们说的依赖倒置原则相违背呢？
依赖倒置原则是说我们的高层模块，实现类，细节类都应该是依赖与抽象，依赖与接口和抽象类。
*   */
public class Client{
    public static void main(String [] args){
        XiaoMing xiaoming = new XiaoMing();
        LiteraryClassic literaryClassic = new LiteraryClassic();
        //小明阅读文学经典
        xiaoming.read(literaryClassic);
    }
}
