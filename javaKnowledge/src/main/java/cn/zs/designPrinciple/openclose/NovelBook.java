package cn.zs.designPrinciple.openclose;
/*
*   第一版的代码
* */
public class NovelBook implements IBook{
    private String name;
    protected double price;
    private String author;
    public NovelBook(String name,int price,String author){
        this.name = name;
        this.price = price;
        this.author = author;
    }
    @Override
    public String getName() {
        return name;
    }
    public double getPrice(){
        return this.price;
    }
    @Override
    public String getAuthor() {
        return this.author;
    }
}
