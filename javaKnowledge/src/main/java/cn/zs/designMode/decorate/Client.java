package cn.zs.designMode.decorate;

public class Client {
    public static void main(String args[]){
        MilkTea honeyMilkTea = new HoneyMilkTea();
        System.out.println(honeyMilkTea.milkTeaName()+" "+honeyMilkTea.milkTeaPrice() );
        AddIceTaste addIceTaste = new AddIceTaste(honeyMilkTea);
        System.out.println("加冰的奶茶 "+addIceTaste.milkTeaName()+" "+addIceTaste.milkTeaPrice());
    }
}
