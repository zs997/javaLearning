package cn.zs.designMode.single;
/*
*   单例模式 延迟加载 不支持并发
* */
public class SingleLazy {
    private SingleLazy(){}
    private static SingleLazy single = null;
    public static SingleLazy getInstance(){
        if (single == null){
            single = new SingleLazy();
        }
        return single;
    }

}
