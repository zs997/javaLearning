package cn.zs.designMode.decorate;
//具体的奶茶
public class HoneyMilkTea implements MilkTea {
    @Override
    public String milkTeaName() {
        return "蜂蜜奶茶";
    }

    @Override
    public int milkTeaPrice() {
        return 15;
    }
}
