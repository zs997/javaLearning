package cn.zs.basic.innerClass;

public class Exam{
    public static void main(String[] args){
        // 初始化Bean1
        Bean1 bean1 = new Exam().new Bean1();
        bean1.I++;
        // 初始化Bean2
        Bean2 bean2 = new Bean2();
        bean2.J++;
        //初始化Bean3
        Bean.Bean3 bean3 = new Bean().new Bean3();
        bean3.k++;
        Outter1 outter = new Outter1();
        outter.new Inner().print();
    }
    class Bean1{
        public int I = 0;
    }

    static class Bean2{
        public int J = 0;
    }
}

class Bean{
    class Bean3{
        public int k = 0;
    }
}
class Outter1
{
    private int a = 1;
    class Inner {
        private int a = 2;
        public void print() {
            int a = 3;
            System.out.println("局部变量：" + a);
            System.out.println("内部类变量：" + this.a);
            System.out.println("外部类变量：" + Outter1.this.a);
        }
    }
}