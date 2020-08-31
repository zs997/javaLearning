package cn.zs.basic.reflect.detail;
import cn.zs.basic.reflect.ClassObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ReflectionTest {
    public static void main(String args[]) throws Exception {
        new ReflectionTest().testField();
    }
    public static void ex1() throws ClassNotFoundException {
        Class clazz = null;
        //1.通过类名
        clazz = Person.class;

        //2.通过对象名
        //这种方式是用在传进来一个对象，却不知道对象类型的时候使用
        Person person = new Person();
        clazz = person.getClass();
        //上面这个例子的意义不大，因为已经知道person类型是Person类，再这样写就没有必要了
        //如果传进来是一个Object类，这种做法就是应该的
        Object obj = new Person();
        clazz = obj.getClass();

        //3.通过全类名(会抛出异常)
        //一般框架开发中这种用的比较多，因为配置文件中一般配的都是全类名，通过这种方式可以得到Class实例
        String className="cn.zs.basic.reflect.detail.Person";
        clazz = Class.forName(className);

        //字符串的例子
        clazz = String.class;
        clazz = "javaTest".getClass();
        clazz = Class.forName("java.lang.String");
        System.out.println();
        //2.返回字段的数组
        Field[] fields = clazz.getDeclaredFields();
    }
    public static void ex2() throws Exception {
        Class clazz = Class.forName("cn.zs.basic.reflect.detail.Person");
        //1.获取方法
        //  1.1 获取取clazz对应类中的所有方法--方法数组（一）
        //     不能获取private方法,且获取从父类继承来的所有方法
        Method[] methods = clazz.getMethods();
        for(Method method:methods){
            System.out.print(" "+method.getName());
        }
        System.out.println();
        //  1.2.获取所有方法，包括私有方法 --方法数组（二）
        //  所有声明的方法，都可以获取到，且只获取当前类的方法
        methods = clazz.getDeclaredMethods();
        for(Method method:methods){
            System.out.print(" "+method.getName());
        }
        System.out.println();
        //  1.3.获取指定的方法
        //  需要参数名称和参数列表，无参则不需要写
        //  对于方法public void setName(String name) {  }
        Method method = clazz.getDeclaredMethod("setName", String.class);
        System.out.println(method);
        //  而对于方法public void setAge(int age) {  }
        method = clazz.getDeclaredMethod("setAge", Integer.class);
        System.out.println(method);
        //  这样写是获取不到的，如果方法的参数类型是int型
        //  如果方法用于反射，那么要么int类型写成Integer： public void setAge(Integer age) {  }
        //  要么获取方法的参数写成int.class
        //2.执行方法
        //  invoke第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数
        Object obje = clazz.newInstance();
        method.invoke(obje,2);
         //如果一个方法是私有方法，第三步是可以获取到的，但是这一步却不能执行
        //私有方法的执行，必须在调用invoke之前加上一句method.setAccessible（true）;
    }
    /**@param obj: 方法执行的那个对象.
     * @param methodName: 类的一个方法的方法名. 该方法也可能是私有方法.
     * @param args: 调用该方法需要传入的参数
     * @return: 调用方法后的返回值
     * 执行obj的 methodName方法 带有args参数
     *          使用方法
     *          Object obj = new Person();
     *         invoke(obj, "test", "wang", 1);
     */
    public static Object invoke(Object obj,String methodName, Object ... args) throws Exception{
        //1. 获取 Method 对象
        //   因为getMethod的参数为Class列表类型，所以要把参数args转化为对应的Class类型。

        Class [] parameterTypes = new Class[args.length];
        for(int i = 0; i < args.length; i++){
            parameterTypes[i] = args[i].getClass();
            System.out.println(parameterTypes[i]);
        }

        Method method = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
        //如果使用getDeclaredMethod，就不能获取父类方法，如果使用getMethod，就不能获取私有方法　　　　　　　　　//　　　　　//2. 执行 Method 方法
        //3. 返回方法的返回值
        return method.invoke(obj, args);
    }

    /*  这种反射实现的主要功能是可配置和低耦合。
    *   只需要类名和方法名，而不需要一个类对象就可以执行一个方法。
    *   如果我们把全类名和方法名放在一个配置文件中，就可以根据调用配置文件来执行方法
    *
    *   执行className类的methodName，带有args参数
    * */
    public static Object invoke(String className, String methodName, Object ... args){
        Object obj = null;

        try {
            obj = Class.forName(className).newInstance();
            //调用上一个方法
            return invoke(obj, methodName, args);
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void ex3() throws Exception{
        String className = "cn.zs.basic.reflect.detail.Student";
        Class clazz = Class.forName(className);
        Class superClazz = clazz.getSuperclass();
        System.out.println(superClazz);
    }
    /***********************************************************************************************************************************/
    /**
     * @param obj: 某个类的一个对象
     * @param methodName: 类的一个方法的方法名.
     * 该方法也可能是私有方法, 还可能是该方法在父类中定义的(私有)方法
     * @param args: 调用该方法需要传入的参数
     * @return: 调用方法后的返回值
     */
    public  Object invoke2(Object obj, String methodName,
                          Object ... args){
        //1. 获取 Method 对象
        Class [] parameterTypes = new Class[args.length];
        for(int i = 0; i < args.length; i++){
            parameterTypes[i] = args[i].getClass();
        }
        try {
            Method method = getMethod(obj.getClass(), methodName, parameterTypes);
            method.setAccessible(true);
            //2. 执行 Method 方法
            //3. 返回方法的返回值
            return method.invoke(obj, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取 clazz 的 methodName 方法. 该方法可能是私有方法, 还可能在父类中(私有方法)
     * 如果在该类中找不到此方法，就向他的父类找，一直到Object类为止
     　　　* 这个方法的另一个作用是根据一个类名，一个方法名，追踪到并获得此方法
     * @param clazz
     * @param methodName
     * @param parameterTypes
     * @return
     */
    public Method getMethod(Class clazz, String methodName,
                            Class ... parameterTypes){
        for(;clazz != Object.class; clazz = clazz.getSuperclass()){
            try {
                //如果没有方法 就进入catch 不return
                Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
                return method;
            } catch (Exception e) {}
        }
        return null;
    }
    /*******************************************************************************************************************************************/
    public void testField() throws Exception{
        String className = "cn.zs.basic.reflect.detail.Person";
        Class clazz = Class.forName(className);
        //1.获取字段
        //  1.1 获取所有字段 -- 字段数组
        //     可以获取公用和私有的所有字段，但不能获取父类字段
        Field[] fields = clazz.getDeclaredFields();
        for(Field field: fields){
            System.out.print(" "+ field.getName());
        }
        System.out.println();

        //  1.2获取指定字段
        Field field = clazz.getDeclaredField("name");
        System.out.println(field.getName());

        Person person = new Person("ABC",12);

        //2.使用字段
        //  2.1获取指定对象的指定字段的值
        Object val = field.get(person);
        System.out.println(val);

        //  2.2设置指定对象的指定对象Field值
        field.set(person, "DEF");
        System.out.println(person.getName());

        //  2.3如果字段是私有的，不管是读值还是写值，都必须先调用setAccessible（true）方法
        //     比如Person类中，字段name字段是公用的，age是私有的
        field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        System.out.println(field.get(person));
    }

    public void testConstructor() throws Exception{
        String className = "cn.zs.basic.reflect.detail.Person";
        Class<Person> clazz = (Class<Person>) Class.forName(className);
        //1. 获取 Constructor 对象
        //   1.1 获取全部
        Constructor<Person> [] constructors =
                (Constructor<Person>[]) Class.forName(className).getConstructors();
        for(Constructor<Person> constructor: constructors){
            System.out.println(constructor);
        }

        //  1.2获取某一个，需要参数列表
        Constructor<Person> constructor = clazz.getConstructor(String.class, int.class);
        System.out.println(constructor);

        //2. 调用构造器的 newInstance() 方法创建对象
        Object obj = constructor.newInstance("zhagn", 1);
    }

    /** Annotation 和 反射:
     * 1. 获取 Annotation
     *  必须通过反射的方式为属性赋值，才能获取到注解
     * getAnnotation(Class<T> annotationClass)
     * getDeclaredAnnotations()
     *  一些经过注解进行约束的量 可以通过反射规范约束
     */
    public void testAnnotation() throws Exception{
        String className = "com.atguigu.java.fanshe.Person";

        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();

        Method method = clazz.getDeclaredMethod("setAge", int.class);
        int val = 6;

        //获取指定名称的注解
        Annotation annotation = method.getAnnotation(AgeValidator.class);
        if(annotation != null){
            if(annotation instanceof AgeValidator){
                AgeValidator ageValidator = (AgeValidator) annotation;
                if(val < ageValidator.min() || val > ageValidator.max()){
                    throw new RuntimeException("年龄非法");
                }
            }
        }
        method.invoke(obj, 20);
        System.out.println(obj);
    }

    //类加载器使用 加载字节流

    public static void classLoaderTest() throws ClassNotFoundException, IOException {
        //1. 获取一个系统的类加载器(可以获取，当前这个类PeflectTest就是它加载的)
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

        //2. 获取系统类加载器的父类加载器（扩展类加载器，可以获取）.
        classLoader = classLoader.getParent();
        System.out.println(classLoader);

        //3. 获取扩展类加载器的父类加载器（引导类加载器，不可获取）.
        classLoader = classLoader.getParent();
        System.out.println(classLoader);

        //4. 测试当前类由哪个类加载器进行加载（系统类加载器）:
        //一般来讲 自定义的类 都是 系统类加载器加载
        classLoader = Class.forName("cn.zs.basic.reflect.ClassObject")
                .getClassLoader();
        System.out.println(classLoader);

        //5. 测试 JDK 提供的 Object 类由哪个类加载器负责加载（引导类）
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

        //放在内部文件夹，要写全路径  不对劲 知道就行
        InputStream in2 = null;
        in2 = ClassObject.class.getClassLoader().getResourceAsStream("D:\\works\\java\\javaKnowledge\\src\\main\\resources\\a.txt");
        byte [] bytes =  new byte[10];
        int read = in2.read(bytes);
        System.out.println(read);
        for (byte aByte : bytes) {
            System.out.println(aByte);
        }

    }
}
