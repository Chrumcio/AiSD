import java.util.ArrayList;

public class DisjointSet{

    int[] p;
    public DisjointSet(int size){
        p= new int[size];
        for (int i=0;i<p.length;i++){
        	p[i] = -1;
        }
    }
    
    public void union(int x,int y){
        int xrep=findSet(x);
        int yrep=findSet(y);
        p[xrep]=yrep;
    }
    
    public void makeSet(int x){
        p[x]=-1;
    }
    
    int findSet(int x){
    	if (p[x] == -1){
            return x;
        }else{
            p[x] = findSet(p[x]);
            return p[x];
        }
    }
    
    public void show(){
        System.out.print("   x:");
        for(int i=0; i<p.length;i++){
            System.out.printf("%3d", i);
        }
        System.out.print("\np[x]:");
        for(int i=0; i<p.length;i++){
            System.out.printf("%3d", p[i]);
        }
    }
    
    public void showSubsets(int x) {
    	ArrayList<Integer> lista=new ArrayList<>();
    	if(p[x]==-1){
    		lista.add(x);            
    		}else{
    			lista.add(x);
                showSubsets(p[x]);
            }
            for(int i=lista.size()-1;i>=0;i--){
                System.out.print(lista.get(i)+" -> ");
            }
        }
    
    public void setsReprezentation(){
    	for(int i=0;i<p.length;i++){
    		findSet(i);
    	}
    	System.out.println();
    	for( int i=0;i<p.length;i++){
    		if(p[i]==-1){
    			sets(i);
    			System.out.println();
    		}
    	}
    }
    
    public void sets(int i){
        if(p[i]==-1){
        	int counter=0;
            System.out.print(i);
            for (int j=0; j < p.length; j++) {
            	if(p[j]==i){
            		counter++;
                    if(counter>1){
                        System.out.println();
                        System.out.print("  ");
                    }
                    sets(j);
            	}
            } 
        }else{
            System.out.print("<-" + i);
            for (int j=0;j<p.length;j++){
                if (p[j]==i){
                    sets(j);
                }
            }
        }
    }
}