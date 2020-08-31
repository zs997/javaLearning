package cn.zs.practice.graph;

public class Edge implements Comparable<Edge>{
	public int from;
	public int to;
	public int weight;
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public Edge(){}

	@Override
	public int compareTo(Edge arg0) {
		if(this.weight >= arg0.weight){
			return 1;
		}else{
			return -1;
		}	
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}
	
	
	
}
