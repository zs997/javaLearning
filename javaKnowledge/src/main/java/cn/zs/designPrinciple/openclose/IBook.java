package cn.zs.designPrinciple.openclose;
/*
开闭原则  修改一个类  继承并重写方法  不修改原来代码
* */
public interface IBook{
    public String getName();
    public double getPrice();
    public String getAuthor();
}