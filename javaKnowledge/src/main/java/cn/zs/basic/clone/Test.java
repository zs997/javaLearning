package cn.zs.basic.clone;

public class Test {
    public static void main(String args[]) throws CloneNotSupportedException {
        Person p1 = new Person("zhangsan",21);
        p1.setAddress("湖北省", "武汉市");
        Person p2 = (Person) p1.clone();
        //复制出了p2
        System.out.println("p1:"+p1);
        System.out.println("p2:"+p2);
        System.out.println("p1.getPname:"+p1.getPname().hashCode());
       //p2的字符串成员 浅拷贝了
        System.out.println("p2.getPname:"+p2.getPname().hashCode());
        //adress 自定义类型 也进行了 浅拷贝
        System.out.println("p1.address:" + p1.address.hashCode());
        System.out.println("p2.adress:" + p2.address.hashCode());
    }
}
