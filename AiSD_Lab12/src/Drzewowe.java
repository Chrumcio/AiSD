//z kompresja sciezki
public class Drzewowe {
	int [] tab;
	
	Drzewowe(){
	}

	public void MakeSet(Node node) {
		node.parent=node;
		node.ranga=0;
	}
	
	public Node findSet(Node node) {
		if(node!=node.parent)
			node.parent=findSet(node.parent);
		return node.parent;
	}
	
	public void unionSets(Node nodex,Node nodey) {
		Node rnodex;
		Node ynodex;
		
		rnodex=findSet(nodex);
		ynodex=findSet(nodey);
		if(rnodex!=ynodex) {
			if(rnodex.ranga>ynodex.ranga) {
				ynodex.parent=rnodex;
			}else {
				rnodex.parent=ynodex;
				if(rnodex.ranga==ynodex.ranga)
					ynodex.ranga++;
			}
		}
	}
	
	static class Node{
		int key;
		int ranga;
		Node parent;
		
		Node(int key){
			this.key=key;
		}
	}
	
	public static void main(String[] args) {
		Drzewowe d=new Drzewowe();
		Node [] tab=new Node[10];
		for(int i=0;i<tab.length;i++) {
			tab[i]=new Node(i);
			d.MakeSet(tab[i]);
		}
		
		for(int i=0;i<tab.length;i++) {
			System.out.print(tab[i].key+" ");
		}
		d.unionSets(tab[0], tab[1]);
		d.unionSets(tab[2], tab[3]);
		d.unionSets(tab[4], tab[5]);
		d.unionSets(tab[6], tab[7]);
		d.unionSets(tab[8], tab[1]);
		d.unionSets(tab[9], tab[1]);
		System.out.println(tab[1].ranga);
		//d.unionSets(tab[1], tab[5]);
		System.out.println();
		
		for(int i=0;i<tab.length;i++) {
			System.out.print(d.findSet(tab[i]).parent.key+" ");
		}		
	}
}
