import java.util.ArrayList;
import java.util.PriorityQueue;
 
public class WeightedGraph {
 
    ArrayList<Vertex> verticies=new ArrayList<>();
    ArrayList<Edge> edges=new ArrayList<>();
 
    class Vertex{
        int name;
        int d;
        Vertex p;
 
        public Vertex(int n){
            name=n;
        }
    }
    
    class Edge{
        Vertex ver1;
        Vertex ver2;
        int w;

        public Edge(Vertex v1, Vertex v2, int w){
            ver1=v1;
            ver2=v2;
            this.w=w;
        }
    }
    public void addVertex(int name){
        verticies.add(new Vertex(name));
    }
    
    public void addEdge(int v1, int  v2, int w ){
       Vertex vertex1=null;
       Vertex vertex2=null;
        for(Vertex v:verticies){
            if (v.name==v1) {
                vertex1=v;
            }
            if (v.name==v2){
                vertex2=v;
            }
        }
            if(vertex1!=null&&vertex2!=null){
                Edge newEdge= new Edge(vertex1,vertex2,w);
                if(!edges.contains(newEdge)){
                edges.add(newEdge);
                }
            }
    }
    
    public void showEdges(){
        for(Edge e:edges){
            System.out.println(e.ver1.name+"--w:"+e.w+"--"+e.ver2.name);
        }
    }
    
    public void sort(){
    	for(int i=0;i<edges.size();i++) {
    		for(int j=i+1;j<edges.size();j++) {
    			if(edges.get(i).w>edges.get(j).w) {
    				Edge e=edges.get(i);
    				edges.set(i, edges.get(j));
    				edges.set(j, e);
    			}
    		}
    	}
    }
    
    public ArrayList<Edge> Kruskal(){
        int sumaWag=0;
        ArrayList<Edge> A= new ArrayList<>();
        DisjointSet zbiory = new DisjointSet(verticies.size());
        sort();
        for(Edge e:edges){
            if(zbiory.findSet(e.ver1.name)!=zbiory.findSet(e.ver2.name)){
                A.add(e);
                System.out.println(e.ver1.name+"----"+e.ver2.name);
                zbiory.union(e.ver1.name,e.ver2.name);
                sumaWag+=e.w;
            }
        }
        System.out.println("suma wag: "+sumaWag);
        return A;
    }
    
    public static void main(String[] args) {
    	WeightedGraph w=new WeightedGraph();
   
    	w.addVertex(0);
    	w.addVertex(1);
    	w.addVertex(2);
    	w.addVertex(3);
    	w.addVertex(4);
    	w.addVertex(5);
    	w.addVertex(6);
    	w.addEdge(0, 1, 3);
    	w.addEdge(0, 2, 2);
    	w.addEdge(0, 4, 9);
    	w.addEdge(1, 4, 7);
    	w.addEdge(2, 6, 5);
    	w.addEdge(6, 3, 1);
    	w.addEdge(3, 4, 4);
    	w.addEdge(2, 5, 18);
    	w.addEdge(3, 5, 12);
    	w.Kruskal();
    	
    	
    }
}