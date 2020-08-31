package cn.zs.practice.leetcode;

import java.util.Stack;

public class LeetCode20ValidParentheses {
	
	public static void main(String[] args) {
		System.out.println(isValid("()"));
	}
	  public static boolean isValid(String s) {
	        if(s == null || s.equals("")){return false;}
	        //char [] forward = {"(","{","["};
	      //  char [] reverse = {")","}","]"};
	        char [] data = s.toCharArray();
	        Stack<Character> stack = new Stack<>();
	        
	        for(int i = 0; i < data.length; i++){
	            if(isForward(data[i])){
	                stack.push(data[i]);
	             //   Integer.MAX_VALUE
	            }else{
	                if(stack.isEmpty()){
	                    return false;
	                }else{
	                    char temp = stack.pop();
	                    if(!isMatch(temp,data[i])){
	                        return false;
	                    }
	                }
	            }
	        }
	        if(stack.isEmpty()){
	            return true;
	        }else{
	            return false;
	        }
	        
	    }
	    public static boolean isMatch(char a,char b){
	        if( (a=='('&& b==')')||(a=='{'&&b=='}')|| (a=='['&&b==']')){
	            return true;
	        }
	        return false;
	    }
	    public static boolean isForward(char c){
	        if(c =='('||c =='{'||c =='['){
	            return true;
	        }
	        return false;
	    }
}
