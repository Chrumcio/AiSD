import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraShortestPath {
	class DistanceToEdge implements Comparable<DistanceToEdge> {
		private final int edge;
		private int distance;
 
		public DistanceToEdge(int edge, int distance) {
			this.edge = edge;
			this.distance = distance;
		}
 
		public int getDistance() {
			return distance;
		}
 
		public void setDistance(int distance) {
			this.distance = distance;
		}
 
		public int getEdge() {
			return edge;
		}
 
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + (int) (distance ^ (distance >>> 32));
			result = prime * result + edge;
			return result;
		}
 
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DistanceToEdge other = (DistanceToEdge) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (distance != other.distance)
				return false;
			if (edge != other.edge)
				return false;
			return true;
		}
 
		@Override
		public int compareTo(DistanceToEdge param) {
			int cmp = new Integer(distance).compareTo(param.getDistance());
 
			if (cmp == 0) {
				return new Integer(edge).compareTo(param.getEdge());
			}
			return 0;
		}
 
		private DijkstraShortestPath getOuterType() {
			return DijkstraShortestPath.this;
		}
	}

	private DirectedEdge[] edgeTo; //przechowuje krawedz z ktorej jest najblizej do biezacej okreslonej indeksem tablicy
	private int[] distanceTo;		//przechowuje najkrotsze znalezione odleglosci do danego wierzcholka
	private Queue<DistanceToEdge> priorityQueue;	//kolejka przechowujaca biezace krawedzie uszeregowane od najkrotszej do najdluzszej
 
	public DijkstraShortestPath(DirectedGraph graph, int source) {
		edgeTo=new DirectedEdge[graph.getNumberOfVertices()];
		distanceTo=new int[graph.getNumberOfVertices()];
		priorityQueue=new PriorityQueue<DistanceToEdge>(graph.getNumberOfVertices());
		for(int v=0;v<graph.getNumberOfVertices();v++) {
			distanceTo[v]=Integer.MAX_VALUE;
		}
		distanceTo[source]=0; //odleglosc do zrodla 0
		priorityQueue.offer(new DistanceToEdge(source, 0));
		while(!priorityQueue.isEmpty()) {
			relax(graph, priorityQueue.poll().getEdge());
		}
	}
 
	private void relax(DirectedGraph graph, int v) {
		for(DirectedEdge edge:graph.getNeighborhoodList(v)) {
			int w=edge.to();
			if (distanceTo[w]>distanceTo[v]+edge.getWeight()) {
				distanceTo[w]=(int) (distanceTo[v]+edge.getWeight());
				edgeTo[w]=edge;
				DistanceToEdge dte=new DistanceToEdge(w,distanceTo[w]);
				priorityQueue.remove(dte);
				priorityQueue.offer(dte);
			}
		}
	}
	
	public int getDistanceTo(int v) {	
		return distanceTo[v];
	}
 
	public boolean hasPathTo(int v) {
		return distanceTo[v] < Long.MAX_VALUE;
	}
 
	public Iterable<DirectedEdge> getPathTo(int v) {
		Deque<DirectedEdge> path = new ArrayDeque<DirectedEdge>();
		if (!hasPathTo(v)) {
			return path;
		}
		for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}
 
	public static void main(String[] args) {
		DirectedGraph graph = new DirectedGraph(7);

		graph.addEdge(new DirectedEdge(0, 1, 3));
		graph.addEdge(new DirectedEdge(0, 2, 2));
		graph.addEdge(new DirectedEdge(0, 4, 9));
		graph.addEdge(new DirectedEdge(1, 4, 7));
		graph.addEdge(new DirectedEdge(2, 6, 4));
		graph.addEdge(new DirectedEdge(6, 3, 1));
		graph.addEdge(new DirectedEdge(3, 4, 4));
		graph.addEdge(new DirectedEdge(2, 5, 18));
		graph.addEdge(new DirectedEdge(3, 5, 12));
		int source = 0;
		DijkstraShortestPath shortestPath = new DijkstraShortestPath(graph,source);
 
		for (int target = 0; target < graph.getNumberOfVertices(); target++) {
			if (shortestPath.hasPathTo(target)) {
				System.out.printf("%d do %d Dlugosc sciezki = %d   ", source, target,shortestPath.getDistanceTo(target));
				if (shortestPath.hasPathTo(target)) {
					for (DirectedEdge edge : shortestPath.getPathTo(target)) {
						System.out.print(edge);
					}
				}
			} else {
				System.out.printf("%d do %d - brak sciezki  ", source, target);
			}
			System.out.println();
		}
	}
}