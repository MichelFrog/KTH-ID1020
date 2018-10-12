package Question2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author michelouadria
 *
 */
public class Q2_2checkForDirectedCycle  {

	public static void main(String[] args) throws FileNotFoundException {
		String theGraph = "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb4/Graph.txt";
		File txtFile = new File(theGraph);
		String blank = " ";

		SG sg = new SG(txtFile, blank);
		Digraph G = sg.graph();

		System.out.println(sg.toStringAllVertices());


		DiCycle graph = new DiCycle(G);
		
		
		if(graph.hasCycle()) 
		{
	            System.out.print("Directed cycle: ");
	            for (int v : graph.cycle()) {
	                System.out.print(v + " ");
	            }
	            System.out.println();
	     }
		else {System.out.println("No cycles present.");}
		
		
        System.out.println();

        
		String withCycle = "/Users/michelouadria/Documents/GitHub/KTH-ID1020/Labb4/GraphWithCycles.txt";
		File txt = new File(withCycle);
		String delim = " ";

		SG SG = new SG(txt, delim);
		Digraph Graph = SG.graph();
		
		System.out.println(SG.toStringAllVertices());
		
		DiCycle directCycle = new DiCycle(Graph);
		
		
		if(directCycle.hasCycle()) 
		{
	            System.out.print("Directed cycle: ");
	            for (int v : directCycle.cycle()) {
	                System.out.print(SG.nameOf(v) + " ");
	            }
	            System.out.println();
	     }
		else {System.out.println("No cycles present.");}
		
	}
}