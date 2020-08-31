package cn.zs.designMode.single;
/**
 *  双重校验 单例模式
 *
 */

public class SingleLazyConcurrent {
    private SingleLazyConcurrent(){}
    private static volatile SingleLazyConcurrent singleLazyConcurrent = null;
    public static SingleLazyConcurrent getInstance(){
        if (singleLazyConcurrent == null){
            synchronized (SingleLazyConcurrent.class){
                if (singleLazyConcurrent == null){
                    singleLazyConcurrent = new SingleLazyConcurrent();
                }
            }
        }
        return singleLazyConcurrent;
    }
}
