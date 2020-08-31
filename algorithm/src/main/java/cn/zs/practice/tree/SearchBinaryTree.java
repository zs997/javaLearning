package cn.zs.practice.tree;

import java.util.ArrayList;





public class SearchBinaryTree {

	public static void main(String[] args) {
		SearchBinaryTree sbt = new SearchBinaryTree();
//			int [] data = {50,30,60,15,45,55,70,14};
//			int [] data = {50,45,15,30,70,55,60};
		int [] data = {50,45,15,30,70,55,60,9,46,5,12,20,36,47};
		sbt.CreatSearchBinaryTree(data);
//			ArrayList<String> data = new ArrayList<String>();
//			String [] d = {"50","30","15","#","#","45","#","#","60","55","#","#","70","#","#"};
//			for(String s:d){
//				data.add(s);
//			}
//			sbt.CreateBinaryTree(data);
		sbt.midOrder();
//			sbt.put(14);
//			sbt.del(14);
		System.out.println(sbt.delModify(45));
		sbt.midOrder();

//			sbt.put(14);
//			sbt.midOrder();

//			System.out.println(sbt.SearchNon(70));
	}
	public TreeNode root = null;
	public SearchBinaryTree(){
		root = null;
	}

	//创建二叉排序树
	public void CreatSearchBinaryTree(int [] data){
		for(int i:data){
			put(i);
		}
	}
	//对二叉排序树元素进行删除 改进版
	public TreeNode delModify(int data){
		if(root == null)
			return null;


		TreeNode par = null;
		TreeNode target = null;
		boolean LR = false;
		if((target = SearchNonMod(data))!= null){
			//找到了该元素
			par = target.par;
			LR = (par.left.equals(target))?true:false;


			if(target.left == null){
				par.setLR(target.right, LR);
			}else if(target.right == null){
				par.setLR(target.left, LR);
			}else{
				//左右子树都不为空

				TreeNode p1 = target.right;
				if(p1.left == null){
					//目标右子树不为空 右子树的左子树为空
					par.setLR(p1, LR);
					p1.left = target.left;
				}else{
					TreeNode p2 = p1;
					while(p2.left != null){
						p1 = p2;
						p2 = p2.left;
					}
					//p2的左子树为空 p1.left=p2
					p1.left = p2.right;
					par.setLR(p2, LR);
					p2.left = target.left;
					p2.right = target.right;
				}
			}
		}
		//没有该元素
		return target;
	}
	//对二叉排序树元素进行删除
	public TreeNode del(int data){
		if(root == null)
			return null;

		SearchResult result =null;
		TreeNode par = null;
		TreeNode target = null;
		boolean LR = false;
		if((result = this.SearchNonModifiy(data)).res){
			//找到了该元素
			par = result.par;
			LR = result.LR;
			target = par.getLR(LR);

			if(target.left == null){
				par.setLR(target.right, LR);
			}else if(target.right == null){
				par.setLR(target.left, LR);
			}else{
				//左右子树都不为空

				TreeNode p1 = target.right;
				if(p1.left == null){
					//目标右子树不为空 右子树的左子树为空
					par.setLR(p1, LR);
					p1.left = target.left;
				}else{
					TreeNode p2 = p1;
					while(p2.left != null){
						p1 = p2;
						p2 = p2.left;
					}
					//p2的左子树为空 p1.left=p2
					p1.left = p2.right;
					par.setLR(p2, LR);
					p2.left = target.left;
					p2.right = target.right;
				}
			}
		}
		//没有该元素
		return target;
	}
	//对二叉排序树进行元素插入
	public boolean put(int data){
		// root 为空
		if(root == null){
			root = new TreeNode(data);
			return true;
		}
		//root 不为空
		TreeNode temp = root;
		TreeNode par = temp;
		boolean  flag = false;
		while(temp != null){
			if(temp.data == data)
				return false;
			else if(temp.data > data){
				par = temp;
				temp = temp.left;
				flag = false;
			}else {
				par = temp;
				temp = temp.right;
				flag = true;
			}

		}
		if(flag){
//				par.right = new TreeNode(data);
			par.right = new TreeNode(data,par);
		}else{
//				par.left = new TreeNode(data);
			par.left = new TreeNode(data,par);
		}


		return true;

	}




	//给定先序遍历 递归创建二叉树
	public void  CreateBinaryTree(ArrayList<String> data){

		root = CreateBinaryTree(data,null);
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
			tn = new TreeNode(Integer.parseInt(s));
			data.remove(0);
			tn.left = CreateBinaryTree(data,tn.left);
			tn.right = CreateBinaryTree(data,tn.right);
			return tn;
		}
	}



	//递归中序遍历 递归 ok
	public void midOrder(){
		System.out.println("this is mid Order");
		midOrder(root);
	}

	public void midOrder (TreeNode root){
		if(root == null){
			return;
		}else{
			midOrder(root.left);
			System.out.println(root);
			midOrder(root.right);
		}
	}


	//递归实现二叉树查找
	public  boolean Search(int data){
		return Search(data,root);
	}
	public boolean Search(int data ,TreeNode tn){
		if(tn == null)
			return false;
		if(tn.getData() == data){
			return true;
		}else if(tn.getData() < data){
			return Search(data,tn.right);
		}else{
			return Search(data,tn.left);
		}
	}
	//非递归实现二叉树查找
	public SearchResult SearchNonModifiy(int data){
		//第三个res封装false 表示没有找到 前两个表示要封装的数据位置 参数1 父节点 参数2 LR左右
		//第三个res封装TRUE 表示找到了 前两个参数表示数据位置
		//前两行处理特殊情况
		if(root == null)
			return new SearchResult(null,false,false); //查找错误 根节点是要放的
		if(root.data == data)
			return new SearchResult(null,false,true); //根节点是查找目标
		//以下代码执行条件是 root不为空 且不是目标
		TreeNode par = root;
		TreeNode temp = root;
		boolean LR = false;
		while(temp != null){
			if(temp.data == data)
				return new SearchResult(par,LR,true);
			else if(temp.data<data){
				par = temp;
				temp = temp.right;
				LR = false;
			}else {
				par = temp;
				temp = temp.left;
				LR = true;
			}
		}
		return new SearchResult(par,LR,false);	//没有找到 返回应该插入的父节点和相应LR
	}
	//非递归实现二叉树查找 返回节点
	public TreeNode SearchNonMod(int data){
		TreeNode temp = root;
		while(temp != null){
			if(temp.data == data)
				return temp;
			else if(temp.data<data)
				temp = temp.right;
			else
				temp = temp.left;
		}
		return temp;

	}
	//非递归实现二叉树查找
	public boolean SearchNon(int data){
		TreeNode temp = root;
		while(temp != null){
			if(temp.data == data)
				return true;
			else if(temp.data<data)
				temp = temp.right;
			else
				temp = temp.left;
		}
		return false;

	}
}
