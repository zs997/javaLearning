package cn.zs.exam.tiger;

/*      capacity 每趟车的载客数目
        trip[][] 二维数组
        trip[i][0] 表示i站上车人数
         trip[i][1]表示i站下车人数
* */
public class MinBus {
    public static void main(String[] args) {

    }

    static int[] station = new int[1001];

    public static int minCarCount(int[][] trip, int capacity) {
        for(int i = 0; i < trip.length; i++) {
            getNum(trip[i]);
        }
        int num = 1;
        for (int peopleNum : station) {
            int carNum = peopleNum / capacity + (peopleNum % capacity == 0 ? 0 : 1);
            num = Math.max(num, carNum);
        }
        return num;
    }

    private static void getNum(int[] trip) {
        int num = trip[0];
        int start = trip[1];
        int end = trip[2];
        for(int i = start; i <= end; i++) {
            station[i] +=num;
        }
        station[end] -= num;
    }
}
