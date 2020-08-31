package cn.zs.designMode.single;

public class Test {
    public static void main(String args[]){
//        SingleRightNow single1 = SingleRightNow.getSingle();
//        SingleRightNow single12 = SingleRightNow.getSingle();
        SingleLazyConcurrent instance = SingleLazyConcurrent.getInstance();
        SingleLazyConcurrent instance1 = SingleLazyConcurrent.getInstance();


        System.out.println(instance ==instance1);
    }
}
