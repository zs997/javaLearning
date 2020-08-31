package cn.zs.exam.nognhang;

public class Dot {
    public static void main(String args[]){

    }
    public int get_index(String [] points){
        int [][] data = new int[points.length][2];
        for (int i = 0; i < points.length; i++) {
            String point = points[i];
            String[] split = point.split(",");
            data[i][0] = Integer.valueOf(split[0]);
            data[i][1]  =Integer.valueOf(split[1]);
        }
        return 1;
    }
}
