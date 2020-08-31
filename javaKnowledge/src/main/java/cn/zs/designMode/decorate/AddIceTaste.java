package cn.zs.designMode.decorate;
//装饰器适用场景：我有一个对象，但是这个对象的功能不能使我满意（咖啡太苦了），
// 我就拿装饰器给他装饰一下（给咖啡加糖）。
public class AddIceTaste extends Taste {
    private String description = "加冰";
    private MilkTea milkTea = null;
    public AddIceTaste(MilkTea milkTea){
        this.milkTea = milkTea;
    }
    public String milkTeaName (){
        return  milkTea.milkTeaName()+" "+description;
    }
    public int milkTeaPrice (){
        return milkTea.milkTeaPrice()+5;
    }
}
