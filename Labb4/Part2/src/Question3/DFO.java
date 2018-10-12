package Question3;
/**
 * 
 * @param markedVertex A boolean array of each marked vertex in the graph
 * @param preV Queue of the order after performing a depth first search.
 * @param postV Queue of the order in descending 
 * @param reversePost Stack of of all the nodes, will be the final topological order of the vertices.
 * @author michelouadria
 *
 */
public class DFO {
    private boolean[] markedVertex;
    private Queue<Integer> preV;
    private Queue<Integer> postV;
    private LIFO_Stack<Integer> reversePost;

    /*
     * Initialize field variables.
     * Loops through all the available vertices and checks
     * whether a vertex is not marked. If so, put it through DFS with said vertex.
     */
    public DFO(Digraph G) 
    {
        preV = new Queue<Integer>();
        postV = new Queue<Integer>();
        reversePost = new LIFO_Stack<Integer>();
        markedVertex = new boolean[G.getV()];
        for (int v = 0; v < G.getV(); v++)
            if (!markedVertex[v])
                dfs(G, v);
    }

    /*
     * Queue each vertex that isn't marked and marked it. 
     * Checks each adjacent node, if it isnt marked do a recursive
     * call to same function with a that node. Repeat till all nodes are marked.
     * 
     */
    private void dfs(Digraph G, int v) 
    {
        preV.enqueue(v);
        markedVertex[v] = true;
        for (int w : G.adj(v))
            if (!markedVertex[w])
                dfs(G, w);
        postV.enqueue(v);
        reversePost.push(v);
    }

    public Iterable<Integer> pre() {
        return preV;
    }

    public Iterable<Integer> post() {
        return postV;
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}