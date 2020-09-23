package cn.kh;

import java.util.Scanner;
import java.util.TreeSet;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        int[] parent = new int[n];
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }
        for(int i=0;i<m;i++){
            String line = sc.nextLine();
            String[] lines = line.split(" ");
            if(lines[0].equals("C")){
               int a = Integer.parseInt(lines[1]);
               int b = Integer.parseInt(lines[2]);
               union(a-1,b-1,parent);
            }

            if(lines[0].equals("Q")){
                int c = Integer.parseInt(lines[1]);
                int d = Integer.parseInt(lines[2]);
                int val = find2(c,d,parent);
                if(val==0){
                    System.out.println(-1);
                }else{
                    System.out.println(val);
                }
            }

        }



    }

    public static int find(int x,int[]parent) {

        int root_x = x;

        while(parent[root_x]!=-1) {
            root_x = parent[root_x];
        }

        return root_x;
    }

    public static int find2(int x,int y,int[]parent) {
        int count = 0;
        int root_x = x;

        while(parent[root_x]!=y) {
            root_x = parent[root_x];
            count++;
        }

        return count--;
    }


    public static int union(int x,int y,int[]parent) {

        int x_root = find(x,parent);

        int y_root = find(y,parent);

        if(x_root!=y_root) {
            parent[x_root] = y_root;
        }else {
            return -1;
        }
        return 0;
    }

}
