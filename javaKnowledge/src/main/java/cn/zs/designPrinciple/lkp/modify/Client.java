package cn.zs.designPrinciple.lkp.modify;
/*
*   迪米特原则
*   1.只与朋友类交流
*   2. 迪米特原则要求类“羞涩”一点，尽量不要对外公开太多的public方法和非静态的public变量，
*   尽量内敛，多使用private,package-private,protected等访问权限。 降低耦合
*
* */
import cn.zs.designPrinciple.lkp.unproper.Girl;

import java.util.ArrayList;
import java.util.List;

public class Client{
    public static void main(String [] args){
        //产生女生群体
        List<Girl> listGirls = new ArrayList<>();
        //初始化女生
        for(int i=0;i<20;i++){
            listGirls.add(new Girl());
        }
        Teacher teacher = new Teacher();
        //老师给体育委员发清点女生人数的命令
        teacher.command(new GroupLeader(listGirls));
    }
}