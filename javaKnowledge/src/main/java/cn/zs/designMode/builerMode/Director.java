package cn.zs.designMode.builerMode;
//依赖一个建造者  建造者把被建造的对象0值初始化 但是需要建造者有序初始化
public class Director {
    public Robot createRobotByDirecotr(IBuildRobot ibr){
        ibr.buildBody();
        ibr.buildFoot();
        ibr.buildHand();
        ibr.buildHead();
        return ibr.createRobot ();
    }
}