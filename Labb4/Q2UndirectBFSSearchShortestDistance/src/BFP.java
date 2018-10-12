

/**
 * Implementation of breadth first search.
 * 
 * @param markedVertex Boolean array of all marked vertices within a graph
 * @param edgeTo Int array of all the vertices that are edge to the source.
 * @param start The starting point of the graph
 * 
 * @author michelouadria
 *
 */
public class BFP {
	private boolean[] markedVertex;
	private int[] edgeTo;
	private final int start;

	/* Constructor for Breadth first search.
	 * @param G The graph to the searched
	 * @param newStart The starting point of the graph
	 */
	public BFP(UndirectedGraph G, int newStart) {
		markedVertex = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		this.start = newStart;
		bfs(G, start);
	}
	/*
	 * @param G The graph to be searched
	 * @param s The starting point of the search
	 */
	private void bfs(UndirectedGraph G, int s) {
		Queue<Integer> queue = new Queue<Integer>();
		markedVertex[s] = true;
		queue.enqueue(s);
		while (!queue.isEmpty()) {
			int v = queue.dequeue();
			for (int w : G.adj(v))
				if (!markedVertex[w]) {
					 edgeTo[w] = v;					
					 markedVertex[w] = true;
					queue.enqueue(w);
				}
		}
	}

	public boolean hasPathTo(int v) {
		return markedVertex[v];
	}

	public Iterable<Integer> pathTo(int y) {
		if (!hasPathTo(y)) {
			System.out.println("There's no path to the node.");

			return null;
		}
		LIFO_Stack<Integer> path = new LIFO_Stack<Integer>();
		for (int x = y; x != start; x = edgeTo[x])
			path.push(x);
		path.push(start);
		return path;
	}
}
