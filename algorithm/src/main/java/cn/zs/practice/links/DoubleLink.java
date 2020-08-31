package cn.zs.practice.links;
import cn.zs.commonStructure.LinkNode;

import java.util.Scanner;
/**
 * 将链表的所有元素都变成重复两次的链表,原始链表是排好序的
 *  1->2->2->3->3->3
 *  变成
 *  1->2->3
 * */
public class DoubleLink {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkNode domy = new LinkNode(1);
        LinkNode pre = domy;
        while (sc.hasNextInt()){
            int i = sc.nextInt();
            LinkNode cur = new LinkNode(i);
            pre.next = cur;
            pre = cur;
        }

        LinkNode cur = doubleLink(domy.next);
        while (cur.next !=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }

        System.out.println(cur.val);

    }
    public static LinkNode doubleLink(LinkNode head){
        if (head == null) return null;
        LinkNode pre = head;
        //先去重
        while (pre != null){
            LinkNode cur = pre.next;
            while (cur != null && cur.val == pre.val){
                cur = cur.next;
            }
            pre.next =cur;
            pre = cur;
        }
        //再double
         pre = head;
        while (pre != null){
            LinkNode temp = new LinkNode(pre.val);
            temp.next = pre.next;
            pre.next = temp;
            pre = temp.next;
        }
        return head;
    }
}

