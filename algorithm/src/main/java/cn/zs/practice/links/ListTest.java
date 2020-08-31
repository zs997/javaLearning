package cn.zs.practice.links;

import cn.zs.commonStructure.ListNode;

public class ListTest {
    public static void main(String[] args) {
        ListTest listTest = new ListTest();
        ListNode h1 = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(2);
        h1.next = h2;
        h2.next = h3;
        listTest.deleteDuplicates(h1);
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){return head;}
        ListNode Dumi = new ListNode(-999);
        Dumi.next = head;
        //一步一步形成的新链表
        ListNode real = new ListNode(-99);
        ListNode res = real;
        //前一个节点
        ListNode pre = Dumi;
        //要考察的节点 如果不同于前后，加入
        ListNode cur = head;

        while(cur != null && cur.next != null){
            if(pre.val != cur.val && cur.val != cur.next.val){
                //此时 可以将cur加入
                real.next = cur;
                real = real.next;

            }
            pre = cur;
            cur = cur.next;

        }
        if(cur != null && pre.val != cur.val){
            real.next = cur;
        }
        return res.next;
    }
}



