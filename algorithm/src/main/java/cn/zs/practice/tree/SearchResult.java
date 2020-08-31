package cn.zs.practice.tree;

//第三个封装false 表示没有找到 前两个表示要封装的数据位置 参数1 父节点 参数2 LR左右
//第三个封装TRUE 表示找到了 前两个参数表示数据位置

public class SearchResult {
	public TreeNode par;
	public boolean LR;
	public boolean res; //true 表示找到了 false没有

	@Override
	public String toString() {
		return "SearchResult [par=" + par + ", LR=" + LR + ", res=" + res + "]";
	}
	public SearchResult(TreeNode par, boolean lR) {
		super();
		this.par = par;
		LR = lR;
	}
	public SearchResult(TreeNode par, boolean lR,boolean res) {
		super();
		this.par = par;
		LR = lR;
		this.res = res;
	}
	public SearchResult() {
		par = null;
		LR = false;
		res = false;
	}

}
