package cn.zs.exam.vivo;
import java.util.ArrayList;


public class Main3 {
     ArrayList<Node> data;
     ArrayList<Node> res = new ArrayList<>();
    public String compileSeq (String input) {
        // write code here
        String[] split = input.split(",");
        data = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            int ch = Integer.parseInt(split[i]);
            data.add(new Node(i,ch));
        }
        helper();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.size()-1; i++) {
            sb.append(res.get(i).id+",");
        }
        sb.append(res.get(res.size()-1).id);
        return sb.toString();
    }

    public  void helper(){
        if (data.size() == 0){
            return;
        }else{
            Node node=null;
            for (int i = 0; i < data.size(); i++) {
                node = data.get(i);
                if (node.data == -1){
                     data.remove(i);
                     res.add(node);
                     break;
                }
            }
            for (int i = 0; i < data.size(); i++) {
                if (node != null && data.get(i).data == node.id){
                    Node temp = data.get(i);
                    temp.data = -1;
                    data.set(i,temp);
                }
            }
            helper();
        }


    }
}
class Node{
    int id;
    int data;
    Node(int id,int data){
        this.id = id;
        this.data = data;

    }

}