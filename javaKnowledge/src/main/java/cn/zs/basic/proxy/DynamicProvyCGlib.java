package cn.zs.basic.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.SQLOutput;

public class DynamicProvyCGlib {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(new ProxyCGlibIntercept());
        Student student = (Student) enhancer.create();
        student.giveMoney();
    }
}
class ProxyCGlibIntercept implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强方法 "+method.getName());
        Object o1 = methodProxy.invokeSuper(o, args);
        System.out.println("增强完毕 "+method.getName());
        return o1;
    }
}
