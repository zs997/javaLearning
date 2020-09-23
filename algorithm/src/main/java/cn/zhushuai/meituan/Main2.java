package cn.zhushuai.meituan;
import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.valueOf(s1[0]);
        int m = Integer.valueOf(s1[1]);
        int p = Integer.valueOf(s1[2]);
        int q = Integer.valueOf(s1[3]);
        char data[][] = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s2 = sc.nextLine();
            for (int i1 = 0; i1 < s2.length(); i1++) {
                data[i][i1] = s2.charAt(i1);
            }
        }
        String s2 = sc.nextLine();
//        for (int i = 0; i < data.length; i++) {
//            for (int j = 0; j < data[i].length; j++) {
//                System.out.print(data[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println(s2);
        long score = score(data, p, q, s2);
        System.out.println(score);


//        char data [][] = {{'S','#','+','+','O','#'},
//        {'O','X','X','#','X','#'},
//        {'+','+','+','+','+','+'},
//        {'#','#','#','X','X','#'},
//        {'+','+','#','O','#','+'},
//        {'O','X','O','+','+','X'}
//        };
//        int p = 20;
//        int q = 10;
//        String commmand= "SSDDDDDAWWSSSAWSSSADDD";
//        int score = score(data, p, q, commmand);
//        System.out.println(score);
    }

    //p得分点 q陷阱点 各分数
    public static long score(char[][] data, int p, int q, String command) {
        long res = 0;
        int i = 0;
        int j = 0;
        label:
        for (; i < data.length; i++) {
            for (; j < data[i].length; j++) {
                if (data[i][j] == 'S') {
                    break label;
                }
            }
        }
        char[] chars = command.toCharArray();
        for (int k = 0; k < chars.length; k++) {
            //向下
            if (chars[k] == 'S') {
                if (i >= data.length - 1 || data[i + 1][j] == '#') {

                } else {
                    i++;
                    if (data[i][j] == 'O') {
                        data[i][j] = '+';
                        res += p;
                    } else if (data[i][j] == 'X') {
                        data[i][j] = '+';
                        res -= q;
                    }
                }
            } else if (chars[k] == 'D') {
                //向右
                if (j >= data[0].length - 1 || data[i][j + 1] == '#') {

                } else {
                    j++;
                    if (data[i][j] == 'O') {
                        data[i][j] = '+';
                        res += p;
                    } else if (data[i][j] == 'X') {
                        data[i][j] = '+';
                        res -= q;
                    }
                }

            } else if (chars[k] == 'A') {
                //向左
                if (j <= 0 || data[i][j - 1] == '#') {

                } else {
                    j--;
                    if (data[i][j] == 'O') {
                        data[i][j] = '+';
                        res += p;
                    } else if (data[i][j] == 'X') {
                        data[i][j] = '+';
                        res -= q;
                    }
                }
            } else  if (chars[k] == 'W') {
                //向上
                if (i <= 0 || data[i - 1][j] == '#') {

                } else {
                    i--;
                    if (data[i][j] == 'O') {
                        data[i][j] = '+';
                        res += p;
                    } else if (data[i][j] == 'X') {
                        data[i][j] = '+';
                        res -= q;
                    }
                }
            }


        }
        return res;
    }
}