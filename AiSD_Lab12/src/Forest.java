public class Forest {
	Forest(){
		
	}

    public void makeSet(Node node){
        node.parent=node;
        node.height = 0;
    }

    public Node findSet(Node node){ 
    	if(node!=node.parent)
			node.parent=findSet(node.parent);
    	return node.parent;                          
    }

    public void union(Node node1, Node node2){
        Node xnode=findSet(node1);
        Node ynode=findSet(node2);
        if(xnode.height > ynode.height){
            ynode.parent = xnode;
        }else if(xnode.height < ynode.height){
            xnode.parent = ynode;
        }else if(xnode!=ynode){
            ynode.parent = xnode;
            xnode.height = xnode.height + 1;
        }
    }
    
    static class Node{
        Node parent;
        int height;
        int value;
        Node(int v){
            value = v;
        }

        @Override
        public String toString() {
            return parent.value + " jest rodzicem " + value;
        }
    }
    
    public static void main(String[] args) {
    	Forest f=new Forest();
    	Node []tab=new Node[10];
    	for(int i=0;i<tab.length;i++) {
    		tab[i]=new Node(i);
    		f.makeSet(tab[i]);
    	}
    	System.out.println("Ogolne zalozenie:  rodzic <- element");
    	System.out.println("Tworzymy zbiory 2 elementowe:");
    	f.union(tab[0], tab[1]);
    	f.union(tab[2], tab[3]);
    	f.union(tab[4], tab[5]);
    	f.union(tab[6], tab[7]);
    	f.union(tab[8], tab[9]);
    	for(int i=0;i<tab.length;i++) {
    		//System.out.println(tab[i]);
    		if(tab[i].value==0 || tab[i].value==2 || tab[i].value==4 || tab[i].value==6 || tab[i].value==8)
    			System.out.print(tab[i].value);
    		System.out.println(" <- "+tab[i].value);
    	}
       	System.out.println("Z rownowazeniem wysokosci: ");
    	f.union(tab[0], tab[3]);
    	f.union(tab[5], tab[7]);
    	f.union(tab[8], tab[0]);
    	for(int i=0;i<tab.length;i++) {
    		System.out.println(tab[i].parent.value+" <- "+tab[i].value);
    		//System.out.println(tab[i]);
    	}
    	//f.union(tab[0], tab[4]);
    	System.out.println("Z kompresja sciezki: ");
    	for(int i=0;i<tab.length;i++) {
    		f.findSet(tab[i]);
    		//System.out.println(tab[i]);
    		if(tab[i].value==0)
    			System.out.print(tab[i].value);
    		else if(tab[i].parent.value==0)
    			System.out.println(" <- "+tab[i].value);
    	}
    	
    	if(tab[4].parent.value!=0) {
    		for(int i=0;i<tab.length;i++) {
    			if(tab[i].value==4)
    				System.out.print(tab[i].value);
    			else if(tab[i].parent.value==4)
    				System.out.println(" <- "+tab[i].value);
    		}    
    	}    	
    }
}