package cn.kh;
import java.util.*;
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int q=0;q<T;q++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            int[] heart = new int[n];
            int[] res = new int[n];
            for(int i=0;i<n;i++){
                heart[i] = sc.nextInt();
                res[i] = heart[i];
            }
            Arrays.sort(heart);
            sc.nextLine();
            int[] rest = new int[m];
            for(int j=0;j<m;j++){
                rest[j] = sc.nextInt();
            }
            Arrays.sort(rest);
            sc.nextLine();


            int start = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                int pos = count(rest,heart[i],start);
                start = pos;
                map.put(heart[i],m-pos);
            }

            for(int i=0;i<n;i++){
                System.out.print(map.get(res[i])+" ");
            }
            sc.nextLine();
        }
    }

    public  static int count(int[] num,int target,int start){
        int i=start;
        for(;i<num.length;i++){
            if(num[i]>=target){
                break;
            }
        }
        return i;
    }
}

