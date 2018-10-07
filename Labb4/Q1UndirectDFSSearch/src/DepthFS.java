
/**
 * @author michelouadria
 *
 */
public class DepthFS {

	private boolean[] markedVertex;
	private int CountOfEachMarked;
	
	public DepthFS(UndirectedGraph G, int s) 
	{
		markedVertex = new boolean[G.getV()];
		dfs(G,s);
	}

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
