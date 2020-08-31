package cn.zs.designPrinciple.interfaceSimplify;
/*       接口细化原则
*       然而，随着时代变化，人们的审美观点都在变化，美女的定义也在变化。人们也会把面容一般，身材一般，
*       但是脾气特别好的女孩定义为美女，如气质美女。但是，我们定义的美女接口中规定是美女要具备三个条件，
*       气质美女不是我们定义的美女。这个问题怎么办呢？这是因此接口IPettyGirl设计有缺陷，它过于庞大，
*       容纳了一些可变的因素，根据接口隔离原则，也就是接口应该尽量细化。我们把接口IPettyGirl拆分为二个接口，
*       一个是外形美的美女IGoodBodyGirl，另一个是气质美的美女IGoodTemperamentGirl。
*       这样，我们把一个比较臃肿的接口拆分为二个专门的接口，灵活性提高了，可维护性也增加了。
* */
public abstract class AbstractSearcher{
    protected IPettyGirl pettyGirl;
    public AbstractSearcher(IPettyGirl pettyGirl){
        this.pettyGirl=pettyGirl;
    }
    //显示美女信息
    public abstract void show();
}