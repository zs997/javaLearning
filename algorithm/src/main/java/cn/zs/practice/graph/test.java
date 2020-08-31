package cn.zs.practice.graph;

public class test {
	public static void main(String[] args) {
//		int nodes_num = 5;
//		int [] vertex = {0,1,2,3,4};
//		int [][] matrix = {{0,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,6},
//								{9,0,3,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
//								{2,Graph.MAX_WEIGHT,0,5,Graph.MAX_WEIGHT},
//								{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,0,1},
//								{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,0}
//								};

		//最短路径数据
		//最小生成树数据
//		int nodes_num = 9;
//		int [] vertex = {0,1,2,3,4,5,6,7,8};

		//最小生成树数据
//		int [][] matrix = {{0,10,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,11,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
//		{10,0,18,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,16,Graph.MAX_WEIGHT,12},
//		{Graph.MAX_WEIGHT,18,0,22,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,8},
//		{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,22,0,20,Graph.MAX_WEIGHT,24,16,21},
//		{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,20,0,26,Graph.MAX_WEIGHT,7,Graph.MAX_WEIGHT},
//
//		{11,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,26,0,17,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
//		{Graph.MAX_WEIGHT,16,Graph.MAX_WEIGHT,24,Graph.MAX_WEIGHT,17,0,19,Graph.MAX_WEIGHT},
//		{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,16,7,Graph.MAX_WEIGHT,19,0,Graph.MAX_WEIGHT},
//		{Graph.MAX_WEIGHT,12,8,21,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
//		};


		//最短路径数据
//		int [][] matrix = {{0,1,5,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
//		{1,0,3,7,5,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
//		{5,3,0,Graph.MAX_WEIGHT,1,7,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
//		{Graph.MAX_WEIGHT,7,Graph.MAX_WEIGHT,0,2,Graph.MAX_WEIGHT,3,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
//
//		{Graph.MAX_WEIGHT,5,1,2,0,3,6,9,Graph.MAX_WEIGHT},
//
//		{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,7,Graph.MAX_WEIGHT,3,0,Graph.MAX_WEIGHT,5,Graph.MAX_WEIGHT},
//
//		{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,3,6,Graph.MAX_WEIGHT,0,2,7},
//		{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,9,5,2,0,4},
//		{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,7,4,0},
//		};



//		拓扑排序数据
		int nodes_num = 6;
		int [] vertex = {0,1,2,3,4,5};
		//拓扑排序数据
		int [][] matrix = {{0,1,1,1,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
				{Graph.MAX_WEIGHT,0,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT},
				{Graph.MAX_WEIGHT,1,0,Graph.MAX_WEIGHT,1,Graph.MAX_WEIGHT},
				{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,0,1,Graph.MAX_WEIGHT},


				{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,0,Graph.MAX_WEIGHT},

				{Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,Graph.MAX_WEIGHT,1,1,0}
		};

		Graph G = new Graph(nodes_num,vertex,matrix);
//		System.out.println(G.getOutDegree(4));
//		System.out.println(G.getInDegree(4));
//		System.out.println(G.getWeight(0, 4));
//		System.out.println(G.getNextNeighbor(1, 0));
//		G.depthSearchNon();
//		G.dijkstra(0);
//		G.broadSearch(1);
		G.topologySort();
	}
}
