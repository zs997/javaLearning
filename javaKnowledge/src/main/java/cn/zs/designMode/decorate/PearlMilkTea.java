package cn.zs.designMode.decorate;
import java.util.HashMap;
//具体的奶茶
public class PearlMilkTea implements MilkTea {
    @Override
    public String milkTeaName() {
        HashMap<int [],Integer> res = new HashMap<>();

        //ConcurrentHashMap
        return "珍珠奶茶";
    }
    @Override
    public int milkTeaPrice() {
        return 10;
    }
}
