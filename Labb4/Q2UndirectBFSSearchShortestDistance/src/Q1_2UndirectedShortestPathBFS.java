import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main for implementation of a breadth first search that finds the shortest path from a graph.
 * The graph is built from a database and relies on Symbol Graph to allow storing strings in a 
 * 
 * @author michelouadria
 *
 */
public class Q1_2UndirectedShortestPathBFS {

	private final static int numberOfVertices = 6;

	public static void main(String[] args) throws FileNotFoundException {
		String theGraph = "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb4/Graph.txt";
		File txtFile = new File(theGraph);
		String blank = " ";

		SG sg = new SG(txtFile, blank);
		UndirectedGraph G = sg.graph();

		System.out.println(sg.toStringAllVertices());

		Scanner in = new Scanner(System.in);
		System.out.println("Pick as starting vertex from the vertices above: ");
		String x = in.next();
		int bagValueOfX = sg.indexOf(x);
		System.out.println("To which vertex do you want to find shortest path?");
		String y = in.next();
		int bagValueOfY = sg.indexOf(y);
		in.close();

		BFP SearchShortest = new BFP(G, bagValueOfX);

		if (SearchShortest.hasPathTo(bagValueOfY)) {
			System.out.println();
			System.out.print(x + " to " + y + ": ");

			for (int X : SearchShortest.pathTo(bagValueOfY)) {

				if (X == bagValueOfX)
					System.out.print(sg.nameOf(X));
				else
					System.out.print("-" + sg.nameOf(X));
			}
		}
	}
}