import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author michelouadria
 *
 */
public class UndirectedGraph {

	private final int V;
	private int edge;
	private Bag<Integer>[] adjList; // list of each adjacent node with no order, hence bag.

	public UndirectedGraph(int vertex) {
		this.V = vertex;
		this.edge = 0;
		adjList = (Bag<Integer>[]) new Bag[V];
		for (int vi = 0; vi < vertex; vi++) {
			adjList[vi] = new Bag<Integer>();
		}
	}


	public int getV() {
		return V;
	}

	public int getEdge() {
		return edge;
	}

	public void addEdge(int vertex, int nextVertex) {
		adjList[vertex].add(nextVertex);
		adjList[nextVertex].add(vertex);
		edge++;

	}

	public Iterable<Integer> adj(int v) {
		return adjList[v];
	}


	public static int degree(UndirectedGraph G, int v) {

		int degree = 0;
		for (int w : G.adj(v))
			degree++;
		return degree;
	}

	public static int maxDegree(UndirectedGraph G) {
		int max = 0;
		for (int v = 0; v < G.getV(); v++)
			if (degree(G, v) > max)
				max = degree(G, v);
		return max;
	}

	public static int avgDegree(UndirectedGraph G) {
		return 2 * G.getEdge() / G.getV();
	}

	public static int numberOfSelfLoops(UndirectedGraph G) {
		int count = 0;
		for (int v = 0; v < G.getV(); v++)
			for (int w : G.adj(v))
				if (v == w)
					count++;
		return count / 2; // each edge counted twice
	}

	public String toString() {
		String s = V + " vertices, " + edge + " edges\n";
		for (int v = 0; v < V; v++) {
			s += v + ": ";
			for (int w : this.adj(v))
				s += w + " ";
			s += "\n";
		}
		return s;
	}

	public String toStringAllPossibleVertices() {
		String s = V + " vertices" + "\n";
		for (int v = 0; v < V; v++) {
			s += v;
			s += ", ";
		}
		return s;
	}

}
