package cn.zs.basic.reflect.detail.reflectAndGenerics;
import cn.zs.basic.reflect.detail.Person;
public class Test {
    public void testAnnotation() throws Exception{
        PersonDAO personDAO = new PersonDAO();
        Person entity = new Person();
        //调用父类的save方法，同时也把Person这个“实参”传给了父类的T
        personDAO.save(entity);
        //这句的本意是要返回一个Person类型的对象
        Person result = personDAO.get(1);
        System.out.print(result);
    }
}
