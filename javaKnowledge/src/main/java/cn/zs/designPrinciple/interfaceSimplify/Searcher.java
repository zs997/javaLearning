package cn.zs.designPrinciple.interfaceSimplify;

public class Searcher extends AbstractSearcher{
    public Searcher(IPettyGirl pettyGirl){
        super(pettyGirl);
    }
    //显示美女信息
    public void show(){
        System.out.println("----美女的信息如下：---");
        //显示好的面孔
        super.pettyGirl.goodLooking();
        //显示好身材
        super.pettyGirl.niceFigure();
        //显示好气质
        super.pettyGirl.goodTemperament();
    }
}