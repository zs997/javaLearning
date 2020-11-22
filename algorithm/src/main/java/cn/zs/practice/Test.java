package cn.zs.practice;

import java.util.ArrayList;

public class Test extends  Thread {
    String name;
    public static void main(String args[]){
      //Test test = new Test();
       // test.execute();
        //aa
        Character s = 's';
        System.out.println(s-1);
        ArrayList<String> aa = new ArrayList<>();
    }
    Test(){}
    Test(String name){
        this.name = name;
    }
    public String getThreadName(){
        return name;
    }
    public void execute(){
        Test one = new Test("one");
        one.start();
        Test two = new Test("two");
        two.start();
       // StringBuilder
    }
    public void start(){
        for (int i = 0; i < 2; i++) {
            System.out.println(this.getThreadName()+i);
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
