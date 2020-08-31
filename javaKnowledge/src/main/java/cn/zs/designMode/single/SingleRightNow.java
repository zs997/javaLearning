package cn.zs.designMode.single;
/*
*   单例模式 立即加载
* */
public class SingleRightNow {
    private static SingleRightNow single1 = new SingleRightNow();
    private SingleRightNow(){}
    public static SingleRightNow getInstance(){
        return single1;
    }
}
