package cn.zs.basic.grammer;


import cn.zs.commonStructure.TreeNode;

import java.util.ArrayList;


public class CollectionTest {
    public static void main(String args[]){
//        HashMap<String,String> hashMap = null;
//        ConcurrentHashMap<String,String> res= null;
//        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList();
        ArrayList<TreeNode> list = new ArrayList<>();
        System.out.println(list);
        list.add(null);
        System.out.println(list);
    }
}
