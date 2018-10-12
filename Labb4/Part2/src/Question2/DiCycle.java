package Question2;
/**
 * 
 * @param edgeTo Int array of all vertices that are adjacent
 * @param markedVertex Boolean array of all the marked, visited, vertices
 * @param cycle Stack of Integers that shows 
 * @param onStack Boolean array that checks whethers or not the vertex is 
 * on the stack, i.e part of the cycle
 * @author michelouadria
 *
 */
public class DiCycle {
	private boolean[] markedVertex;
	private int[] edgeTo;
	private LIFO_Stack<Integer> cycle;
	private boolean[] onStack;

	public DiCycle(Digraph G) {
		onStack = new boolean[G.getV()];
		edgeTo = new int[G.getV()];
		markedVertex = new boolean[G.getV()];
		for (int v = 0; v < G.getV(); v++) {
			if (!markedVertex[v])
				dfs(G, v);
		}
	}

	/*
	 * First, check adjacent to the starting vertex source
	 * 
	 */
	private void dfs(Digraph G, int v) {
		onStack[v] = true;
		markedVertex[v] = true;
		for (int nextVertex : G.adj(v)) 
			if (this.hasCycle()) {
				return;
			} else if (!markedVertex[nextVertex]) {
				edgeTo[nextVertex] = v;
				dfs(G, nextVertex);
			} 
			else if (onStack[nextVertex]) 
				{
				cycle = new LIFO_Stack<Integer>();
				for (int x = v; x != nextVertex; x = edgeTo[x]) {
					cycle.push(x);
				}
				cycle.push(nextVertex);
				cycle.push(v);
			}
			onStack[v] = false;
		}


	public boolean hasCycle() {
		return cycle != null;
	}

	public Iterable<Integer> cycle() {
		return cycle;
	}
}
