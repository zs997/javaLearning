package cn.zs.designPrinciple.lkp.modify;

public class Teacher{
    //老师对体育委员发一个命令，让其清点女生人数
    public void command(GroupLeader groupLeader){
        //告诉体育委员开始清点女生人数
        groupLeader.countGirls();
    }
}