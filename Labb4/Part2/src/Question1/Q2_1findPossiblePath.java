package Question1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main for Depth first search to find any path between the two.Either from X to Y or Y to X.
 * @author michelouadria
 *
 */
public class Q2_1findPossiblePath {


	public static void main(String[] args) throws FileNotFoundException {
		String theGraph = "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb4/Graph.txt";
		File txtFile = new File(theGraph);
		String blank = " ";

		SG sg = new SG(txtFile, blank);
		Digraph G = sg.graph();

		System.out.println(sg.toStringAllVertices());

		Scanner in = new Scanner(System.in);
		System.out.println("Pick a starting vertex from the vertices above: ");
		String x = in.next();
		int bagValueOfX = sg.indexOf(x);
		System.out.println("To which vertex do you want to find shortest path?");
		String y = in.next();
		int bagValueOfY = sg.indexOf(y);
		in.close();

		Q2_1DirectedDFS path = new Q2_1DirectedDFS(G, bagValueOfX);
		Q2_1DirectedDFS path2 = new Q2_1DirectedDFS(G, bagValueOfY);
		
		if(path.getMarked(bagValueOfY)) 
		{System.out.println("Is there a path between the two points? " + path.getMarked(bagValueOfY));}
		else if (path2.getMarked(bagValueOfX))
	      {System.out.println("Is there a path between the two points? " + path2.getMarked(bagValueOfX));}
		else
			System.out.println("No path");
	}
}