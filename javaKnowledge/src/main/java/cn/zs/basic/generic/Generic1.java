package cn.zs.basic.generic;

public class Generic1<T extends Number> {
    private T key;
    public Generic1(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}
