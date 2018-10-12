package Question2;

public class DirectedDFS {

	private boolean[] markedVertex;
	
	/* Find vertices in G that are reachable from s*/
	public DirectedDFS(Digraph G, int start) {
		markedVertex = new boolean[G.getV()];
		dfs(G,start);
	}
	
	/* Find vertices in G that are reachable from sources*/
	public DirectedDFS(Digraph G, Iterable<Integer> sources) {
		markedVertex = new boolean[G.getV()];
		for( int start : sources)
			if(!markedVertex[start])
				dfs(G,start);
	}
	
	public void dfs(Digraph G, int v) {
		markedVertex[v] = true;
		for(int w: G.adj(v))
			if (!markedVertex[w]) 
				dfs(G, w);
	}
	public boolean getMarked(int v) { return markedVertex[v ]; }
}
