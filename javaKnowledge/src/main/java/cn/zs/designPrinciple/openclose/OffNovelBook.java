package cn.zs.designPrinciple.openclose;
/*
*   开闭原则 就是继承并重写覆盖修改
* */
public class OffNovelBook extends NovelBook {

    public OffNovelBook(String name,int price,String author){
        super(name,price,author);
    }
    //覆写价格方法，当价格大于40，就打8析，其他价格就打9析
    public double getPrice(){
        if(this.price > 40){
            return this.price * 0.8;
        }else{
            return this.price * 0.9;
        }
    }
}