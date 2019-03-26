import java.util.ArrayList;
import java.util.List;
 
public class DirectedEdge {

	private final int from;
	private final int to;
	private final long weight;
 
	public DirectedEdge(int from, int to, int weight){
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
 
	public int from() {
		return from;
	}
 
	public int to() {
		return to;
	}
 
	public long getWeight() {
		return weight;
	}
 
	@Override
	public String toString() {
		return String.format("%d->%d (%d) ", from, to, weight);
	}
}

	class DirectedGraph {
		private final int v;
		private int e;

		private List<DirectedEdge>[] neighborhoodLists;
 
		@SuppressWarnings("unchecked")
		public DirectedGraph(int v) {
			this.v = v;
			this.e = 0;
			this.neighborhoodLists = (List<DirectedEdge>[]) new List[v];
			for (int i = 0; i < v; i++) {
				neighborhoodLists[i] = new ArrayList<DirectedEdge>();
			}
		}
 
		public int getNumberOfEdges() {
			return e;
		}
 
		public int getNumberOfVertices() {
			return v;
		}
 
		public void addEdge(DirectedEdge edge) {
			neighborhoodLists[edge.from()].add(edge);
			e++;
		}
 
		public Iterable<DirectedEdge> getNeighborhoodList(int v) {
			return neighborhoodLists[v];
		}
	}