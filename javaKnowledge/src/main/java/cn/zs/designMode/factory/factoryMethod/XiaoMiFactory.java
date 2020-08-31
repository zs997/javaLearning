package cn.zs.designMode.factory.factoryMethod;

import cn.zs.designMode.factory.simpleFactory.MiPhone;
import cn.zs.designMode.factory.simpleFactory.Phone;

public class XiaoMiFactory implements AbstractFactory{
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
}