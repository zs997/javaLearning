package cn.zs.designMode.factory.factoryMethod;

import cn.zs.designMode.factory.simpleFactory.Phone;

public class Test {
    public static void main(String args[]){
        AbstractFactory miFactory = new XiaoMiFactory();
        AbstractFactory appleFactory = new AppleFactory();
        Phone mi = miFactory.makePhone();// make xiaomi phone!
        Phone iphone = appleFactory.makePhone();// make iphone!
        mi.open();
        iphone.open();
    }
}
