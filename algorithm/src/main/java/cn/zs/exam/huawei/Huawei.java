package cn.zs.exam.huawei;

import cn.zs.commonStructure.TreeNode;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
*       2020春 华为 没参与 没做出
* */
public class Huawei {
    public static void main(String[] args) {

//        TreeNode root = new TreeNode(0);
//        construct(root,true,"-1(3,2(0,-1))");
//        System.out.println(root.right);
    }


    public static void help(TreeNode root, boolean dir, String data){
        TreeNode temp = new TreeNode(data.charAt(0)-'0');
        if(dir){
            root.left = temp;
            help(root.left,true,data.substring(1,data.length()));
            help(root.left,false,data.substring(1,data.length()));
        }else{
            root.right = temp;
            help(root.right,true,data.substring(1,data.length()));
            help(root.right,false,data.substring(1,data.length()));
        }
    }
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("^(\\-?)\\d+(\\.\\d+)?$");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    public static void construct(TreeNode parent,boolean dir,String data){

        if(isNumeric(data)){
            int val = Integer.parseInt(data);
            if(dir){
                parent.left = new TreeNode(val);
            }else{
                parent.right = new TreeNode(val);
            }
           return;
        }else{
            int index = data.indexOf('(');
            String digit = data.substring(0, index);
            int val = Integer.parseInt(digit);
            if(dir){
                parent.left = new TreeNode(val);
            }else{
                parent.right = new TreeNode(val);
            }
            String dataNew = data.substring(index+1,data.length()-1);
            String[] split = dataNew.split(",");
            if( isNumeric(split[0]) ){
                if(dir){
                    construct(parent.left,true,split[0]);
                    construct(parent.left,false,dataNew.substring(dataNew.indexOf(',')+1,dataNew.length()));
                }else{
                    construct(parent.right,true,split[0]);
                    construct(parent.right,false,dataNew.substring(dataNew.indexOf(',')+1,dataNew.length()));
                }
           }else{
                Stack<Character> stack = new Stack<>();
                char[] chars = dataNew.toCharArray();
                int i = 0;
                for(;i< chars.length;i++){
                    Character c = chars[i];
                    if(c.equals('(')){
                        stack.push('(');
                    }else if(c.equals(')')){
                        stack.pop();
                    }
                    if(stack.isEmpty()){
                        break;
                    }
                }
                if(dir){
                    construct(parent.left,true,dataNew.substring(0,i+2));
                    construct(parent.left,false,dataNew.substring(i+2,dataNew.length()));
                }else{
                    construct(parent.right,true,dataNew.substring(0,i+2));
                    construct(parent.right,false,dataNew.substring(i+2,dataNew.length()));
                }
           }
        }
    }
}

