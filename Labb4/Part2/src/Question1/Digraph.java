package Question1;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Scanner;

/**
 * @author michelouadria
 *
 */
public class Digraph {

	private final int V;
	private int edge;
	private Bag<Integer>[] adjList; // list of each adjacent node with no order, hence bag.

	public Digraph(int vertex) {
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
		edge++;
	}
	
	public Digraph reverseGraph()
	{
		Digraph Reversed = new Digraph(V);
		for(int v = 0; v < V; v++) {
			for(int nextV: adj(v)) {
				Reversed.addEdge(v, nextV);
				}
		}
		return Reversed;
		
	}

	public Iterable<Integer> adj(int v) {
		return adjList[v];
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
