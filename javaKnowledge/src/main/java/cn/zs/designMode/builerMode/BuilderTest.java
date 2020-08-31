package cn.zs.designMode.builerMode;

public class BuilderTest {
    public static void main(String[] args){
        Director director = new Director();
        Robot robot = director.createRobotByDirecotr(new DanceRobotBuilder ());
        System.out.println(robot.getHead());
        System.out.println(robot.getBody());
        System.out.println(robot.getHand());
        System.out.println(robot.getFoot());
        System.out.println("机器人创建成功，恭喜！");
    }
}