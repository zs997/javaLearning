package cn.zs.designPrinciple.lkp.modify;

import cn.zs.designPrinciple.lkp.unproper.Girl;

import java.util.List;

public class GroupLeader{
    private List<Girl> listGirls;
    public GroupLeader(List<Girl> listGirls){
        this.listGirls = listGirls;
    }
    //清点女生数量
    public void countGirls(){
        System.out.println("女生人数是："+listGirls.size());
    }
}