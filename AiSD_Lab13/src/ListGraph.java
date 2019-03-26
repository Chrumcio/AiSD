import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ListGraph {
    private int V;                  
    private LinkedList<Vertex> vertexes;

    ListGraph(){
        V = 0;
        vertexes = new LinkedList<>();
    }

    void addVertex(int id,String nazwa){
        vertexes.add(new Vertex(id,nazwa));
        V++;
    }

    void addEdge(int v,int w)
    {
        if(v!=w){
            LinkedList<Integer> adj = findVertex(v).adj;
            boolean exist = false;
            for (Integer i : adj) {
                if(i == w){
                    exist = true;
                    break;
                }
            }
            if(!exist){
                adj.add(w);
            }

            LinkedList<Integer> adj2 = findVertex(w).adj;

            exist = false;
            for (Integer i : adj2) {
                if(i == v){
                    exist = true;
                    break;
                }
            }
            if(!exist){
                adj2.add(v);
            }
        }
    }

    void print(){
        for (Vertex v : vertexes) System.out.println(v);
      }

    void print(int id){
        System.out.println(findVertex(id));
    }
    
    Vertex findVertex(int id){
        for (Vertex v : vertexes) {
            if(v.id == id){
                return v;
            }
        }
        return null;
    }


    class Vertex{
        int id;
        String nazwa;
        LinkedList<Integer> adj;

        Vertex(int id,String nazwa){
            this.id = id;
            this.nazwa=nazwa;
            adj = new LinkedList<>();
        }

        public void setAdjency(int v) {
            adj.add(v);
        }

        @Override
        public String toString() {
            return "("+ nazwa +") -> " + adj;
        }
    }
    
    public static void main(String[] args) {
    	ListGraph l=new ListGraph();
    	l.addVertex(0,"a");
    	l.addVertex(1,"b");
    	l.addVertex(2,"c");
    	l.addVertex(3,"d");
    	l.addVertex(4,"e");
    	l.addVertex(5,"f");
    	l.addEdge(0, 1);
    	l.addEdge(1, 2);
    	l.addEdge(2, 3);
    	l.addEdge(3, 4);
    	l.addEdge(4, 5);
    	l.print();
    }

}
