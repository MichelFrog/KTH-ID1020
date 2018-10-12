
public class Edge implements Comparable<Edge> {

	private final int v;
	private final int w;
	private final int weightOfVector;
	
	public Edge(int v, int w, int weight) {
		this.v = v;
		this.w = w;
		this.weightOfVector = weight;
	}
	
	public int getWeight() { return weightOfVector; }
	public int eitherOfTheVertices() {return v; }
	public int otherOfTheVertices(int vertex) 
	{
		if (vertex == v) 
			return w;
		else if(vertex == w) 
			return v; 
		else
			throw new RuntimeException("Vertex is wrong");
	}
	
	
	@Override
	public int compareTo(Edge that) {
		if      (this.getWeight() < that.getWeight()) return -1;
        else if (this.getWeight() > that.getWeight()) return +1;
        else                                    return  0;
	}
	
	public String toString()
    {  return String.format("%d-%d %.2f", v, w, weightOfVector);  }

}
