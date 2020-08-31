package cn.zs.designPrinciple.interfaceSimplify.improve;

public class PettyGirl implements IGoodBodyGirl, IGoodTemperamentGirl{

    private String name;

    public PettyGirl(String name){
        this.name = name;
    }

    public void goodLooking(){
        System.out.println(name + "---有好的面孔");
    }

    public void niceFigure(){
        System.out.println(name + "---有好身材");
    }

    public void goodTemperament(){
        System.out.println(name + "---有好气质");
    }
}