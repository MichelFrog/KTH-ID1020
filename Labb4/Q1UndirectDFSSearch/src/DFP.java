
public class DFP {
	private boolean[] markedVertex;
	private int[] edgeTo;
	private final int start;
	
	public DFP(UndirectedGraph G, int startingVertex)
	{
	   markedVertex = new boolean[G.getV()];
	   edgeTo = new int[G.getV()];
	   this.start = startingVertex;
	   dfs(G, startingVertex);
	}
	
	public void dfs(UndirectedGraph G, int vertex) 
	{
		markedVertex[vertex] = true;
		for (int nextVertex : G.adj(vertex)) 
		{
			if (!markedVertex[nextVertex])
			{
				edgeTo[nextVertex] = vertex;
				dfs(G, nextVertex);
			}
		}
	}
	
	public boolean hasPathTo(int y) { return markedVertex[y]; }
	
	public Iterable<Integer> pathTo(int y)
	{
	        if (!hasPathTo(y)) { 
		        System.out.println("There's no path to the node.");		

		        return null;
	        }
	        LIFO_Stack<Integer> path = new LIFO_Stack<Integer>();
	        for (int x = y; x != start; x = edgeTo[x])
	           path.push(x);
	        path.push(start);
	        return (Iterable<Integer>) path;
	}
}
