package cn.zs.designPrinciple.dependenceInversion.improve;

//小说类
public class Novel implements IRead{
    //阅读小说
    public void read(){
        System.out.println("阅读小说，放松自己");
    }
}