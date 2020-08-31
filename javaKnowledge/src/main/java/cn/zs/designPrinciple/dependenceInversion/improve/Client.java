package cn.zs.designPrinciple.dependenceInversion.improve;
/*
*   依赖倒置原则
*   依赖倒置原则在java语言中，表现是：
    模块间的依赖通过抽象发生，实现类之间不发生直接的依赖关系，

    其依赖关系是通过接口或抽象类产生的。

    接口或抽象类不依赖实现类
    实现类依赖接口或抽象类
* */
public class Client {
    public static void main(String[] args){
        XiaoMing xiaoming = new XiaoMing();
        IRead literaryClassic = new LiteraryClassic();
        //小明阅读文学经典
        xiaoming.read(literaryClassic);
        IRead novel = new Novel();
        //小明阅读小说
        xiaoming.read(novel);
    }
}
