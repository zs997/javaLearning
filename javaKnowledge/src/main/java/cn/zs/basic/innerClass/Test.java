package cn.zs.basic.innerClass;

public class Test {
    public static void main(String[] args)  {
        //第一种方式：
        Outter outter = new Outter();
        Outter.Inner inner = outter.new Inner();  //必须通过Outter对象来创建

        //第二种方式：
        Outter.Inner inner1 = outter.getInnerInstance();
    }
}

class Outter {
    private Inner inner = null;
    public Outter() {

    }

    public Inner getInnerInstance() {
        if(inner == null)
            inner = new Inner();
        return inner;
    }

    class Inner {
        public Inner() {

        }
    }
}