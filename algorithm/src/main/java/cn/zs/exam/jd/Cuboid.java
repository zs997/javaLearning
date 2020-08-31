package cn.zs.exam.jd;
/*
*
    1、给定6组平面的长宽，问能否组成长方体。
如：
输入：
1345 2584
2584 683
2584 1345
683 1345
683 1345
2584 683
每行表示每个长方形的长或宽
输出：POSSIBLE
表示可以组成
*
* */
import java.util.*;
public class Cuboid {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static boolean isPossible(ArrayList<Surface> data) {
        HashMap<Surface,Integer> pair =  new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            //获取第i个平面
            Surface surface = data.get(i);
            if(pair.containsKey(surface)){
                pair.put(surface,pair.get(surface)+1);
            }else {
                pair.put(surface,1);
            }
        }
        //六个面如果 有三种以上的平面  肯定不行
        if(pair.size() > 3)
        {
            return false;
        } else if(pair.size() == 1){
            //如果所有平面一样 那么平面的长宽要一样
            Set<Surface> surfaces = pair.keySet();
            for(Surface s:surfaces){
                if(s.w == s.h){
                    return true;
                }else {
                    return false;
                }
            }
        }else if(pair.size() == 2){
            //如果有两种尺寸的平面 只能是 (a,a) 2个面 (a,b) 四个面 才能拼成立方体
            Set<Surface> surfaces = pair.keySet();
            ArrayList<Surface> list = new ArrayList<>();
            for(Surface s :surfaces){
                if((pair.get(s) == 4)||(pair.get(s) == 2)){
                    if(pair.get(s) == 4){
                        list.add(s);
                        list.add(s);
                    }else {
                        list.add(s);
                    }
                }else{
                    //不合理
                    return false;
                }
            }
            return triPossible(list);

        }else  if(pair.size() == 3){
            //三种类型的平面  每个类型 要有两个 才有可能行
            Set<Surface> surfaces = pair.keySet();
            ArrayList<Surface> list = new ArrayList<>();
            for(Surface s :surfaces){
                if( pair.get(s)!= 2){
                    return false;
                }
                list.add(s);
            }
            return triPossible(list);
        }
        return false;
    }
    //判断三个平面能否匹配
    static boolean triPossible(ArrayList<Surface> data){
        if(data.size() != 3){return false;}
        //data 前提是长度3
        int h0 = data.get(0).h;
        int w0 = data.get(0).w;
        if(h0 ==data.get(1).h){
            Surface surface = new Surface(w0, data.get(1).w);
            return surface.equals(data.get(2));
        }else if(h0 == data.get(1).w){
            Surface surface = new Surface(w0, data.get(1).h);
            return surface.equals(data.get(2));
        }else if (h0 == data.get(2).h){
            Surface surface = new Surface(w0, data.get(2).w);
            return surface.equals(data.get(1));
        }else if(h0 == data.get(2).w){
            Surface surface = new Surface(w0, data.get(2).w);
            return surface.equals(data.get(1));
        }
        return  false;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
                /*
        * 2
        *
        1345 2584
        2584 683
        2584 1345
        683 1345
        683 1345
        2584 683
        POSSIBLE

        1234 4567
        1234 4567
        4567 4321
        4322 4567
        4321 1234
        4321 1234
        IMPOSSIBLE
        * */
        Scanner in = new Scanner(System.in);
        ArrayList<Surface> data = new ArrayList<>();
        for(int j = 0;j <6;j++){
            Surface temp = new Surface(in.nextInt(),in.nextInt());
            data.add(temp);
        }
        boolean possible = isPossible(data);
        System.out.println(possible?"POSSIBLE":"IMPOSSIPLE");
    }
}

class Surface{
    //h长 数大的
    int h;
    //w宽
    int w;

    Surface(int h,int w){
        if(h > w){
            this.h= h;
            this.w = w;
        }else {
            this.w= h;
            this.h = w;
        }

    }
    private  Surface(){}

    @Override
    public boolean equals(Object Surface)
    {
        if(this == Surface)
        {
            return true;
        }
        if(!(Surface instanceof Surface))
        {
            return false;
        }
        Surface pn = (Surface)Surface;
        return pn.w == w && pn.h == h;
    }

    @Override
    public int hashCode()
    {
        return w*h;
    }

}
