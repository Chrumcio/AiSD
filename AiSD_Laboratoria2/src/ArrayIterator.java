import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator <T> implements Iterator<T>{
	private T tab[];
	private int pos=0;
	
	public ArrayIterator(T []tablica) {
		this.tab=tablica;
	}
	public boolean hasNext() {
		return pos<tab.length;
	}

	public T next() throws NoSuchElementException {
		if(hasNext()) {
			return tab[pos++];
		}else {
			throw new NoSuchElementException();
		}
		
	}

}
