package cn.zs.basic.generic;

import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String args[]) throws Exception {
        Object o = genericMethod(Class.forName("cn.zs.basic.generic.Test"));
        System.out.println(o.getClass());
        //  test2();
    }
    public static void test1(){
        /*************************标记泛型 还是一个类对象********************************************/
        List<String> stringArrayList = new ArrayList<>();
        List<Integer> integerArrayList = new ArrayList<Integer>();

        Class classStringArrayList = stringArrayList.getClass();
        Class classIntegerArrayList = integerArrayList.getClass();
        if(classStringArrayList.equals(classIntegerArrayList)){
            System.out.println("asd 1");
        }
        Integer integer = 1;
        Class<? extends Integer> integerClass = integer.getClass();
        System.out.println(integerClass+" 2");
        //System.out.println(integerClass.getClassLoader());
        //每加载一个类  都会产生一个类对象
        Class<? extends Class> classClass = classIntegerArrayList.getClass();
        System.out.println(classClass);
        //System.out.println(classClass.getClassLoader());

        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer> genericInteger = new Generic<>(123456);
        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<>("key_vlaue");
        System.out.println(genericInteger.getKey()+" 3");
        System.out.println(genericString.getKey()+" 4");

        Generic generic = new Generic("111111");
//        Generic generic1 = new Generic(4444);
//        Generic generic2 = new Generic(55.55);
//        Generic generic3 = new Generic(false);
        Object key = generic.getKey();
        System.out.println(key.getClass()+" 5");
        System.out.println(key+" 6");
        System.out.println((key instanceof Object )+ " 7");
        System.out.println((key instanceof String )+ " 8");
        System.out.println((" " instanceof String)+ " 9");

    }
    public static void test2(){
        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> gNumber = new Generic<Number>(456);
        Generic<Object> gObject = new Generic<>(new Object());
        showKeyValue2(gInteger);
       showKeyValue3(gNumber);
    }
    //问号是通配符  泛型如果没有手动写继承关系 就算是 本身存在继承关系也不行
    public static void showKeyValue(Generic<Object> obj){
        System.out.println("key value is " + obj.getKey());
    }
    //用通配符就可以
    public static void showKeyValue1(Generic<?> obj){
        System.out.println("key value is " + obj.getKey());
    }
    //规定了泛型的上界
    public static void showKeyValue2(Generic<? extends Number> obj){
        System.out.println("key value is " + obj.getKey());
    }
    //规定了泛型的下界
    public static void showKeyValue3(Generic<? super Number> obj){
        System.out.println("key value is " + obj.getKey());
    }
    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public static  <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }


    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
    //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

    public static void test3(){
//        List<String>[] ls = new ArrayList<String>[10];
        List<?>[] ls = new ArrayList<?>[10];
        List<String>[] ls1 = new ArrayList[10];

        String res = new String();
        String [] ress = new String[1];
    }
}
