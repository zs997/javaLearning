package cn.zs.practice.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		ArrayList<String> data = new ArrayList<>();
		String [] d = {"a","b","#","d","#","#","c","#","#"};
		for(String s:d){
			data.add(s);
		}
		bt.CreateBinaryTree(data);
		bt.midOrderNon();
		System.out.println(bt.depth());
		System.out.println(bt.nodeCount());
		bt.AfterOrder();
		bt.AfterOrderNon();
	}
	//定义节点类型
	private class TreeNode{
		private int index;
		private String data;
		private TreeNode left;
		private TreeNode right;
		@Override
		public String toString() {
			return "TreeNode [index=" + index + ", data=" + data + "]";
		}
		public TreeNode(int index,String data){
			this.index=index;
			this.data=data;
		}
		public TreeNode(String data){
			this.index=0;
			this.data=data;
			left = null;
			right = null;
		}
		public TreeNode(){

		}
		public int getIndex() {
			return index;
		}
		public void setIndex(int index) {
			this.index = index;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public TreeNode getLeft() {
			return left;
		}
		public void setLeft(TreeNode left) {
			left = left;
		}
		public TreeNode getRight() {
			return right;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}
	}

	//定义树结构的数据
	private TreeNode root = null;
	//定义树类型的构造函数
	public BinaryTree(){
		root = new TreeNode(1, "a");
	}
	private BinaryTree(int i){
		root = null;
	}
	public void CreateBinaryTree(){
		TreeNode Tb = new TreeNode(2, "b");
		TreeNode Tc = new TreeNode(3, "c");
		TreeNode Td = new TreeNode(4, "d");
		TreeNode Te = new TreeNode(5, "e");
		TreeNode Tf = new TreeNode(6, "f");
		root.left = Tb;
		root.right = Tc;
		Tb.left = Td;
		Tb.right = Te;
		Tc.right = Tf;
	}



	//给定先序遍历 递归创建二叉树

	public void  CreateBinaryTree(ArrayList<String> data){
		for(String s:data){
			System.out.println(s);
		}
		root = CreateBinaryTree(data,new TreeNode());
	}

	public TreeNode CreateBinaryTree(ArrayList<String> data,TreeNode tn){
		if(data.size() == 0){
			return null;
		}
		String s = data.get(0);
		if(s.equals("#")){
			data.remove(0);
			return null;
		}else{
			tn = new TreeNode(s);
			data.remove(0);
			tn.left = CreateBinaryTree(data,tn.left);
			tn.right = CreateBinaryTree(data,tn.right);
			return tn;
		}
	}

	public int depth(){

		return depth(root);
	}
	public int depth(TreeNode t){

		if(t == null)
			return 0;

		return depth(t.left)>depth(t.right)?depth(t.left)+1:depth(t.right)+1;
	}

	public int nodeCount(){
		return nodeCount(root);
	}

	private int nodeCount(TreeNode t) {
		if(t == null)
			return 0;
		return 1+nodeCount(t.left)+nodeCount(t.right);
	}

	//递归前序遍历 递归 ok
	public void preOrder(){
		System.out.println("this is pre Order");
		preOrder(root);
	}

	public void preOrder (TreeNode root){
		if(root == null){
			return;
		}else{
			System.out.println(root.index+"...."+root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	//非递归 前序遍历 ok
	public void preOrderNon(){
		System.out.println("this is pre Order non");
		Stack <TreeNode> stack = new Stack <TreeNode> ();
		stack.push(root);
		TreeNode temp = null;
		while((!stack.isEmpty())&&(stack.peek()!=null)){
			temp = stack.pop();
			System.out.println(temp);
			if(temp.right != null)
				stack.push(temp.right);
			if(temp.left != null)
				stack.push(temp.left);
		}
	}


	//递归中序遍历 ok
	public void midOrder(){
		System.out.println("this is midOrder");
		midOrder(root);
	}

	public void midOrder (TreeNode root){
		if(root == null){
			return;
		}else{
			preOrder(root.left);
			System.out.println(root.index+"...."+root.data);
			preOrder(root.right);
		}
	}

	//非递归 中序遍历 ok
	public void midOrderNon(){
		System.out.println("this is mid Order non");
		Stack <TreeNode> stack = new Stack <TreeNode> ();
		stack.push(root);
		TreeNode temp = root;
		boolean flag = true; //继续追溯的标志
		while(!stack.isEmpty()){

			if((temp.left != null)&&(flag == true)){
				stack.push(temp.left);
				temp = temp.left;
			}else{
				flag = false;
				temp = stack.pop();
				System.out.println(temp);
				if(temp.right != null){
					stack.push(temp.right);
					temp = temp.right;
					flag = true;
				}
			}

		}

	}




	//后序遍历 递归 ok
	public void AfterOrder(){
		System.out.println("this is AfterOrder");
		AfterOrder(root);
	}

	public void AfterOrder (TreeNode root){
		if(root == null){
			return;
		}else{
			preOrder(root.left);
			preOrder(root.right);
			System.out.println(root.index+"...."+root.data);
		}
	}
	// 后遍历 非递归  ok
	public void AfterOrderNon(){
		/*	后序遍历的倒序就是按先右后左顺序的前序遍历. */
		System.out.println("this is After Order non");
		Stack <TreeNode> stack = new Stack <TreeNode> ();
		Stack <TreeNode> res = new Stack <TreeNode> ();
		stack.push(root);
		TreeNode temp = null;
		while((!stack.isEmpty())&&(stack.peek()!=null)){
			temp = stack.pop();
			res.push(temp);
			if(temp.left != null)
				stack.push(temp.left);
			if(temp.right != null)
				stack.push(temp.right);
		}

		while(!res.isEmpty()){
			System.out.println(res.pop());
		}
	}


	//按层遍历 非递归 ok
	public void levelOrderNon(){
		System.out.println("this is level Order");
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);

		TreeNode temp = null;
		while(!queue.isEmpty()){
			if((temp=queue.poll())!=null){
				System.out.println(temp);
			}
			if(temp.left != null)
				queue.offer(temp.left);
			if(temp.right != null)
				queue.offer(temp.right);
		}
	}


}
