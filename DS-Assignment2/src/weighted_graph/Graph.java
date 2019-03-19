package weighted_graph;

import java.util.List;

public interface Graph
{
	boolean isConnected();

	List<Node> reachable(int a);
	
	void mst();
	
	List<Node> shortestPath(int a, int b);
}
