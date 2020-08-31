package cn.zs.designMode.factory.simpleFactory;

public class Test {
    public static void main(String args[]){
        Phone phone = PhoneFactory.makePhone("MiPhone");
        phone.open();
    }
}
