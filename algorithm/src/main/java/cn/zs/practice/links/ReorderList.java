package cn.zs.practice.links;

import cn.zs.commonStructure.LinkNode;

/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
* */
public class ReorderList {
    public static void reorderList(LinkNode head) {
        if(head == null){
            return;
        }
        LinkNode slow = head;
        LinkNode fast = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //中间点就是slow
        //将slow后面的数倒序
        if(slow.next != null && slow.next.next != null){
            LinkNode pre = slow.next;
            LinkNode nex = pre.next;
            while (nex != null){
                LinkNode second = slow.next;
                slow.next = nex;
                pre.next = nex.next;
                nex.next = second;
                nex = pre.next;
            }
        }
        //合并前半部分 后半部分
        LinkNode p1 = head;
        LinkNode p2 = slow.next;
        while (p1 != null && p2 != null){
            LinkNode nex = p1.next;
            p1.next = p2;
            slow.next = p2.next;
            p2.next = nex;
            p2 = slow.next;
            p1 = p1.next.next;

        }
    }
}
