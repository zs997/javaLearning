package cn.zs.designMode.factory.abstractFactory;

import cn.zs.designMode.factory.simpleFactory.Phone;

public interface AbstractFactory {
    Phone makePhone();
    PC makePC();
}
