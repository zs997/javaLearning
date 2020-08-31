package cn.zs.basic.innerClass;

class Circle {
    public static void main(String args[]){
        Erase erase = new Erase();
        int a = erase.a;
        //1 创建外部类之后 再创建内部类
        Circle circle = new Circle(1);
        Draw draw = circle.new Draw();
        //2使用外部类的方法
        Draw draw1 = circle.getDraw();

        //静态内部类可以这样创建
        Erase erase1 = new Circle.Erase();
        //不好使
      //  Erase erase2 = circle.new Erase();
    }
    private double radius = 0;
    public static int count =1;
    public Circle(double radius) {
        this.radius = radius;
    }
    public  Draw getDraw(){
       // Erase erase = new Erase();
        return new Draw();
    }
    //内部类可以任意访问外部的变量
    //内部类放在成员的位置 示例变量的位置 只能通过非静态方法 访问
    class Draw {     //内部类
        public void drawSahpe() {
            System.out.println(radius);  //外部类的private成员
            System.out.println(count);   //外部类的静态成员
        }
    }
    //内部类放在静态位置 内部类只能访问外部的静态
    //外部类访问内部类可以通过 静态方法或者实例方法创建对象
    static class Erase{
        int a = 0;
        public void ss(){
            System.out.println(count);
           // System.out.println(radius);
        }
    }
}