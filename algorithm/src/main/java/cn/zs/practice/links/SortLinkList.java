package cn.zs.practice.links;

import cn.zs.commonStructure.LinkNode;

/*  在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。
* */
public class SortLinkList {
    public static void main(String[] args) {
        LinkNode l1 = new LinkNode(66);
        LinkNode l2 = new LinkNode(8);
        LinkNode l3 = new LinkNode(5);
        LinkNode l4 = new LinkNode(1);
        LinkNode l5 = new LinkNode(2);
        LinkNode l6 = new LinkNode(6);
        LinkNode m1 = new LinkNode(5);
        LinkNode m2 = new LinkNode(51);
        LinkNode m3 = new LinkNode(5);
        LinkNode m4 = new LinkNode(7);
        LinkNode m5 = new LinkNode(8);
        LinkNode m6 = new LinkNode(6);
        LinkNode m7 = new LinkNode(11);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = m1;
        m1.next = m2;
        m2.next = m3;
        m3.next = m4;
        m4.next = m5;
        m5.next = m6;
        m6.next = m7;
    //   reorderList(l1);
        LinkNode listNode = l1;
        while (listNode != null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }



    public static LinkNode sortLists(LinkNode head){
        if (head == null || head.next ==null){
            return  head;
        }
        LinkNode mid = getMid(head);
        LinkNode l2 = mid.next;
        mid.next = null;
        return merge(sortLists(head),sortLists(l2));
    }
    public static LinkNode merge(LinkNode l1,LinkNode l2){
        if (l1 == null){
             return  l2;
        }
        if (l2 == null){
            return  l1;
        }
        LinkNode head;
        LinkNode p1 = l1;
        LinkNode p2 = l2;
        if (l1.val <= l2.val){
            head = l1;
            p1 = p1.next;
        }else {
            head = p2;
            p2 = p2.next;
        }
        LinkNode p = head;
        while (p1 != null && p2 != null){
            if (p1.val <= p2.val){
                p.next = p1;
//                p = p.next;
                p1 = p1.next;
            }else{
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1!= null){
            p.next = p1;
        }
        if (p2!= null){
            p.next = p2;
        }
        return head;
    }
    public static LinkNode getMid(LinkNode head){
        if (head == null || head.next == null){
            return head;
        }
        LinkNode slow = head;
        LinkNode fast = head;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
