package cn.zs.designMode.factory.simpleFactory;

public class Iphone implements Phone {
    public Iphone(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("apple");
    }

    @Override
    public void open() {
        System.out.println("apple 开机了");
    }
}
