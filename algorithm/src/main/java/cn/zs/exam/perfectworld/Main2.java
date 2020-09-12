package cn.zs.exam.perfectworld;

import java.util.Scanner;
/**
 *      80%
 *      在一个平面坐标系中
 *      第一象限 （0,30） （0，60） （0,90）
 *      （30,0） （60,0） （90,0） 包围成9个方块
 *      输入一个圆  给定坐标和半径
 *      输出 该圆占据的方块数目
 *
 *      ^
 *      |
 *      -
 *      |
 *      -
 *      |
 *      |--- |--- |---- |--->
 *
 * */
public class Main2 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int calSquareNum(double x, double y, double r) {
        double top  = y+r;
        double bottom = y-r;
        double left = x-r;
        double right = x+r;
        if (left < 30){
            if (right <= 30){
                if (top > 60){
                    if (bottom >= 60){
                        return 1;
                    }else if (bottom >=30){
                        return 2;
                    } else {
                        return 3;
                    }
                }else if (top > 30){
                    if (bottom >= 30)
                        return 1;
                    else return 2;
                }else if (top >0){
                    if (bottom >=0 )
                        return 1;
                    else return 0;
                }else {
                    return 0;
                }
            }else if(right <= 60){
                if (top > 60){
                    if (bottom >= 60){
                        return 2;
                    }else if (bottom >=30){
                        return 4;
                    } else {
                        return 6;
                    }
                }else if (top > 30){
                    if (bottom >= 30)
                        return 2;
                    else return 4;
                }else if (top >0){
                    if (bottom >=0 )
                        return 2;
                    else return 0;
                }else {
                    return 0;
                }
            }else{
                if (top > 60){
                    if (bottom >= 60){
                        return 3;
                    }else if (bottom >=30){
                        return 6;
                    } else {
                        return 9;
                    }
                }else if (top > 30){
                    if (bottom >= 30)
                        return 3;
                    else return 6;
                }else if (top >0){
                    if (bottom >=0 )
                        return 3;
                    else return 0;
                }else {
                    return 0;
                }
            }
        }else if(left < 60) {
            if (right <= 60){
                if (top > 60){
                    if (bottom >= 60){
                        return 1;
                    }else if (bottom >=30){
                        return 2;
                    } else {
                        return 3;
                    }
                }else if (top > 30){
                    if (bottom >= 30)
                        return 1;
                    else return 2;
                }else if (top >0){
                    if (bottom >=0 )
                        return 1;
                    else return 0;
                }else {
                    return 0;
                }
            }else {
                if (top > 60){
                    if (bottom >= 60){
                        return 2;
                    }else if (bottom >=30){
                        return 4;
                    } else {
                        return 6;
                    }
                }else if (top > 30){
                    if (bottom >= 30)
                        return 2;
                    else return 4;
                }else if (top >0){
                    if (bottom >=0 )
                        return 2;
                    else return 0;
                }else {
                    return 0;
                }
            }
        }else if (left < 90){
            if (top > 60){
               if (bottom >= 60){
                   return 1;
               }else if (bottom >=30){
                    return 2;
               } else {
                    return 3;
               }
            }else if (top > 30){
                if (bottom >= 30)
                    return 1;
                else return 2;
            }else if (top >0){
                if (bottom >=0 )
                    return 1;
                else return 0;
            }else {
                return 0;
            }
        }else {
            return 0;
        }
        //return 0;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        double _x;
        _x = Double.parseDouble(in.nextLine().trim());

        double _y;
        _y = Double.parseDouble(in.nextLine().trim());

        double _r;
        _r = Double.parseDouble(in.nextLine().trim());

        res = calSquareNum(_x, _y, _r);
        System.out.println(String.valueOf(res));

    }
}
