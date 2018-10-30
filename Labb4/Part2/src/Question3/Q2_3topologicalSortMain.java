package Question3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Main for the topological sort.
 * 
 * @author michelouadria
 *
 */
public class Q2_3topologicalSortMain  {

	public static void main(String[] args) throws FileNotFoundException {
		String theGraph = "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb4/smallDB.txt";
		File txtFile = new File(theGraph);
		String line = "-";

		SG sg = new SG(txtFile, line);
		Digraph G = sg.graph();

		System.out.println(sg.toStringAllVertices());


		Q2_3Topological topGraph = new Q2_3Topological(G);
		int counter = 0;
		if(!topGraph.doesItContainDirectCycles()) {
		for(int vertex : topGraph.getOrder()) 
		{
		    counter++;
		    System.out.print(sg.nameOf(vertex));
		    if(counter != G.getV()){
		          System.out.print("->");
		    }
		}

        System.out.println();
		}
		
	}
}