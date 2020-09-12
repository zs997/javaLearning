package cn.zs.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode88SortedArraysMerge {

    static class Node {
        int value;
        int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
    //两个等长数组的 中位数
    int get_middle_number(int a[], int b[], int n)
    {
        int	start1 = 0, end1 = n-1, m1;
        int	start2 = 0, end2 = n-1, m2;

        while (start1 != end1 || start2 != end2) {
            m1 = (start1 + end1) / 2;
            m2 = (start2 + end2) / 2;
            if (a[m1] == b[m2])
                return a[m1];
            if (a[m1] < b[m2]) {
                if ((start1+end1) % 2 == 0) {
                    start1 = m1;
                    end2 = m2;
                } else {
                    start1 = m1 + 1;
                    end2 = m2;
                }
            } else {
                if ((start1+end1) % 2 == 0) {
                    end1 = m1;
                    start2 = m2;
                } else {
                    end1 = m1;
                    start2 = m2 + 1;
                }
            }
        }
        return a[start1] < b[start2] ? a[start1] : b[start2];
    }

    //
    public static int[] MergeArrays(int[][] arr) {
        int N = arr.length, L;
        if (N == 0)//此时传入数组为空
            return new int[0];
        else {//判断数组是否符合规范
            L = arr[0].length;
            for (int i = 1; i < N; i++)
                if (arr[i].length != L)
                    return new int[0]; //此时数组不规范
        }
        int[] result = new int[N * L];
        int[] index = new int[N];
        Arrays.fill(index, 0, N, 0);
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                if (n1.value < n2.value)
                    return -1;
                else if (n1.value > n2.value)
                    return 1;
                else
                    return 0;
            }
        });
        for (int i = 0; i < N; i++) {
            Node node = new Node(arr[i][index[i]++], i);
            queue.offer(node);
        }
        System.out.println("" + queue.size());
        int idx = 0;
        while (idx < N * L) {
            Node minNode = queue.poll();
            result[idx++] = minNode.value;
            if (index[minNode.idx] < L) {
                queue.offer(new Node(arr[minNode.idx][index[minNode.idx]], minNode.idx));
                index[minNode.idx]++;
            }
        }
        return result;
    }
}
