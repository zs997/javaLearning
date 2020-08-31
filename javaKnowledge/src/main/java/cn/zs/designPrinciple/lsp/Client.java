package cn.zs.designPrinciple.lsp;
/*
*   使用抽象类接收实现类的对象，类似于多态，这时候就是里氏原则
* */
public class Client{
    public static void main(String [] args){
        Soldier soldier = new Soldier();
        //设置士兵手握手枪
        soldier.setGun(new Handgun());
        soldier.killEnemy();
        //设置士兵手握步枪
        soldier.setGun(new Rifle());
        soldier.killEnemy();
        //设置士兵手握机枪
        soldier.setGun(new CachineGun());
        soldier.killEnemy();
    }
}