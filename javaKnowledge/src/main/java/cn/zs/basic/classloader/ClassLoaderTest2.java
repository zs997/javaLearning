package cn.zs.basic.classloader;

import java.io.InputStream;

public class ClassLoaderTest2 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try{
                    String filename = name.substring(name.lastIndexOf(".")+1)+".class";
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

  //      ClassLoaderTest classLoaderTest = new ClassLoaderTest();
     //   System.out.println(classLoader.getClass().getClassLoader());
      //  String s = "";
    //    System.out.println(s.getClass().getClassLoader());
//
        Class<?> aClass = classLoader.loadClass("java.lang.String");
        Object o = aClass.newInstance();
        System.out.println(o);
        System.out.println(o.getClass());
        System.out.println(o.getClass().getClassLoader());
    }
}
