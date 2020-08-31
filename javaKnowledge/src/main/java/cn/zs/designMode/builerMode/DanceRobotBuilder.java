package cn.zs.designMode.builerMode;

public class DanceRobotBuilder implements IBuildRobot {
    Robot robot;
    public DanceRobotBuilder(){
        robot = new Robot ();
    }
    @Override
    public void buildHead() {
        robot.setHead("写入机械舞程序");
    }
    @Override
    public void buildBody() {
        robot.setBody("钛合金身体");
    }
    @Override
    public void buildHand() {
        robot.setHand("钛合金手");
    }
    @Override
    public void buildFoot() {
        robot.setFoot("钛合金脚");
    }
    @Override
    public Robot createRobot () {
        return robot;
    }

}