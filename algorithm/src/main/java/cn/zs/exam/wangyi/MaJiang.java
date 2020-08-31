package cn.zs.exam.wangyi;
/*20200812网易互娱笔试
麻将的七星不靠胡法
东西南北中发白+147万+258饼+369条
东西南北中发白+147万+258条+369饼
东西南北中发白+147条+258饼+369万
东西南北中发白+147条+258万+369饼
东西南北中发白+147饼+258万+369条
东西南北中发白+147饼+258条+369万
 4
1T 4T 7T 2B 5B 8B 9W
1T 2T 3T 4T 5T 6T 7T
1B 2W 3T 4B 5W 6T 8W
2B 8B 5B 2B 6T 7T 4W
 out:
YES
NO
 YES
 NO
* */
import java.util.Scanner;
/*
    用1个三维数组记录6种牌型
    pattern[i][j][k]
    i 0~5 表示6种牌型
    j  0~2 表示 条 饼 万 0 1 2
    k 0~9 表示各种颜色的数字 如 j=0 k=3 表示3条
* */
public class MaJiang {
    private static boolean pattern [][][] = new boolean[6][3][10];
    public static void main(String[] args) {
        initPatten();
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int j = 0; j < n; j++) {
            String ss = sc.nextLine();
            yesOrNo(ss);
        }
    }
    public static void initPatten(){
        //初始化pattern

            pattern[0][0][3] = true;
            pattern[0][0][6] = true;
            pattern[0][0][9] = true;
            pattern[0][1][2] = true;
            pattern[0][1][5] = true;
            pattern[0][1][8] = true;
            pattern[0][2][1] = true;
            pattern[0][2][4] = true;
            pattern[0][2][7] = true;

            pattern[1][0][2] = true;
            pattern[1][0][5] = true;
            pattern[1][0][8] = true;
            pattern[1][1][3] = true;
            pattern[1][1][6] = true;
            pattern[1][1][9] = true;
            pattern[1][2][1] = true;
            pattern[1][2][4] = true;
            pattern[1][2][7] = true;

            pattern[2][0][1] = true;
            pattern[2][0][4] = true;
            pattern[2][0][7] = true;
            pattern[2][1][2] = true;
            pattern[2][1][5] = true;
            pattern[2][1][8] = true;
            pattern[2][2][3] = true;
            pattern[2][2][6] = true;
            pattern[2][2][9] = true;

            pattern[3][0][1] = true;
            pattern[3][0][4] = true;
            pattern[3][0][7] = true;
            pattern[3][1][3] = true;
            pattern[3][1][6] = true;
            pattern[3][1][9] = true;
            pattern[3][2][2] = true;
            pattern[3][2][5] = true;
            pattern[3][2][8] = true;

            pattern[4][0][3] = true;
            pattern[4][0][6] = true;
            pattern[4][0][9] = true;
            pattern[4][1][1] = true;
            pattern[4][1][4] = true;
            pattern[4][1][7] = true;
            pattern[4][2][2] = true;
            pattern[4][2][5] = true;
            pattern[4][2][8] = true;

            pattern[5][0][2] = true;
            pattern[5][0][5] = true;
            pattern[5][0][8] = true;
            pattern[5][1][1] = true;
            pattern[5][1][4] = true;
            pattern[5][1][7] = true;
            pattern[5][2][3] = true;
            pattern[5][2][6] = true;
            pattern[5][2][9] = true;

    }
    public static void yesOrNo(String str){
        boolean rightData = true;
        //条 饼 万 0 1 2
        boolean data[][] = new  boolean [3][10];
        String[] source = str.split(" ");
        // T 条 对应 data[0]
        // B 饼 对应 data[1]
        // W 万 对应 data[2]
        for (int i = 0; i < source.length; i++) {
            String s = source[i];
            char c = s.charAt(0);
            if (s.charAt(1) == 'T'){
                data[0][(int)(c-'0')] = true;
            }else if(s.charAt(1) == 'B'){
                data[1][(int)(c-'0')] = true;
            }else if(s.charAt(1) == 'W'){
                data[2][(int)(c-'0')] = true;
            }else {
                rightData = false;
            }
        }
        if (!rightData){
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < pattern.length; i++) {
            int count = 0;
            for (int j = 0; j < pattern[i].length; j++) {
                for (int k = 1; k < pattern[i][j].length; k++) {
                    if (pattern[i][j][k] == true && data[j][k] == true){
                        count++;
                    }
                }
            }
            if(count == 7){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
}
