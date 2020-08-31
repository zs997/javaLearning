package cn.zs.designMode.factory.simpleFactory;

public class MiPhone implements Phone {
   public MiPhone(){
        this.make();
    }
    @Override
    public void make() {
        System.out.println("are you ok ?");
    }

    @Override
    public void open() {
        System.out.println("mi开机了");
    }
}
