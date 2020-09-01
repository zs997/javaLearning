package cn.zs.basic.grammer;
public class Main {
    Main(Integer i){
        System.out.println("inteeg");
    }
    Main(Long i){
        System.out.println("long");
    }
    Main(Double i){
        System.out.println("d");
    }
    Main(Float i){}
    public static void main(String args[]){
        //1.
        new Main(100.0*100);

        //2.
        Integer a = Integer.valueOf(100);
        Integer b = Integer.valueOf("100");
        int c = 100;
        Integer d = Integer.valueOf(200);
        Integer e = Integer.valueOf(200);
        System.out.println(b==c);
        System.out.println(a==b);
        System.out.println(d.equals(e));
        System.out.println(d==e);

        //3.
        try{String s = "java开发";
            System.out.println(s.getBytes("UTF-8").length);
        }catch (Exception ff){}

        //4.
        Thread t = new Thread(){
            public void run(){
                pong();
            }
        };
        t.run();
        System.out.println("JO");
    }
    static void pong(){
        System.out.println("yy");
    }


}
