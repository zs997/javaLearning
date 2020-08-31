package cn.zs.designPrinciple.lkp.unproper;

public class Client{
    public static void main(String [] args){
        Teacher teacher = new Teacher();
        //老师给体育委员发清点女生人数的命令
        teacher.command(new GroupLeader());
    }
}
