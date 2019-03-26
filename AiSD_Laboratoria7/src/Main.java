
public class Main{
	
	public void losujliczbydotabeli(int[] tab) {
		for(int i=0;i<tab.length;i++) {
			double a = Math.random()*1000;
			int b=(int)a;
			tab[i]=b;
		}
	}
	
	public void tabelaPosortowana(int[] tab) {
		int j=100;
		for(int i=0;i<tab.length;i++) {
			tab[i]=j;
			j++;
		}
	}
	
	public void tabelaPosortowanaOdwrotnie(int[] tab) {
		int j=1000;
		for(int i=0;i<tab.length;i++) {
			tab[i]=j;
			j--;
		}
	}

	public static void main(String[] args) {
		IntComparator comparator=new IntComparator();
		Main main=new Main();
		BubbleSort b=new BubbleSort(comparator);
		
		//Tablice nieposortowane
		int[] tab1=new int[8];
		System.out.println(String.format("%10s %20s %10s %1s", "Sortowanie |", "Wielkosc tablicy |", "Porownania |","Swaps" ));
		main.losujliczbydotabeli(tab1);
		b.sort(tab1);
		System.out.println(String.format("%10s %3s %5s ", "BubbleSort |", tab1.length,"nieposortowana |"+b.toString()));
		b.wyczycscPorownania();
		b.zerujSwapy();
		
		int[] tab2=new int[32];
		main.losujliczbydotabeli(tab2);
		b.sort(tab2);
		System.out.println(String.format("%10s %3s %5s  ", "BubbleSort |", tab2.length,"nieposortowana |"+b.toString()));
		b.wyczycscPorownania();
		b.zerujSwapy();
		
		int[] tab3=new int[128];
		main.losujliczbydotabeli(tab3);
		b.sort(tab3);
		System.out.println(String.format("%10s %3s %5s  ", "BubbleSort |", tab3.length,"nieposortowana |"+b.toString()));
		b.wyczycscPorownania();
		b.zerujSwapy();
		
		//Tablice posortowane
		main.tabelaPosortowana(tab1);
		main.tabelaPosortowana(tab2);
		main.tabelaPosortowana(tab3);
		b.sort(tab1);
		System.out.println(String.format("%10s %3s %32s ", "BubbleSort |", tab1.length,"posortowana |"+b.toString()));
		b.wyczycscPorownania();
		b.zerujSwapy();
		
		b.sort(tab2);
		System.out.println(String.format("%10s %3s %32s ", "BubbleSort |", tab2.length,"posortowana |"+b.toString()));
		b.wyczycscPorownania();
		b.zerujSwapy();
		
		b.sort(tab3);
		System.out.println(String.format("%10s %3s %32s  ", "BubbleSort |",tab3.length, "posortowana |"+b.toString()));
		b.wyczycscPorownania();
		b.zerujSwapy();
		
		//Tabele posortowane odwrotnie
		main.tabelaPosortowanaOdwrotnie(tab1);
		main.tabelaPosortowanaOdwrotnie(tab2);
		main.tabelaPosortowanaOdwrotnie(tab3);
		b.sort(tab1);
		System.out.println(String.format("%10s %3s %32s ", "BubbleSort |", tab1.length,"odwrotnie |"+b.toString()));
		b.wyczycscPorownania();
		b.zerujSwapy();
		
		b.sort(tab2);
		System.out.println(String.format("%10s %3s %33s ", "BubbleSort |", tab2.length,"odwrotnie |"+b.toString()));
		b.wyczycscPorownania();
		b.zerujSwapy();
		
		b.sort(tab3);
		System.out.println(String.format("%10s %3s %34s  ", "BubbleSort |",tab3.length, "odwrotnie |"+b.toString()));
		b.wyczycscPorownania();
		b.zerujSwapy();
		
		
		MergeSort m=new MergeSort(comparator);
		
		//Tablice nieposortowane
		main.losujliczbydotabeli(tab1);
		main.losujliczbydotabeli(tab2);
		main.losujliczbydotabeli(tab3);
		
		m.sort(tab1);
		System.out.println(String.format("%11s %3s %5s ", "MergeSort  |", tab1.length,"nieposortowana |"+m.toString()));
		m.zerujPorownania();
		m.zerujSwaps();
		
		m.sort(tab2);
		System.out.println(String.format("%11s %3s %5s ", "MergeSort  |", tab2.length,"nieposortowana |"+m.toString()));
		m.zerujPorownania();
		m.zerujSwaps();
		
		m.sort(tab3);
		System.out.println(String.format("%11s %3s %5s ", "MergeSort  |", tab3.length,"nieposortowana |"+m.toString()));
		m.zerujPorownania();
		m.zerujSwaps();
		
		
		//Tablice posortowane
		main.tabelaPosortowana(tab1);
		main.tabelaPosortowana(tab2);
		main.tabelaPosortowana(tab3);
		m.sort(tab1);
		System.out.println(String.format("%11s %3s %32s ", "MergeSort  |", tab1.length,"posortowana |"+m.toString()));
		m.zerujPorownania();
		m.zerujSwaps();
		
		m.sort(tab2);
		System.out.println(String.format("%11s %3s %33s ", "MergeSort  |", tab2.length,"posortowana |"+m.toString()));
		m.zerujPorownania();
		m.zerujSwaps();
		
		m.sort(tab3);
		System.out.println(String.format("%11s %3s %33s ", "MergeSort  |", tab3.length,"posortowana |"+m.toString()));
		m.zerujPorownania();
		m.zerujSwaps();
		
		//Tablice posortowane odwrotnie
		main.tabelaPosortowanaOdwrotnie(tab1);
		main.tabelaPosortowanaOdwrotnie(tab2);
		main.tabelaPosortowanaOdwrotnie(tab3);
		m.sort(tab1);
		System.out.println(String.format("%11s %3s %32s ", "MergeSort  |", tab1.length,"odwrotnie |"+m.toString()));
		m.zerujPorownania();
		m.zerujSwaps();
		
		m.sort(tab2);
		System.out.println(String.format("%11s %3s %33s ", "MergeSort  |", tab2.length,"odwrotnie |"+m.toString()));
		m.zerujPorownania();
		m.zerujSwaps();
		
		m.sort(tab3);
		System.out.println(String.format("%11s %3s %33s ", "MergeSort  |", tab3.length,"odwrotnie |"+m.toString()));
		m.zerujPorownania();
		m.zerujSwaps();
		
		//Przyklad sortowania BubbleSort
		/*main.losujliczbydotabeli(tab2);
		System.out.println("Tablica nieposortowana");
		for(int i=0;i<tab2.length;i++) {
			System.out.print(tab2[i]+" ");
		}
		System.out.println();
		Comparator licz =new IntComparator();
		BubbleSort s=new BubbleSort(licz);
		s.sort(tab2);
		System.out.println("Tablica posortowana, sortowanie bombelkowe");
		for(int i=0;i<tab2.length;i++)
			System.out.print(tab2[i]+" ");
		
		
		//Przyklad sortowania MergeSort
		main.losujliczbydotabeli(tab2);
		System.out.println();
		System.out.println("Tablica nieposortowana");
		for(int i=0;i<tab2.length;i++) {
			System.out.print(tab2[i]+" ");
		}
		System.out.println();
		System.out.println("Posortowana tablica, sortowanie przez ³¹czenie");
		tab2=m.sort(tab2);
		for(int i=0;i<tab2.length;i++) {
			System.out.print(tab2[i]+" ");
		}
		*/
	}
}
