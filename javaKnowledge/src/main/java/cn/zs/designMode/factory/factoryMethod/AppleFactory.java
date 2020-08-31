package cn.zs.designMode.factory.factoryMethod;

import cn.zs.designMode.factory.simpleFactory.Iphone;
import cn.zs.designMode.factory.simpleFactory.Phone;

public class AppleFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new Iphone();
    }
}