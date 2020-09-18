package cn.zhushuai;

public class Main6 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node n1 = new Node(2);
        Node n2 = new Node(4);
        Node n3 = new Node(4);
        Node n4 = new Node(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Node node = removeTrip(head);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static Node removeTrip(Node head){
        Node pre = head;
        Node cur = head.next;
        while (cur != null){
            if (cur.val == pre.val){
                cur  = cur.next;
            }else {
                pre.next = cur;
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
class Node{
    Node(int val){
        this.val = val;
    }
    int val;
    Node next;
}
