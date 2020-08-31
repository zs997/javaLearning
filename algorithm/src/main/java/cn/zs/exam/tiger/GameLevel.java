package cn.zs.exam.tiger;

/*
*    initLevel 初始级别
*    x 完成x个任务数
*    tasks[i][0] 任务i所需要的级别
*    tasks[i][1] 任务i对级别的提升
*    求做完任务最大的级别*
* */
public class GameLevel {
    public static void main(String[] args) {

        int x = 2;
        int initLevel = 1;
        int [][] tasks = {{0,1},{1,2},{1,3}};

        System.out.println(maxlevel(x,initLevel,tasks));
    }

    public static int maxlevel(int x,int level,int [][]tasks){
        int n = tasks.length;
        boolean finished [] = new boolean[n];
        while (x>0){
            int maxProve = 0;
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (!finished[i] && tasks[i][0] <= level && tasks[i][1] > maxProve){
                    maxProve = tasks[i][1];
                    index = i;
                }
            }
            finished[index] = true;
            level+= maxProve;
            x--;
        }
        return level;
    }

}
