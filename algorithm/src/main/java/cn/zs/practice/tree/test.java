package cn.zs.practice.tree;

public class test {
	
	public static void main(String[] args) {
		bean b = new bean("lisi","01");
		System.out.println(b);
		fun(b);
		System.out.println(b);
	}
	
	public static void fun(bean bb){
		bb.setName("zs");
	}
	public static class bean{
		public String name;
		public String no;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getNo() {
			return no;
		}
		public void setNo(String no) {
			this.no = no;
		}
		@Override
		public String toString() {
			return "bean [name=" + name + ", no=" + no + "]";
		}
		public bean(String name, String no) {
			super();
			this.name = name;
			this.no = no;
		}
		public bean() {		
		}
	}
	
	
	
}
