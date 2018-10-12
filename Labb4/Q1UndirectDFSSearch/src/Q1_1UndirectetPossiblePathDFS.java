import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main for implementation of depth first search. 
 * String represents the adress to be used in file.
 * Uses a symbol graph to allow for fetching name of string.
 * @author michelouadria
 *
 */
public class Q1_1UndirectetPossiblePathDFS {


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

		DFP SearchShortest = new DFP(G, bagValueOfX);

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