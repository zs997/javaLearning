package cn.kh;

import java.util.*;

public class Main10 {
    public static void main(String args[]){
        Main10 main10 = new Main10();
        int safd = main10.graph_circle_checker("{(A->B),(B->C),(C->A)}");
        System.out.println(safd);
    }
    public int graph_circle_checker(String graph_string){
        String s = graph_string;
        int res = -2;
        try {
            s = s.substring(1, s.length() - 1);
            String[] split = s.split(",");
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < split.length; i++) {
                String s2 = split[i];
                s2 = s2.substring(1, s2.length() - 1);
                split[i] = s2;
                String[] split1 = s2.split("->");
                for (int i1 = 0; i1 < split1.length; i1++) {
                    set.add(split1[i1].toCharArray()[0]);
                }
            }
            // A -65
            int[][] data = new int[set.size()][set.size()];
            for (int i = 0; i < split.length; i++) {
                String[] split1 = split[i].split("->");
                data[split1[0].toCharArray()[0] - 65][split1[1].toCharArray()[0] - 65] = 1;
                //   System.out.println(split[i]);
            }
            boolean haveLoop = isHaveLoop(data, 3);
            if (haveLoop){
                res = 1;
            }else {
                res = 0;
            }
        }catch (Exception e){
            res = -1;
        }finally {
            return res;
        }
    }
    public  boolean isHaveLoop(int[][] graph, int n) {
        List<Integer>[] adj = new ArrayList[n];
        for (int[] edg : graph) {
            int node1 = edg[0];
            int node2 = edg[1];
            if (adj[node1] == null) {
                adj[node1] = new ArrayList<>();
            }
            if (adj[node2] == null) {
                adj[node2] = new ArrayList<>();
            }
            adj[node1].add(node2);
            adj[node2].add(node1);
        }
        boolean[] visited = new boolean[n];
        int[] a = {0};
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                dfsCycle(adj, i, -1, visited, a);
                if (a[0] == 1) {
                    return true;
                }
            }
        }
        return a[0] == 1;
    }
    private  void dfsCycle(List<Integer>[] adj, int current, int parent, boolean[] visited, int[] flag) {
        visited[current] = true;
        List<Integer> list = adj[current];
        for (Integer can : list) {
            if (visited[can] == false) {
                dfsCycle(adj, can, current, visited, flag);
            } else if (can != parent) {
                flag[0] = 1;
            }
        }
    }
}
