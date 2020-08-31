package cn.zs.exam.meituan;

/*
*   2020春季
* */
import java.util.*;

public class Meituan {
    public static void main(String[] args) {
        meituan4();

    }
    /*
    *   n个学生，m个科目。已知每个学生的分数。
    *   给学生发单科奖学金，取每科最高分的同学（可能并列，都发）发奖学金。
    *   问一共有多少同学得到了奖学金？
    * */
    public static int meituan1(){
        Scanner sc = new Scanner(System.in);
        //学生人数
        int n = sc.nextInt();
        //考试科目数
        int m = sc.nextInt();
        int [][] score = new  int [n][m];
        //第i学生
        for (int i = 0; i < score.length; i++) {
            //第j科目
            for (int j = 0; j < score[i].length; j++) {
                score[i][j] = sc.nextInt();
            }
        }
        //记录学生是否是最好
        boolean best [] = new boolean[n];
        //查看每一科 最好的
        for (int j = 0; j < m; j++) {
            int bestScore = 0;
            //每一个学生
            for(int i = 0; i <n;i++){
                if(score[i][j] > bestScore){
                    bestScore = score[i][j];
                }
            }
            for(int i = 0;i <n ;i++){
                if(score[i][j] == bestScore){
                    best[i] = true;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < best.length; i++) {
            if(best[i]){
                sum++;
            }
        }
        System.out.println();
        return  sum;
    }
    /*
    *   给定 a b m x 按照公式迭代计算 x=(a*x+b)%m;
        x会产生循环序列，问最小的循环序列长度。
    * */
    public static void meituan2(){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int m = sc.nextInt();
        int x= sc.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        while (true){
            x=(a*x+b)%m;
            if (map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else{
                map.put(x,1);
            }
            if(map.get(x) >2){break;}
        }
        System.out.println(map.size());
    }
    /*
    *       a1 = （x1,y1）与a2=（x2,y2）比较。
            x1>x2 则 a1 >a2
            x1 < x2 则 a1 < a2
            如果x1 == x2，比较y，给出结论。
            给出n个数，(x,y)都可以取n中的任意一个数，求第k小坐标.
            可以使用数学规律计算
            n中的数字排序
            坐标相当于两位数大小比较 x相当于十位 y相当于个位
            k/n+1 表示十位取第几小的数
            k%n 表示个位去第几小的数

    * */
    public static void meituan3(){
        ArrayList<Pair> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        //多少个数
        int nums = sc.nextInt();
        //第k小
        int k = sc.nextInt();
//        list.add(new Pair(1,2));
//        list.add(new Pair(2,1));
//        list.add(new Pair(1,3));
//        list.add(new Pair(3,1));
        int data [] = new int [nums];
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                list.add(new Pair(data[i],data[j]));
            }
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                //p1.compare(p2)
                // p1 > p2  1
                //p1 == p2 0
                //p1 < p2 -1
                if(p1.x > p2.x){
                    return 1;
                }else if(p1.x < p2.x){
                    return -1;
                }else{
                    // ==
                    if(p1.y > p2.y){
                        return 1;
                    }else if(p1.y < p2.y){
                        return -1;
                    }else{
                        return 0;
                    }
                }
            }
        });
        System.out.println(list.get(k-1));
    }

    public static void meituan3Improve(){

        Scanner sc = new Scanner(System.in);
        //多少个数
        int nums = sc.nextInt();
        //第k小
        int k = sc.nextInt();
        int data [] = new int [nums];

        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        int count = 0;
        int x= 0;
        int y = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                count++;
                if(count == k){
                    x= i;
                    y = j;
                    break;
                }
            }
        }

        System.out.println("("+x+","+y+")");
    }
    /*
    *   给出n,k。n代表后续有n个数，参与排序。这n个数定义中位数，对于排序好的数组，
    *   i=（1+n）/2 并向下取整，第i个数就是伪中位数。
        k表示数组中的一个数。
        想让在该数组中为k的数成为伪中位数，在数组应该至少要插入多少元素?
        如 4 2
        2 3 3 3
        一共四个数 想让2成为中位数，要在2之前插入比2小的数1 1，2就是中位数了。
        此时返回2，因为插入了两个1。
    * */
    public static void meituan4(){

        Scanner sc = new Scanner(System.in);
        //多少个数
        int n = sc.nextInt();
        int data [] = new int [n];
        //目标数 使k成为中位数
        int k = sc.nextInt();
//        int i = 0;
//        while (sc.hasNext()){
//            data[i] = sc.nextInt();
//            i++;
//        }
        for (int i = 0; i < data.length; i++) {
            data[i] = sc.nextInt();
        }
        Arrays.sort(data);
        //j 是k所在位置
        int j = 0;
        for (j = 0; j < data.length; j++) {
            if(data[j] == k){
                break;
            }
        }
       int mid = getMidPos(data);
        int res = 0;
        if(mid == j){
           res = 0;
        }else if(j < mid){
            // n-1-j j右边有几个 j就是j左边有几个 j左右边数目相同 还要减1
            res = n -1-j-j - 1;
        }else{
            res =  j - (n-1-j) -1;
        }
        System.out.println(res);

    }
    public static int getMidPos(ArrayList<Integer> list){
        //list 是从小到大排序的

        int mid = ((list.size()+1)/2);
        //返回中间的下标？
        return  mid -1;
//        return list.get(mid - 1);
    }


    public static int getMidPos(int [] list){
        //list 是从小到大排序的

        int mid = ((list.length+1)/2);
        //返回中间的下标？
        return  mid -1;
//        return list.get(mid - 1);
    }
}
class  Pair{
   public int x;
   public int y;
   Pair(){}
   Pair(int x,int y){
       this.x = x;
       this.y = y;
   }

    @Override
    public String toString() {
        return "("+x+","+y+')';
    }

    public int  compare(Pair p){
       //p1.compare(p2)
       // p1 > p2  1
       //p1 == p2 0
       //p1 < p2 -1
       if(this.x > p.x){
           return 1;
       }else if(this.x < p.x){
           return -1;
       }else{
           // ==
           if(this.y > p.y){
               return 1;
           }else if(this.y < p.y){
               return -1;
           }else{
               return 0;
           }
       }
    }
}