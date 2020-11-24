package cn.zs.basic.classloader;
import java.io.InputStream;
import java.util.ArrayList;

import java.util.LinkedList;


public class ClassLoaderTest {
    public static void main(String[] args) throws Exception {

    }
    public static void test1() throws Exception {
        ClassLoader classLoader =  new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String filename = name.substring(name.lastIndexOf(".")+1)+".class";
                    //  System.out.println("文件路径："+filename);
                    InputStream resourceAsStream = getClass().getResourceAsStream(filename);
                    if(resourceAsStream == null){
                        return super.loadClass(name);
                    }
                    byte b [] = new byte[resourceAsStream.available()];
                    resourceAsStream.read(b);
                    // ClassLoader.getClassLoader();
                    return defineClass(name,b,0,b.length);

                }catch (Exception e){

                }
                return super.loadClass(name);
            }
        };
        /***********************************使用自定义加载器 加载类 查看加载器*****************************************/
        //加载器 是一个匿名内部类 ClassLoaderTest$1
        System.out.println(classLoader+" 1");
        //加载器加载一个类 返回一个Class对象 newInstance返回示例对象
        Class aclass = classLoader.loadClass("cn.zs.basic.classloader.ClassLoaderTest");
        Object obj = aclass.newInstance();
        System.out.println(aclass.getClassLoader()+" 2");
        System.out.println(obj.getClass().getClassLoader()+" 3");
        /**************************************************************************************************************/
        //自定义加载器加载Test类
        Class<?> testClass1 = classLoader.loadClass("cn.zs.basic.classloader.Test");
        System.out.println(testClass1.hashCode()+" 4");
        //使用默认的系统类加载器加载 没有向上委托
        Test test = new Test();
        Class<? extends Test> testClass2 = test.getClass();
        System.out.println(testClass2.hashCode()+" 5");

        //  Object testClassInstance = testClass1.newInstance();
        //会出错 不同类加载器加载的Test  产生的示例不可以相互转化
        // test = (Test) testClassInstance;

        /****************************************不同加载器加载系统类**********************************************************/
        //  先默认加载，后自定义加载
        //加载自定义类加载器的加载器  系统类（应用类）加载器
        System.out.println(classLoader.getClass().getClassLoader()+" 6");
        //String 类型由启动类加载器 加载
        ArrayList<String> s = new ArrayList<>();
        System.out.println(s.getClass().getClassLoader()+" 7");
        //使用自定义类加载器，加载系统的类  会向上委托 看看父类加载器是否加载过 加载过 就不加载了
        //否则从上向下 看是否可以加载 可以就加载了 保护核心类
        //因为不同加载器 加载同一类 类对象不一样
        Class<?> aClass = classLoader.loadClass("java.util.ArrayList");
        Object o = aClass.newInstance();
        System.out.println(o+" 8");
        System.out.println(o.getClass()+" 9");
        System.out.println(o.getClass().getClassLoader()+" 10");

        /*******************************************************************************************************/
        // 先自定义加载 后默认加载 其实也是向上委托了  不会用自定义加载器加载
        Class<?> linkedClass1 = classLoader.loadClass("java.util.LinkedList");
        Object linkedlist1 = linkedClass1.newInstance();
        System.out.println(linkedlist1.getClass()+" "+linkedlist1.getClass().getClassLoader()+" 11");
        LinkedList<String> linkedList2 = new LinkedList<>();
        System.out.println(linkedList2.getClass()+" "+linkedList2.getClass().getClassLoader()+" 12");

        /************************HashMap 自定义一个Hashmap 使用自定义类加载器加载 ***********************************/
        // 自定义一个HashMap，使用自定义类加载器加载，实际上委托到顶层 由顶层加载类 但加载的是系统的HashMap
        //如果将自定义的类 放入系统包中 才可能加载进去 但会报错

        Class<?> hashMapClass1 = classLoader.loadClass("java.util.HashMap");
        System.out.println(hashMapClass1.getClassLoader()+" 13");
        //    new cn.zs.basic.classloader.HashMap();
        //java.lang.Object
    }
    public static void test2() throws Exception {
        ClassLoader classLoader =  new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String filename = name.substring(name.lastIndexOf(".")+1)+".class";
                    //  System.out.println("文件路径："+filename);
                    InputStream resourceAsStream = getClass().getResourceAsStream(filename);
                    if(resourceAsStream == null){
                        return super.loadClass(name);
                    }
                    byte b [] = new byte[resourceAsStream.available()];
                    resourceAsStream.read(b);
                    // ClassLoader.getClassLoader();
                    return defineClass(name,b,0,b.length);

                }catch (Exception e){

                }
                return super.loadClass(name);
            }
        };
        Class<?> objectClass = classLoader.loadClass("java.lang.Object");
        System.out.println(objectClass.getClassLoader()+" 14");
    }
}
