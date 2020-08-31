package cn.zs.designPrinciple.lkp.unproper;

import java.util.ArrayList;
import java.util.List;
//  只与朋友类交流 GroupLeader是Teacher的朋友  但是girl不是 破坏了狄米特原则
public class Teacher{
    //老师对体育委员发一个命令，让其清点女生人数
    public void command(GroupLeader groupLeader){
        List<Girl> listGirls = new ArrayList<>();
        //初始化女生
        for(int i=0;i<20;i++){
            listGirls.add(new Girl());
        }
        //告诉体育委员开始清点女生人数
        groupLeader.countGirls(listGirls);
    }
}