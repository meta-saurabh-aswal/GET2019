package weighted_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphImpl implements Graph
{	
	int size;
	Map<Integer, Node> vertices = null;
	ArrayList <Edge> edges = null;
	boolean [][] adj = new boolean[size][size];
	
	public void totalVertices(int size)
	{
		this.size = size;
	}
	
	void addEdge(int weight, int src, int dest)
	{
		edges.add(new Edge(weight, src, dest));
		adj[src][dest] = true;
	}
	
	
	@Override
	public boolean isConnected()
	{
		return false;
	}

	@Override
	public List<Node> reachable(int a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Node> shortestPath(int a, int b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void mst() {
		// TODO Auto-generated method stub
		
	}

	
	
}
