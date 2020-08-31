package cn.zs.practice.links;

import cn.zs.commonStructure.ListNode;

public class leecode {

    public static ListNode reverse(ListNode pre, int k){
        ListNode last = pre;
        for(int i = 0; i < k; i++){

            last = last.next;
            if(last == null){
                return null;
            }
        }
        ListNode tail = pre.next;
        ListNode cur = pre.next.next;

        while(cur != null && cur != last){
            tail.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tail.next;
        }
        if(cur == last){
            tail.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = tail.next;
        }
        return tail;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode p1 = new ListNode(1);
       // ListNode p2 = new ListNode(2);
      //  ListNode p3 = new ListNode(3);
      //  ListNode p4 = new ListNode(4);
        head.next = p1;
      //  p1.next = p2;
     //   p2.next = p3;
     //   p3.next = p4;
        reverse(head,2);


    }
}
