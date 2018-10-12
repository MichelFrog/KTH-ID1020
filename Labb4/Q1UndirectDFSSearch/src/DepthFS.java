
/**
 * Implementation of depth first search.
 * @author michelouadria
 *
 */
public class DepthFS {

	private boolean[] markedVertex;
	private int CountOfEachMarked;
	
	/* Constructor that creates a new instance of markedVertex 
	 * with the size of all possible vertices of the G. 
	 * Then performs depth first search.
	 * 
	 * @param G The graph to be searched
	 * @param s Source/starting vertex of the graph.
	 */
	public DepthFS(UndirectedGraph G, int s) 
	{
		markedVertex = new boolean[G.getV()];
		dfs(G,s);
	}

	/*
	 * A depth first search which find a possible path from the starting
	 * point.
	 * @param G The graph to be searched
	 * @param vertex The point of which the dfs starts form.
	 */
	private void dfs(UndirectedGraph G, int vertex) 
	{

		markedVertex[vertex] = true;
		CountOfEachMarked++;
		for(int nextVertex : G.adj(vertex)) 
		{
			if(!markedVertex[nextVertex])
				
				dfs(G, nextVertex);	//recursive go to the next unmarked vertex
		}
	}
	
	public boolean markedVertex(int nextVertexInBag) {
		return markedVertex[nextVertexInBag];
	}
	
	public int CountOfEachMarked() {return CountOfEachMarked;}
}
