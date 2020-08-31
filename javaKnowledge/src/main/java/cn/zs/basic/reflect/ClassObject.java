package cn.zs.basic.reflect;

import cn.zs.basic.reflect.detail.Father;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

//类对象是一种类的实例
//每个类及其对象的类对象都是一个
public class ClassObject extends Father {
    int a ;
    int b;
    int age;
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }
    private String name;

    public void setAge(int age) {
        this.age = age;
        System.out.println("asdasdf");
    }
    private void welcome(String tips){
        System.out.println(tips);
    }
    public ClassObject(){}
    public ClassObject(int a){
        this.a = a;
    }
    private ClassObject(int a,int b){
        this.a =a;
        this.b =b;
    }
    public static void ss(){}
    //反射基础
    public static void basicReflect() throws Exception {

        //产生的类对象 生成的实例一定是 ClassObject 类型 泛型
        Class<ClassObject> classObject1 = ClassObject.class;

        //产生的类对象 生成的实例一定是 ClassObject demo 或者是其子类
        //父类引用 demo 指向子类，获取类对象肯定是 父类,产生的实例,只能用父类引用接受 但是可以强转
        Father demo = new ClassObject();
        Class<? extends Father> classObject2 = demo.getClass();
        Father father = classObject2.newInstance();
        System.out.println(father);
        ClassObject instance1 = (ClassObject) father;
        System.out.println(instance1);

        //以下两种情况会产生类对象 但生成的实例 都是object
        Object o = new ClassObject();
        Class<?> classObject3 = o.getClass();
        Class<?> classObject4 = Class.forName("cn.zs.basic.reflect.ClassObject");

        System.out.println(classObject1);
        System.out.println(classObject2);
        System.out.println(classObject3);
        System.out.println(classObject4);
        System.out.println(classObject1 == classObject2);
        System.out.println(classObject1 == classObject3);
        System.out.println(classObject1 == classObject4);

        //获取定义的字段
        Field[] declaredFields = classObject1.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //1.获取方法
        //  1.1 获取取clazz对应类中的所有方法--方法数组（一）
        //     不能获取private方法,且获取从父类继承来的所有方法
        Method[] methods = classObject1.getMethods();
        for(Method method:methods){
            System.out.print(" "+method.getName());
        }
        System.out.println();


        //  1.2.获取所有方法，包括私有方法 --方法数组（二）
        //  所有声明的方法，都可以获取到，且只获取当前类的方法
        methods = classObject1.getDeclaredMethods();
        for(Method method:methods){
            System.out.print(" "+method.getName());
        }
        System.out.println();

        //  1.3.获取指定的方法
        //  需要参数名称和参数列表，无参则不需要写
        //  对于方法public void setName(String name) {  }
        Method method = classObject1.getDeclaredMethod("setName", String.class);
        System.out.println(method);

        //  而对于方法public void setAge(int age) {  }
       // method = classObject1.getDeclaredMethod("setAge", Integer.class);
       method = classObject1.getDeclaredMethod("setAge", int.class);
        System.out.println(method);
        //  这样写是获取不到的，如果方法的参数类型是int型
        //  如果方法用于反射，那么要么int类型写成Integer： public void setAge(Integer age) {  }
     //  要么获取方法的参数写成int.class
        //
        //2.执行方法
        //  invoke第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数

        method.invoke(instance1,2);

        //如果一个方法是私有方法，第三步是可以获取到的，但是这一步却不能执行
        //私有方法的执行，必须在调用invoke之前加上一句method.setAccessible（true）;

        //获取所有的构造函数
        Constructor<?>[] constructors = classObject4.getConstructors();
        for(int i=0;i<constructors.length;i++){
//            System.out.print(Modifier.toString(constructors[i].getModifiers())+"参数：");
//             Class[] parametertypes= constructors[i].getParameterTypes();
//               for(int j=0;j<parametertypes.length;j++){
//               System.out.print(parametertypes[j].getName()+" ");
//               }
//               System.out.println("");
            System.out.println(constructors[i]);
        }

        //获取无参构造函数
        try {
            Constructor<?> declaredConstructor = classObject4.getDeclaredConstructor();
                //获取权限
                System.out.println(Modifier.toString(declaredConstructor.getModifiers()));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //获取指定构造函数
        Class[] p = {int.class,int.class};
        try {
            Constructor<?> declaredConstructor = classObject4.getDeclaredConstructor(p);
            System.out.print(Modifier.toString(declaredConstructor.getModifiers()) + "参数:");
            Class[] parametertypes = declaredConstructor.getParameterTypes();
            for (int j = 0; j < parametertypes.length; j++) {
                System.out.print(parametertypes[j].getName() + " ");
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //产生新实例
        Constructor<?> declaredConstructor = classObject4.getDeclaredConstructor(p);
        declaredConstructor.setAccessible(true);
        ClassObject instance = (ClassObject) declaredConstructor.newInstance(1, 2);
        System.out.println(instance.a);

        //调用类的私有方法
        Class[] p4 = {String.class};
         method = classObject4.getDeclaredMethod("welcome",p4);
        method.setAccessible(true);
        Object arg1s[] = {"欢迎关注代码男人技术公众号"};
        method.invoke(instance,arg1s);

        //获取类的私有字段并修改值
        Field field = classObject4.getDeclaredField("name");
        field.setAccessible(true);
        field.set(instance,"代码男人");
        System.out.println(instance.getName());
    }

    public static void main(String args[]) throws Exception {
        basicReflect();
    }
}
