package cn.zs.designMode.factory.abstractFactory;

import cn.zs.designMode.factory.simpleFactory.MiPhone;
import cn.zs.designMode.factory.simpleFactory.Phone;

public class XiaoMiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new MiPhone();
    }
    @Override
    public PC makePC() {
        return new MiPC();
    }
}
