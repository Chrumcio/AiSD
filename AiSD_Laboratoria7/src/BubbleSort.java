
public class BubbleSort {
	private Comparator _comparator;
	int swaps;
	int porownania;
	
	public BubbleSort(Comparator comparator) {
		this._comparator=comparator;
	}
	
	public int[] sort(int[] tab) {
		for(int i=1;i<tab.length;i++) {
			for(int j=0;j<tab.length-i;j++) {
				if(_comparator.compare(tab[j], tab[j+1])>0) {
					swap(tab,j,j+1);
					swaps++;
				}
				porownania++;
			}
		}
		return tab;
	}
	
	public void swap(int[] tab,int left,int right) {
		int t=tab[left];
		tab[left]=tab[right];
		tab[right]=t;
	}
	
	public int getSwapy() {
		return swaps;
	}
	
	public void zerujSwapy() {
		this.swaps=0;
	}
	
	public int getporownania() {
		return porownania;
	}

	public void wyczycscPorownania() {
		porownania = 0;
	}
	
	public String toString() {
		return String.format("%10s %2s %2s", porownania,"|", swaps);
	}
}
