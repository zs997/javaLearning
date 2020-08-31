package cn.zs.practice.jianzhi;

import cn.zs.commonStructure.LinkNode;

public class JZ15ReverseLink {
    public static LinkNode reverseNon(LinkNode head){
        if (head == null || head.next == null){
            return head;
        }
        LinkNode dummy = new LinkNode(-1);
        dummy.next = head;
        LinkNode pre = head;
        LinkNode nex = pre.next;
        while (nex != null){
            LinkNode second = dummy.next;
            dummy.next = nex;
            pre.next = nex.next;
            nex.next = second;
            nex = pre.next;
        }
        return dummy.next;

    }
    public static LinkNode reverse(LinkNode head){
        if (head == null || head.next == null)
            return  head;
        LinkNode newHead = reverse(head.next);
        LinkNode p = newHead;
        while (p != null && p.next !=null){
            p = p.next;
        }
        p.next = head;
        head.next = null;
        return newHead;
    }
}
