//na nastepnych zajeciach grafy
public class Tablicowe {
	int tab[];	
	public Tablicowe(){
			tab=new int[0];
		}
	public Tablicowe(int j) {
		tab=new int[j];
		for(int i=0;i<j;i++) {
			tab[i]=-2;
		}
	}
	public void MakeSet(int a) {
		
		if(tab[a]==-2) {
			tab[a]=-1;
		}
		else {
			System.out.println(a+"-ty element jest juz elementem zbioru");
		}
	}
	public void Union(int x,int y) {
		tab[y]=x;
		
	}

	public void wypisz() {
		System.out.println();
		for(int i=0;i<tab.length;i++) {
			if(tab[i]==-1) {
				System.out.printf(i+"");
				wypiszHelp(i);
				System.out.println();
			}
		}
	}
	public void wypiszHelp(int i) {
		for(int ii=0;ii<tab.length;ii++) {
			if(tab[ii]==i) {
			System.out.printf(" <- "+ii+" ");
			
			wypiszHelp(ii);
			System.out.println("");
			System.out.printf("   ");
			}
			
		}
	}
	public int findSet(int y) {
		if(tab[y]==-2) {
			return -2;
		}
		else if(tab[y]==-1) {
			return y;
		}
		else {
			return findSet(tab[y]);
		}
	}
	
	public void findSet2(int y) {
		int z=findSet(y);
		if(tab[y]==-2) {
			
		}
		else if(tab[y]==-1) {
		}
		else {
			findSet2(tab[y]);
			tab[y]=z;
			//System.out.println(tab[y]+" <- "+y);
		}
		return ;
	}
	
	public void wypisz1() {
		for(int i=0;i<tab.length;i++) {
			System.out.print(tab[i]+" ");
		}
	}
	public void wypisz2() {
		for(int i=0;i<tab.length;i++) {
			if(tab[i]!=-2 && tab[i]!=-1) {
				System.out.print(i+" jest w zbiorze: "+tab[i]);
				System.out.println();
			}else if(tab[i]==-1) {
				System.out.print(i+" jest w zbiorze: "+i);
				System.out.println();
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Tablicowe tab = new Tablicowe(20);
		tab.MakeSet(4);
		tab.MakeSet(6);
		tab.MakeSet(2);
		tab.MakeSet(1);
		tab.MakeSet(5);
		tab.MakeSet(3);
		tab.MakeSet(8);
		tab.MakeSet(9);
		tab.MakeSet(10);
		tab.wypisz1();
		tab.Union(3, 5);
		tab.Union(4, 6);
		System.out.println();
		tab.Union(2, 4);
		tab.Union(1, 2);
		tab.Union(8, 9);
		tab.Union(1, 2);
		System.out.println();
		System.out.println("reprezentant <- element");
		tab.wypisz();
		tab.wypisz1();
		System.out.println();
		//tab.wypisz2();
		tab.findSet2(6);
		tab.findSet2(4);
		System.out.println();
		System.out.println("Po kompresji sciezki: ");
		tab.wypisz();
		//tab.wypisz2();
		//System.out.println();
		tab.wypisz1();
		
	}
}
	