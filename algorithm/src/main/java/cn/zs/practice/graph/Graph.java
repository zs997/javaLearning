package cn.zs.practice.graph;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int nodes_num; //顶点数量
	public static final int MAX_WEIGHT= 100;
	public static final int MAX = 100;
	private int [] vertex; //顶点数组
	private int [][] matrix; //矩阵
	private boolean [] isVisited;

	private List<Edge> edges = new ArrayList<>();


	public Graph(){}

	public Graph(int nodes_num){
		this.nodes_num = nodes_num;
		vertex = new int [nodes_num];
		matrix = new int [nodes_num][nodes_num];

	}

	public Graph(int nodes_num,int [] vertex,int [][] matrix){
		this.nodes_num = nodes_num;
		this.vertex = vertex;
		this.matrix = matrix;
		isVisited = new boolean [nodes_num];//默认初始化为false
	}

	/**
	 * 拓扑排序
	 * topologySort
	 *
	 * */
	public void topologySort() {
		//计算入度
		int inDegree [] = new int [nodes_num];
		for(int i = 0 ; i <nodes_num; i++){
			inDegree[i] = getInDegree(i);
		}
		//输出各节点的入度
		System.out.println("**************");
		for(int i : inDegree){
			System.out.println(i);
		}
		System.out.println("*************");
		//将入度为0的节点入队列
		LinkedList<Integer> queue = new LinkedList<>();
		for(int i = 0; i < inDegree.length; i++){
			if(inDegree[i] == 0){
				queue.add(i);
			}
		}

		while(!queue.isEmpty()){

			int out = queue.poll();

			System.out.println(out);

			for(int i = 0; i < nodes_num; i++){
				if((matrix[out][i] != 0)&&(matrix[out][i] != MAX_WEIGHT)){
					inDegree[i]--;
					if(inDegree[i] == 0){
						queue.add(i);
					}
				}
			}

		}


	}
	/**
	 * dijkstra
	 * 最短路径
	 * */
	public void dijkstra(int source){
		boolean found []  = new boolean [nodes_num];
		int minlength [] = new int [nodes_num];
		ArrayList<ArrayList<Integer>> routing = new ArrayList<ArrayList<Integer>>();
		for(int i = 0;i < nodes_num; i++ ){
			routing.add(new ArrayList<Integer>());
		}


		found[source] = true;
		//初始化
		for(int i = 0; i <nodes_num; i++){
			routing.get(i).add(source);
			minlength [i] = matrix[source][i];
		}

		for(int j = 1;j < nodes_num ; j++){
			int minIndex = foundMinIndex(minlength,found);
			found [minIndex] = true;
			for(int i = 0; i<nodes_num; i++){
				if(minlength[i] > minlength[minIndex]+matrix[minIndex][i]){

					routing.get(i).clear();
					//同时修改了
					ArrayList<Integer> new_rout = new ArrayList<Integer>();
					ArrayList<Integer> temp = routing.get(minIndex);

					for(int data : temp){
						new_rout.add(data);
					}

//						ArrayList<Integer> new_rout = new;
					new_rout.add(minIndex);


					routing.set(i, new_rout);
					minlength[i] = minlength[minIndex]+matrix[minIndex][i];
				}
			}
		}
		for(int i =0; i< minlength.length; i++){
			System.out.println(i+"*******"+minlength[i]);
		}

		for(int i = 0;i < routing.size();i++){
			ArrayList<Integer> arr = routing.get(i);
			for(Integer point : arr){
				System.out.print(point+"->");
			}
			System.out.println(i);
		}


	}


	private int foundMinIndex(int minlength [], boolean found []){
		int min = MAX_WEIGHT;
		int minIndex = -1;
		for(int i = 0; i<minlength.length; i++){
			if((minlength[i] < min)&&(found[i] == false)){
				minIndex = i;
				min = minlength[i];
			}
		}
		return minIndex;
	}

	/**kruskal
	 * 最小生成树
	 * */

	private void union(int [] group, int boss, int employee){
		while(boss != group[boss]){
			boss = group[boss];
		}

		while(employee != group[employee]){
			employee = group[employee];
		}

		for(int i = 0; i<group.length; i++){
			if(group[i] == employee){
				group[i] = boss;
			}
		}
	}

	public boolean isTogether(int [] group, int i, int j){
		while(i != group[i]){
			i = group[i];
		}

		while(j != group[j]){
			j = group[j];
		}

		return i==j;
	}

	/**
	 * kruskal 最小生成树 算法
	 * */
	public void kruskal(){

		//初始化每个点的所属集合 每个点属于自己的集合
		int [] group = new int [nodes_num];
		for(int i = 0;i < nodes_num; i++){
			group[i] = i;
		}
		//用邻接矩阵初始化 边对象数组
		int weight = 0;
		int from = 0;
		int to = 0;
		for(int i = 0; i < nodes_num; i++){
			for(int j = i+1; j<nodes_num; j++){
				if(matrix[i][j] != MAX_WEIGHT){
					weight = matrix[i][j];
					from = i;
					to = j;
					edges.add(new Edge(from, to, weight));
				}
			}
		}
		//将 对象集合排序
		Collections.sort(edges);

		System.out.println("输出边序列");
		for(Edge e :edges){
			System.out.println(e);
		}
		System.out.println("输入最小生成树的边");


		//拿出nodes_num-1 条边
		for(int i = 1;i < nodes_num; i++){
			Edge e = edges.remove(0);
			//两边不属于一个集合
			if(!isTogether(group, e.from, e.to)){
				System.out.println(e.from +" "+ e.to);
				union(group, e.from, e.to);
			}

		}





	}



	/**
	 * prim 最小生成树
	 * */
	public void prim(){
		int lowcost [] = new int [nodes_num];
		int edge [] = new int [nodes_num];


		//初始化
		for(int i = 0;i <nodes_num ; i++){

			//默认0在树中 其他点 到 树的距离
			lowcost[i] = matrix[i][0];

			if(lowcost[i] == MAX_WEIGHT){
				edge[i] = -1;
			}else{
				edge[i] = 0;
			}
		}

		for(int i = 1;i<nodes_num; i++){

			int min = MAX_WEIGHT;
			int minIndex = -1;
			for(int j = 0;j < nodes_num; j++){
				//不在树中
				if((lowcost[j] != 0)&&(lowcost[j] < min)){
					minIndex = j;
					min = lowcost[j];
				}
			}

			//将对应边输出
			System.out.println(minIndex+" "+edge[minIndex]);

			//将最小的点加入树中
			lowcost[minIndex] = 0;

			//更新lowcost edge
			for(int k = 0; k<nodes_num; k++){

				if((lowcost[k] != 0)&&(matrix[k][minIndex] < lowcost[k])){
					lowcost[k] = matrix[k][minIndex] ;
					edge[k] = minIndex;
				}
			}


		}




	}



	//非递归实现
	public void broadSearchNon(){
//		boolean [] isVisited = new boolean [nodes_num];
//		LinkedList<Integer> queue = new LinkedList<Integer>();

		for(int i = 0;i<nodes_num;i++){
			System.out.println("第"+(i+1)+"次搜索");
			broadSearchNon(i);
			System.out.println("*******************");
		}



	}
	/**从某一点开始的广度优先搜
	 * */
	public void broadSearchNon(int index){

		if(isVisited[index] == true){
			return ;
		}
//		isVisited[index] == true;

		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.addLast(index);
		while(!queue.isEmpty()){
			int temp = queue.remove(0);
			System.out.println("访问到了第"+temp+"节点");
			isVisited[temp] = true;
			int Neighbor = getFirstNeighbor(temp);
			while(Neighbor != -1){
				if(isVisited[Neighbor] == false){
					queue.addLast(Neighbor);
				}

				Neighbor = getNextNeighbor(temp, Neighbor);
			}
		}

	}
	//非递归实现
	public void depthSearchNon(){
//		boolean [] isVisited = new boolean [nodes_num];
//		LinkedList<Integer> queue = new LinkedList<Integer>();

		for(int i = 0;i<nodes_num;i++){
			System.out.println("第"+(i+1)+"次搜索");
			depthSearchNon(i);
			System.out.println("*******************");
		}



	}

	public void depthSearchNon(int index){
		if(isVisited[index] == true){
			return ;
		}
//		isVisited[index] == true;

		LinkedList<Integer> stack = new LinkedList<Integer>();
		stack.push(index);;
		while(!stack.isEmpty()){
			int temp = stack.pop();
			System.out.println("访问到了第"+temp+"节点");
			isVisited[temp] = true;
//			int Neighbor = getFirstNeighbor(temp);
//			while(Neighbor != -1){
//				if(isVisited[Neighbor] == false){
//					stack.addLast(Neighbor);
//				}
//
//				Neighbor = getNextNeighbor(temp, Neighbor);
//			}
			for(int i = nodes_num-1; i>=0;i--){
				if((matrix[temp][i] != MAX_WEIGHT)&&(matrix[temp][i] != 0)){
					if((isVisited[i] == false)&&(! stack.contains(i))){
						stack.push(i);
					}
				}
			}

		}
	}

	//递归实现
	public void depthSearch(){
		for(int i = 0;i<nodes_num;i++){
			System.out.println("第"+(i+1)+"次搜索");
			depthSearch(i);
			System.out.println("*******************");
		}
	}
	//递归实现
	private void depthSearch(int index){

		if(isVisited[index] == true){
			return ;
		}
		isVisited[index] = true;
		System.out.println("搜到了"+vertex[index]);
		for(int i = 0;i<nodes_num; i++){
			if((isConnected(index, i))&&(isVisited[i]==false)){
				depthSearchModify(i);
			}
		}


	}

	//递归实现 改进
	private void depthSearchModify(int index){

		if(isVisited[index] == true){
			return ;
		}
		isVisited[index] = true;
		System.out.println("搜到了"+vertex[index]);
		int neighbor = getFirstNeighbor(index);

		while((neighbor != -1)){
			if(isVisited[neighbor] == false){
				depthSearch(neighbor);
			}

			neighbor = getNextNeighbor(index, neighbor);
		}



//		for(int i = 0;i<nodes_num; i++){
//			if((isConnected(index, i))&&(isVisited[i]==false)){
//				depthSearch(i);
//			}
//		}


	}

	public int getNextNeighbor(int index,int base){
		if(index<0||index>=nodes_num){
			return -1;
		}
		if(base<0||(base+1)>=nodes_num){
			return -1;
		}

		int neighbor = base+1;
		while((matrix[index][neighbor]==0)||(matrix[index][neighbor]==MAX_WEIGHT)){
			neighbor++;
			if(neighbor ==nodes_num){
				break;
			}

		}

		if(neighbor == nodes_num){
			return -1;
		}
		return neighbor;

	}
	public int getFirstNeighbor(int index){
		if(index<0||index>=nodes_num){
			return -1;
		}
		int neighbor = 0;
		while((matrix[index][neighbor]==0)||(matrix[index][neighbor]==MAX_WEIGHT)){
			neighbor++;
			if(neighbor ==nodes_num){
				break;
			}

		}

		if(neighbor == nodes_num){
			return -1;
		}
		return neighbor;

	}

	public boolean isConnected(int v1,int v2){
		if(v1<0||v1>=nodes_num)
			return false;
		if(v2<0||v2>=nodes_num)
			return false;
		return matrix[v1][v2]==MAX_WEIGHT?false:(matrix[v1][v2]==0?false:true);
	}

	/**获取两点之间的权值
	 * @param int v1 int v2  两个点
	 * */
	public int getWeight(int v1,int v2){
		if(v1<0||v1>=nodes_num)
			return -1;
		if(v2<0||v2>=nodes_num)
			return -1;
		return matrix[v1][v2]==MAX_WEIGHT?-1:matrix[v1][v2];
	}

	/**给定节点计算入度
	 * @param int index 指定节点
	 * */
	public int getInDegree(int index){
		int count  = 0;
		int row =0;
		while(row<nodes_num){
			if((matrix[row][index] != 0)&&(matrix[row][index] != Graph.MAX_WEIGHT)){
				count ++;
			}
			row ++;
		}
		return count;
	}

	/**给定节点计算出度
	 * @param int index 指定节点
	 * */
	public int getOutDegree(int index){
		int count  = 0;
		int colunm =0;
		while(colunm<nodes_num){
			if((matrix[index][colunm] != 0)&&(matrix[index][colunm] != Graph.MAX_WEIGHT)){
				count ++;
			}
			colunm ++;
		}
		return count;
	}





	public int getNodes_num() {
		return nodes_num;
	}

	public void setNodes_num(int nodes_num) {
		this.nodes_num = nodes_num;
	}

	public int[] getVertex() {
		return vertex;
	}

	public void setVertex(int[] vertex) {
		this.vertex = vertex;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void setMatrix(int[][] matrix) {
		this.matrix = matrix;
	}



}
