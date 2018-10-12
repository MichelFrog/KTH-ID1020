package Question1;

/**
 * Implementation of a direct depth first search to 
 * @author michelouadria
 *
 */
public class Q2_1DirectedDFS {

	private boolean[] markedVertex;
	
	/* Find vertices in G that are reachable from start
	 * @param G The graph to be searched
	 * @param start The start of the search.*/
	public Q2_1DirectedDFS(Digraph G, int start) {
		markedVertex = new boolean[G.getV()];
		dfs(G,start);
	}
	
	public void dfs(Digraph G, int v) {
		markedVertex[v] = true;
		for(int w: G.adj(v))
			if (!markedVertex[w]) 
				dfs(G, w);
	}
	public boolean getMarked(int v) { return markedVertex[v]; }
}


