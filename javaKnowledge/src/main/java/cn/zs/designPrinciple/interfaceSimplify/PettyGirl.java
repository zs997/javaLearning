package cn.zs.designPrinciple.interfaceSimplify;

public class PettyGirl implements IPettyGirl{

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