package cn.zs.exam.pinduoduo;

import java.util.*;
/*  拼多多笔试题
    骰子有很多6面

* */
public class Dice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Six,Integer> map = new HashMap<>();
        int n = sc.nextInt();
        Six [] datas = new Six[n];
        for (int i = 0; i < n; i++) {
            datas[i] = new Six(sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextInt());
        }
        map.put(datas[0],1);
        for (int j = 1; j < datas.length; j++) {
            Set<Six> sixes = map.keySet();
            boolean found = false;
            for(Six cur : sixes){
                Six temp = new Six(datas[j]);
                temp.asUp(cur.up);
                temp.asLeft(cur.left);
                if (temp.equals(cur)){
                    map.put(cur,map.get(cur)+1);
                    found = true;
                    break;
                }
            }
            if (!found){
                map.put(datas[j],1);
            }
        }
        System.out.println(map.size());
        Set<Six> sixes = map.keySet();
        ArrayList<Integer> list = new ArrayList<>();
        for (Six six : sixes){
            list.add(map.get(six));
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < list.size()-1; i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.print(list.get(list.size()-1));
    }
}
class Six{
    int up;
    int down;
    int left;
    int right;
    int front;
    int back;
    public boolean asLeft(int value){
        //上下不变 只有左右变换
        if (left == value){
            return true;
        }else if(front == value){
            int temp = front;
            front = right;
            right = back;
            back = left;
            left = temp;
            return true;
        }else if(right == value){
            int temp = right;
            right = left;
            left = temp;
            temp  = front;
            front = back;
            back = temp;
            return  true;
        }else if(back == value){
            int temp = back;
            back = right;
            right = front;
            front = left;
            left = temp;
            return true;
        }
        return  false;
    }
    public boolean asUp(int value){
        if (up == value){
            return true;
        }else if(down == value){
            // 上下交换
            int temp = down;
            down = up;
            up = temp;
            //左右交换
            temp = left;
            left = right;
            right =temp;
            //前后不换
            return  true;
        }else if(left == value){
            //前后不换
            //顺时针向右旋转
            int temp = left;
            left = down;
            down = right;
            right = up;
            up = temp;
            return  true;
        }else if(right == value){
            //前后不变
            //逆时针 向左旋转
            int temp = right;
            right = down;
            down = left;
            left = up;
            up = temp;
            return true;
        }else if(front == value){
            //左右不变
            //前面向后翻转
            int temp = front;
            front = down;
            down = back;
            back = up;
            up = temp;
            return true;
        }else if (back == value){
            //左右不变
            //向前翻转
            int temp = back;
            back = down;
            down = front;
            front = up;
            up = temp;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Six{" +
                "up=" + up +
                ", down=" + down +
                ", left=" + left +
                ", right=" + right +
                ", front=" + front +
                ", back=" + back +
                '}';
    }

    Six(int up,int down,int left,int right,int front,int back){
        this.up = up;
        this.down = down;
        this.left = left;
        this.right = right;
        this.front = front;
        this.back = back;

    }
    Six(Six data){
        up = data.up;
        down = data.down;
        left = data.left;
        right = data.right;
        front = data.front;
        back = data.back;

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Six six = (Six) o;
        return up == six.up &&
                down == six.down &&
                left == six.left &&
                right == six.right &&
                front == six.front &&
                back == six.back;
    }
    @Override
    public int hashCode() {
        return Objects.hash(up, down, left, right, front, back);
    }
}


/**
 * 3
 * 1 2 3 4 5 6
 * 1 2 6 5 3 4
 * 1 2 3 4 6 5
 * */

/*


* */