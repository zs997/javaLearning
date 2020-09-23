package cn.kh;
import java.util.*;
public class Main5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String[] ss = sc.nextLine().split("\\s+");
            int m = Integer.parseInt(ss[0]);
            int n = Integer.parseInt(ss[1]);
            LinkedList<Integer>[] queues = new LinkedList[n];
            boolean[] flags = new boolean[n];
            for (int i = 0 ; i < n ; i ++){
                queues[i] = new LinkedList();
                queues[i].add(i + 1);
                flags[i] = true;
            }
            for (int i = 0 ; i < m ; i ++){
                String action = sc.nextLine();
                String[] actions = action.split("\\s+");
                if (actions[0].equals("C")){
                    int a = Integer.parseInt(actions[1]) - 1;
                    int b = Integer.parseInt(actions[2]) - 1;
                    flags[a] = false;
                    for (Integer num : queues[a]) {
                        queues[b].add(num);
                    }
                }else{
                    boolean flag = false;
                    int a = Integer.parseInt(actions[1]);
                    int b = Integer.parseInt(actions[2]);
                    for (int j = 0 ; j < n ; j ++){
                        if (flags[j] && queues[j].contains(a) && queues[j].contains(b)){
                            flag = true;
                            System.out.println(Math.abs(queues[j].indexOf(a) - queues[j].indexOf(b) - 1));
                            break;
                        }
                    }
                    if (!flag){
                        System.out.println(-1);
                    }
                }
            }
        }
    }
}
