package cn.zs.practice.leetcode;


import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

//归并排序逆序版本
public class LeetCode127WordLadder {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        int res=1;
        LinkedList<String> queue=new LinkedList<>();
        queue.offer(start);
//        char c = "".charAt(0);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                String s = queue.poll();
                size--;
                if(isDiffOne(s,end)){
                    return res+1;
                }
               for(Iterator<String> iterator = dict.iterator();iterator.hasNext();){
                   String next = iterator.next();
                   if(isDiffOne(next,s)){
                       queue.offer(next);
                       iterator.remove();
                   }
               }
            }
            res++;
        }
        return 0;
    }
    public boolean isDiffOne(String w1, String w2) {
        int count = 0;
        for(int i = 0; i < w1.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i)) {
                count++;
            }
        }
        return count==1?true:false;
    }


}

