package Question3;

/**
 * Implementation of topological sort that uses a Digraph
 * 
 * @param Order allows for iteration of the stack in DFO. 
 * @author michelouadria
 */
public class Q2_3Topological {

	private Iterable<Integer> order;
	
	/*
	 * Topological sort is fetched if the Digraph is a DAG.  
	 * 
	 * @param G Directed graph.
	 */
	public Q2_3Topological(Digraph G) 
	{
		DiCycle findCycle = new DiCycle(G);
		if(!findCycle.hasCycle())
		{
			DFO dfo = new DFO(G);
			order = dfo.reversePost();
		}
	}
	
	public Iterable<Integer> getOrder(){return order;	}
	
	public boolean doesItContainDirectCycles() { return order == null; }
}
