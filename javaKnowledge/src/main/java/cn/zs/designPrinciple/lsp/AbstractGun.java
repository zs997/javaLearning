package cn.zs.designPrinciple.lsp;
/*
*   里氏原则  定义明确的说，只要父类能出现的地方子类也可以出现，
*   而且替换为子类不会产生任何错误或异常，但是反过来就不行，有子类出现的地方，父类未必就能适应
*   使用子类作为函数参数
*   定义2：所有引用基类的地方必须能透明地使用其子类的对象。
    通俗说法:子类可以扩展父类的功能,但不能改变父类原有的功能。
* */
public abstract class AbstractGun{
    //枪支射击的方法
    public abstract void shoot();
}