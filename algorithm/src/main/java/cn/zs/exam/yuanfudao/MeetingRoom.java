package cn.zs.exam.yuanfudao;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
/*
* LeetCode253会议室
*   给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间
*   [[s1,e1],[s2,e2],…] (si < ei)，
*   为避免会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排
*   应该用优先队列好
* */
public class MeetingRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
        int n = sc.nextInt();
        Point [] datas = new Point[2*n];
        for (int i = 0; i < 2*n;i++){
            //type == 0 起点
            datas[i] = new Point(sc.nextInt(),i%2);
        }
        Arrays.sort(datas, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.value != o2.value){
                    return o1.value - o2.value;
                }
                return  o2.type-o1.value;

            }
        });
        for (int i = 0; i < datas.length; i++) {
            System.out.println(datas[i].value+" "+datas[i].type);
        }
        int count = 0;
        int maxOverlap = 0;
        for (int i = 0; i < datas.length;i++){
            Point temp = datas[i];
            if (temp.type == 0){
                count++;
                maxOverlap = Math.max(count,maxOverlap);
            }else {
                count--;
            }
        }
        System.out.println(maxOverlap);
        return;
    }
    //应该的做法
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        int[] start = new int[intervals.length];
        int[] end = new int [intervals.length];
        for(int i = 0; i < intervals.length; i ++) {
            start[i] = intervals[i][0];
            System.out.println(start[i]);
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        PriorityQueue<Integer> pq = new PriorityQueue<>(end.length);
        pq.add(end[0]);
        for(int i = 1; i < end.length; i ++) {
            if(start[i] >= pq.peek())
                pq.poll();
            pq.add(end[i]);
        }
        return pq.size();
    }

}

class  Point{

    int value;
    int type;
    Point(){}
    Point(int value,int type){
        this.value = value;
        this.type =  type;
    }
/**4
 * 1 4
 * 1 2
 * 2 3
 * 3 4
 * */
}