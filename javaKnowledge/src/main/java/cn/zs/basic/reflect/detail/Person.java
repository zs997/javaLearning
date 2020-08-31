package cn.zs.basic.reflect.detail;

public class Person {
    String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    @AgeValidator(min=18,max=35)
    public void setAge(int age) {
        this.age = age;
    }
    //包含一个带参的构造器和一个不带参的构造器
    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    public Person() {
        super();
    }
    public void test(String name,Integer age){
        System.out.println("调用成功");
    }
}
