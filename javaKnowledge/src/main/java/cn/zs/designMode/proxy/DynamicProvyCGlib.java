package cn.zs.designMode.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
/*      被代理对象不需要继承父类或实现接口
        相比于 静态代理
 *      动态代理 对所有方法都可以一块增强
* */
public class DynamicProvyCGlib {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Student.class);
        enhancer.setCallback(new ProxyCGlibIntercept());
        Student student = (Student) enhancer.create();
        student.giveMoney();
        student.work();
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
