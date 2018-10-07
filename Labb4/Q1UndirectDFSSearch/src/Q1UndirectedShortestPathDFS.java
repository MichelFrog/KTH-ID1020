import java.util.Scanner;

/**
 * @author michelouadria
 *
 */
public class Q1UndirectedShortestPathDFS {

	private final static int numberOfVertices = 6;

	public static void main(String[] args)
	   {
		  Scanner input = new Scanner(System.in);
		
		  UndirectedGraph G = new UndirectedGraph(numberOfVertices);
		  G.addEdge(1,2);
		  G.addEdge(2,2);
		  G.addEdge(1,3);
		  G.addEdge(3,5);
		  G.addEdge(4,1);
		  
		  System.out.println(G.toStringAllPossibleVertices());
		  System.out.println("Pick as starting vertex from the vertices above: ");
		  int x = input.nextInt();
		  System.out.println("To which vertex do you want to find shortest path?");
		  int y = input.nextInt();
		  input.close();
		  
		  DFP SearchShortest = new DFP(G, x);
		  
		  for(int i = 0; i < G.getV();i++) {
			  System.out.println("Find path from " + x + " to " + y);
			  if(SearchShortest.hasPathTo(y)){
					  for(int X : SearchShortest.pathTo(y)) 
					  {
						  if(X == x)
							  System.out.println(X);
						  else
							  System.out.println("-" + x);
					  }
			  }
		  }
	}
}
