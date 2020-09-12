package cn.zs.practice;

import cn.zs.commonStructure.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0)
            return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val)
                    return -1;
                else if (o1.val == o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        for(ListNode list:lists){
            if(list != null){
                queue.add(list);
            }
        }
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            tail.next = temp;
            tail = temp;
            if(temp.next != null){
                queue.add(temp.next);
            }
        }

        return dummy.next;

    }
}
