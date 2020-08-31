package cn.zs.practice.jianzhi;

import cn.zs.commonStructure.node;

public class JZ46JoseHoop {
	public static int N = 20;
	public static int m = 5;

	public static void main(String[] args) {
		doJoseHoop();
	}

	public static int doJoseHoop(){

		node head = new node(1);
		node pointer = head;
		for(int i =2; i <= N; i++){
			pointer.next = new node(i);
			pointer = pointer.next;
		}
		pointer.next = head;

		//输出 看看效果
//		node p1 = head;
//		while(!p1.next.equals(head)){
//			System.out.println(p1.no);
//			p1 = p1.next;
//		}
//		System.out.println(p1.no);

		node p = head;

		while(p.next != p){ //只剩最后一个元素

			for(int i = 1; i < m-1;i++){
				p = p.next;
			}
			//出循环后 p 指向 叫出m 的 前一个节点
			System.out.println("淘汰  "+p.next.no);
			p.next = p.next.next;
			p = p.next;
		}

		System.out.println("最后一个  "+p.no);

		return 0;
	}
}
