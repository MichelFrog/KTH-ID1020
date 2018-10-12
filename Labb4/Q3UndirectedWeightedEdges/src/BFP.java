public class BFP {
	private boolean[] markedVertex;
	private int[] edgeTo;
	private final int start;

	public BFP(UndirectedGraph G, int newStart) {
		markedVertex = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		this.start = newStart;
		bfs(G, start);
	}

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
