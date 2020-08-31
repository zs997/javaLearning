package cn.zs.practice.jianzhi;

import cn.zs.commonStructure.TreeNode;

public class JZ61SerializeTree {
    int index = 0;
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val+",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        index ++;
        String[] arr = str.split(",");
        if(index >= arr.length){
            return null;
        }
        TreeNode temp = null;
        if(arr[index] != "#"){
            temp = new TreeNode(Integer.valueOf(arr[index]));
            temp.left = Deserialize(str);
            temp.right =  Deserialize(str);
        }
        return temp;

    }

}
