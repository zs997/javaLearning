package cn.zs.basic.proxy;

public class StaticProxy {
    public static void main(String[] args) {
        Student student = new Student("张三");
       // student.giveMoney();
        Teacher teacher = new Teacher("刘安峰");
        MonitorProxy monitorProxy = new MonitorProxy(student);
        monitorProxy.giveMoney();
        monitorProxy.setPs(teacher);
        monitorProxy.giveMoney();
    }
}
class Teacher implements Person{
    String name;
    Teacher(){}
    Teacher(String name){
        this.name = name;
    }
    @Override
    public void giveMoney() {
        System.out.println(name+"交了100班费");
    }

    @Override
    public void work() {

    }
}
class Student implements Person{

    @Override
    public void giveMoney() {
        System.out.println(name+" 交了50班费");
    }

    @Override
    public void work() {

    }

    String name;
    Student(){}
    Student(String name){
        this.name = name;
    }
}
class MonitorProxy implements Person{
    public void setPs(Person ps) {
        this.ps = ps;
    }

    Person ps = null;
    MonitorProxy(){}
    MonitorProxy(Person ps){
            this.ps = ps;
    }
    @Override
    public void giveMoney() {
        if (ps != null){
            if (ps.getClass() == Student.class){
                System.out.println("学生通过代理缴费了");
            }else if(ps.getClass() == Teacher.class){
                System.out.println("教师通过代理缴费了");
            }
            ps.giveMoney();
        }
    }

    @Override
    public void work() {

    }
}