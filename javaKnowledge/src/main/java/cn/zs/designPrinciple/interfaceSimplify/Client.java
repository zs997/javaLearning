package cn.zs.designPrinciple.interfaceSimplify;

public class Client{
    public static void main(String[] args){
        //定义一个美女
        IPettyGirl xiaoHong = new PettyGirl("小红");
        AbstractSearcher searcher = new Searcher(xiaoHong );
        searcher.show();
    }

}