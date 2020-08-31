package cn.zs.designMode.factory.simpleFactory;

public class PhoneFactory {
    public  static Phone makePhone(String phoneType){
        if ("MiPhone".equals(phoneType)){
            return new MiPhone();
        }
        if ("Iphone".equals(phoneType)){
            return new Iphone();
        }
        return null;
    }
}
