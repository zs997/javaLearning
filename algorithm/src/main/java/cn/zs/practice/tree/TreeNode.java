package cn.zs.practice.tree;
//定义节点类型
public class TreeNode{
	//		private int index;
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode par;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (data != other.data)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}
	public TreeNode(int data){
		this.data=data;
		this.left = null;
		this.right = null;
	}
	public TreeNode(int data ,TreeNode par){
		this.data=data;
		this.left = null;
		this.right = null;
		this.par = par;
	}
	//无参数构造函数
	public TreeNode(){
		this.data=-1;
		this.left = null;
		this.right = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeft() {
		return left;
	}
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	public TreeNode getRight() {
		return right;
	}
	public void setRight(TreeNode right) {
		this.right = right;
	}
	public TreeNode getLR(boolean LR){
		if(LR)
			return this.left;
		else
			return this.right;
	}
	public TreeNode destoryLR(boolean LR){
		TreeNode res = null;
		if(LR){
			res = this.left;
			this.left = null;
			return res;
		}else {
			res = this.right;
			this.right = null;
			return res;
		}
	}

	public void setLR(TreeNode t,boolean LR){
		if(LR)
			this.left = t;
		else
			this.right = t;
	}
}
