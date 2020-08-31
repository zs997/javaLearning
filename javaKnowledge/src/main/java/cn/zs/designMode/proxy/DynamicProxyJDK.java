package cn.zs.designMode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**     相比于 静态代理
 *      动态代理 对接口的所有方法都可以一块增强
 *
 *      被代理的对象 需要继承接口
 *      使用工具类产生代理对象 传入接口的类加载器，增强器
 *      增强器对接口的方法进行增强
 *       对接口的所有方法都可以一块增强
 *
 *
 */

public class DynamicProxyJDK {
    public static void main(String[] args) {
        Person p1 = new Student("zs");
        Person p2 = new Teacher("syd");
        Person p3 =   (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),
              new Class<?>[]{Person.class}, new MonitorProxyJDKHandler<Person>(p1));
      p3.giveMoney();
      p3.work();
        Person p4 = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),
                new Class<?>[]{Person.class}, new MonitorProxyJDKHandler<Person>(p2));
       p4.giveMoney();
    }
}
class MonitorProxyJDKHandler<T> implements InvocationHandler {
    T target;
    public MonitorProxyJDKHandler(T target){
        this.target = target;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //对接口的方法 都会进行增强
        System.out.println("使用动态代理，执行："+method.getName()+" 方法");
        Object result = method.invoke(target,args);
        System.out.println("使用动态代理，执行："+method.getName()+" 方法完毕");
        return result;
    }
}