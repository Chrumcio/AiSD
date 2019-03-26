import java.util.ArrayList;
import java.util.LinkedList;
public class List {
	private int V;                  
    private LinkedList<Vertex> vertexes;

    List(){
        V = 0;
        vertexes = new LinkedList<>();
    }
    
    void addVertex(int id,String nazwa){
        vertexes.add(new Vertex(id,nazwa));
        V++;
    }
    
    void addEdge(int v,String v1,int w,String w1)
    {
        if(v!=w){
            LinkedList<String> adj = findVertex(v).adj;
            boolean exist = false;
            for (int i=0;i<adj.size();i++) {
                if(i == v){
                    exist = true;
                    break;
                }
            }
            if(exist==false){
                adj.add(w1);
            }
            adj=findVertex(w).adj;
           // LinkedList<String> adj2 = findVertex(w).adj;

            boolean ex = false;
            for (int j=0;j<adj.size();j++) {
                if(j == w){
                    ex = true;
                    break;
                }
            }
            if(ex==false){
                adj.add(v1);
            }
        }
    }
    
    Vertex findVertex(int id){
        for (Vertex v : vertexes) {
            if(v.id == id){
                return v;
            }
        }
        return null;
    }
    
    void print(){
        for (Vertex v : vertexes) System.out.println(v);
      }
    
  /* void BFS(int s) {

        System.out.println("Przeszukiwanie wszerz dla " + s );
        for (Vertex v: vertexes) {
            v.visited = false;
        }

        LinkedList<Vertex> queue = new LinkedList<>();

        Vertex sv = findVertex(s);
        sv.visited = true;
        queue.add(sv);

        String b = "";

        while (queue.size() != 0)
        {
            System.out.println(queue);
            Vertex w = queue.poll();
            b += w.id + " ";

         //   for (Integer i : w.adj ) {
           for(int i=0;i<queue.size();i++) {
            	Vertex x = findVertex(i);
                if(!x.visited) {
                    x.visited = true;
                    queue.add(x);
                }
            }
        }
        System.out.println(b);
    }
    

    void DFS2(int s) {

        System.out.println("Przeszukiwanie w g³¹b dla " + s );
        for (Vertex v: vertexes) {
            v.visited = false;
        }

        LinkedList<Vertex> queue = new LinkedList<>();

        Vertex sv = findVertex(s);
        sv.visited = true;
        queue.add(sv);

        String b = "";

        while (queue.size() != 0)
        {
            System.out.println(queue);
            Vertex w = queue.pollLast();
            b += w.id + " ";

            //for (Integer i : w.adj ) {
              for(int i=0;i<queue.size();i++) {
            	Vertex x = findVertex(i);
                if(!x.visited) {
                    x.visited = true;
                    queue.add(x);
                }
            }
        }
        System.out.println(b);
        System.out.println("---");
        for (Vertex v: vertexes) {
            if(v.visited == false)
                System.out.println(v.id);
        }
    }
	*/
	class Vertex{
        int id;
        String nazwa;
        LinkedList<String> adj;
        boolean visited = false;

        Vertex(int id,String nazwa){
            this.id = id;
            this.nazwa=nazwa;
            adj = new LinkedList<>();
        }

        public void setAdjency(String v) {
            adj.add(v);
        }

        @Override
        public String toString() {
            return "("+ nazwa +") -> " + adj;
        }
    }
	
	public static void main(String[] args) {
		List l=new List();
		l.addVertex(0, "o");
		l.addVertex(1, "a");
		l.addVertex(2, "b");
		l.addVertex(3, "c");
		l.addVertex(4, "d");
		l.addVertex(5, "e");
		l.addVertex(6, "f");
		l.addVertex(7, "g");
	/*	l.addEdge(1, "a", 2, "b");
		l.addEdge(2, "b", 3, "c");
		l.addEdge(5, "e", 6, "f");
		l.addEdge(2, "b", 5, "e");*/
		l.addEdge(0, "o", 4, "d");
		l.addEdge(2, "b", 4, "d");
		l.addEdge(2, "b", 5, "e");
		l.addEdge(5, "e", 6, "f");
		l.addEdge(4, "d", 7, "g");
		l.addEdge(7, "g", 3, "c");
		l.print();
	}
}
