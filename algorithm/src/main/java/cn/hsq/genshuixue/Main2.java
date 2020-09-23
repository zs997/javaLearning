package cn.hsq.genshuixue;

/**
 * @ClassName Main2
 * @Description TODO
 * @Author huanshunqi
 * @Date 2020/9/23 20:51
 * @Version 1.0
 **/
public class Main2 {
    static Node getCommon(Node headA, Node headB) {

        if(headA==null||headB==null){
            return null;
        }
        int lengthA=0;
        int lengthB=0;
        Node node1=headA;
        Node node2=headB;
        Node result=null;
        while(node1!=null){
            lengthA++;
            node1=node1.getNext();
        }
        while(node2!=null){
            lengthB++;
            node2=node2.getNext();
        }
        node1=headA;
        node2=headB;
        while(lengthA>lengthB){
            node1=node1.getNext();
            lengthA--;
        }
        while(lengthA<lengthB){
            node2=node2.getNext();
            lengthB--;
        }
        while(true) {
            if(node1==node2){
                result=node1;
                break;
            }
            if(node1==null||node2==null){
                break;
            }
            node1=node1.getNext();
            node2=node2.getNext();
        }
        return result;
    }
}
