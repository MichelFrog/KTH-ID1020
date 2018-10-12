package Question3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
/*
 * Implementation of a symbol graph. The SG builds a graph from a file and creates
 * a string array which allows for each vertex to be based upon a String rather
 * than an integer.
 * @author michelouadria
 */
public class SG {
    private ST<String, Integer> st;  
    private String[] keys;           
    private Digraph graph;

    
    public SG(File adress, String delimiter) throws FileNotFoundException {
        st = new ST<String, Integer>();



        Scanner input = new Scanner(adress);
        while (input.hasNextLine()) {
            String[] a = input.nextLine().split(delimiter);
            for (int i = 0; i < a.length; i++) {
                if (!st.contains(a[i]))
                    st.put(a[i], st.size());
            }
        }

        keys = new String[st.size()];
        Iterator<String> iterator = st.iterator();
        while (iterator.hasNext()) {
        	 	String name = (String) iterator.next();
            keys[st.get(name)] = name;
        }

        // builds the graph by connecting first vertex on each
        // line to all others
        graph = new Digraph(st.size());
        input = new Scanner(adress);
        while (input.hasNextLine()) {
            String[] a = input.nextLine().split(delimiter);
            int v = st.get(a[0]);
            for (int i = 1; i < a.length; i++) {
                int w = st.get(a[i]);
                graph.addEdge(v, w);
            }
        }
    }


    public boolean contains(String s) {
        return st.contains(s);
    }

 

    @Deprecated
    public int index(String s) {
        return st.get(s);
    }

    //Get index of a string
    public int indexOf(String s) {
        return st.get(s);
    }

    @Deprecated
    public String name(int v) {
        validateVertex(v);
        return keys[v];
    }

    //Return the name of the string
    public String nameOf(int v) {
        validateVertex(v);
        return keys[v];
    }

    
    @Deprecated
    public Digraph G() {
        return graph;
    }


    public Digraph graph() {
        return graph;
    }
    
    public String toStringAllVertices() 
    {
		String vertex = keys.length + " vertices" + "\n";
		for (int v = 0; v < keys.length; v++) {
			vertex += v;
			vertex += "["+ keys[v] + "]";
			vertex += ", ";
			if(0==v%3) {vertex += "\n";}
		}
		return vertex;
    	
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        int V = graph.getV();
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("None existing " + v);
    }


}