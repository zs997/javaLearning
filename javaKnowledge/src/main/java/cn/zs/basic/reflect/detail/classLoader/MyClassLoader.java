package cn.zs.basic.reflect.detail.classLoader;

import java.io.InputStream;

public class MyClassLoader {

    public static void main(String[] args) throws Exception {
        //new 已经加载了 使用的吗，默认的加载器
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null)
                        return super.loadClass(name);
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (Exception e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
/********************************************************************************************************************************/
        //可以看出相同的类由不同的类加载器加载
        Object obj = myLoader.loadClass("cn.zs.basic.reflect.detail.classLoader.MyClassLoader").newInstance();
        System.out.println(obj.getClass().getClassLoader());//com.reflectandClassLoad.MyClassLoader$1@c17164
        System.out.println(MyClassLoader.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@19821f

        //可以看出两个类是否相等，条件是类本身和加载此类的加载器
        System.out.println(obj instanceof MyClassLoader);//false
/*******************************************************************************************************************************/
        //分别由系统类（应用类）加载器加载和使用自定义加载器 加载Test类 并产生实例
        Object obj1 = myLoader.loadClass("cn.zs.basic.reflect.detail.classLoader.Test").newInstance();
        Object obj2 = ClassLoader.getSystemClassLoader().loadClass("cn.zs.basic.reflect.detail.classLoader.Test").newInstance();
        System.out.println(obj1.getClass().hashCode());
        System.out.println(obj2.getClass().hashCode());
        System.out.println(obj1.getClass());
        System.out.println(obj2.getClass());
/*******************************************************************************************************************************/
    }
}