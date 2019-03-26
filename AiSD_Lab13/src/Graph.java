
public class Graph {
	int [][] tab;
	String [] tab1;
	int top;
	int top1;
	
	public Graph() {
		this.tab=new int[0][0];
		this.tab1=new String[100];
	}
	
	public void addTop(String n) {
		tab1[top1]=n;
		top1++;
		top++;
		int[][]tmp=new int[top][top];
		for(int i=0;i<tab.length;i++) {
			for(int j=0;j<tab.length;j++) {
				tmp[i][j]=tab[i][j];
			}
		}
		tab=tmp;
	}
	
	public void addEdge(int v1,int v2) {
		if(v1==v2)
			return;
		tab[v1][v2]=1;
		tab[v2][v1]=1;
		
	}
	
	public void wypisz() {
		System.out.print("  ");
		for(int i=0;i<top;i++) {
			System.out.print(tab1[i]+" ");
		}
		System.out.println();
		for(int i=0;i<top;i++) {
			System.out.print(tab1[i]+" ");
			for(int j=0;j<top;j++) {
				System.out.print(tab[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Graph g=new Graph();
		g.addTop("a");
		g.addTop("b");
		g.addTop("c");
		g.addTop("d");
		g.addTop("e");
		g.addTop("f");
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 2);
		g.addEdge(1, 3);
		g.addEdge(3, 1);
		g.addEdge(2, 4);
		g.addEdge(4, 0);
		g.addEdge(4, 3);
		g.wypisz();
	}
}
